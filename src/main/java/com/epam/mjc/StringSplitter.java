package com.epam.mjc;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class StringSplitter {

	/**
	 * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
	 *
	 * @param source source string
	 * @param delimiters collection of delimiter strings
	 * @return List of substrings
	 */
	public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
		String[] splittedString = source.split(delimiters.toString());
		List<String> splittedStringList = new ArrayList<>();
		for (int i = 0; i < splittedString.length; ++i) {
			splittedStringList.add(splittedString[i]);
		}
		return splittedStringList;
	}
}
