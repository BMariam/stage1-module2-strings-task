package com.epam.mjc;

import java.util.List;
import java.util.ArrayList;

public class MethodParser {

	/**
	 * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
	 * signatureString is a java-like method signature with following parts:
	 *      1. access modifier - optional, followed by space: ' '
	 *      2. return type - followed by space: ' '
	 *      3. method name
	 *      4. arguments - surrounded with braces: '()' and separated by commas: ','
	 * Each argument consists of argument type and argument name, separated by space: ' '.
	 * Examples:
	 *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
	 *      private void log(String value)
	 *      Vector3 distort(int x, int y, int z, float magnitude)
	 *      public DateTime getCurrentDateTime()
	 *
	 * @param signatureString source string to parse
	 * @return {@link MethodSignature} object filled with parsed values from source string
	 */
	public MethodSignature parseFunction(String signatureString) {
		int argumentIndex = signatureString.indexOf("(");
		String methodTypeAndName = signatureString.substring(0, argumentIndex);
		String methodArguments = signatureString.substring(argumentIndex).replace("(", "").replace(")", "").replace(",", "");

		List<MethodSignature.Argument> argumentsList = new ArrayList<>();

		if (methodArguments.length() > 0) {
			String[] methodArgumentsSplitted = methodArguments.split(" ");
			int argumentsCount = methodArgumentsSplitted.length / 2;
			for (int i = 0; i < argumentsCount; ++i) {
				argumentsList.add(new MethodSignature.Argument(methodArgumentsSplitted[2 * i], methodArgumentsSplitted[2 * i + 1]));
			}
		}
		
		MethodSignature methodSignature = new MethodSignature("", argumentsList);

		String[] methodTypeAndNameSplitted = methodTypeAndName.split(" ");
		if (3 == methodTypeAndNameSplitted.length) {
			methodSignature.setAccessModifier(methodTypeAndNameSplitted[0]);
			methodSignature.setReturnType(methodTypeAndNameSplitted[1]);
			methodSignature.setMethodName(methodTypeAndNameSplitted[2]);
		} else if (2 == methodTypeAndNameSplitted.length) {
			methodSignature.setReturnType(methodTypeAndNameSplitted[0]);
			methodSignature.setMethodName(methodTypeAndNameSplitted[1]);
		}

		return methodSignature;
	}
}
