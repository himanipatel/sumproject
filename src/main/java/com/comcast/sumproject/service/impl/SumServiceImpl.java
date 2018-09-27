package com.comcast.sumproject.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import com.comcast.sumproject.service.SumService;

/**
 * SumServiceImpl: Business logic to do sum of digits
 * 
 * @author Himani Patel
 *
 */
public class SumServiceImpl implements SumService {

	/**
	 * @param str
	 *            accept string which contains alphanumeric values
	 * @return long sum: return sum in base 10
	 */
	public long getDigitsSum(String str) {
		if (str == null) {
			return 0;
		}

		long sum = 0;
		// loop through each string character
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (Character.isDigit(a)) {
				int b = Integer.parseInt(String.valueOf(a));
				sum = sum + b;
			}
		}
		return sum;
	}

	/**
	 * @param fileName
	 *            accept file name which contains string with alphanumeric
	 *            values
	 * @return long sum: return sum in base 10
	 */
	public long getDigitsSumFromFile(String fileName) throws IOException {
		long fileSum = 0;

		if (fileName == null) {
			return 0;
		}

		ClassLoader classLoader = getClass().getClassLoader();
		LineIterator fileContents = FileUtils.lineIterator(new File(classLoader.getResource(fileName).getFile()),
				"UTF-8");
		while (fileContents.hasNext()) {
			String line = fileContents.nextLine();
			fileSum = fileSum + getDigitsSum(line.trim());

		}
		return fileSum;
	}

	/**
	 * @param str
	 *            accept string containing mixture of alphabets and hexaedcimal
	 *            values
	 * @return long sum: return sum in base 10
	 */
	public long getHexDigitsSum(String str) {
		if (str == null) {
			return 0;
		}

		long sum = 0;

		for (int i = 0; i < str.length(); i++) {
			char a = str.toUpperCase().charAt(i);
			// check for hexadecimal digits
			if (Character.isDigit(a) || (a >= 'A' && a <= 'F')) {
				// get integer value of hex digit
				int b = Integer.parseInt(String.valueOf(a), 16);
				sum = sum + b;
			}
		}
		return sum;
	}

}
