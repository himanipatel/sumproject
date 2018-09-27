package com.comcast.sumproject;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.comcast.sumproject.service.SumService;
import com.comcast.sumproject.service.impl.SumServiceImpl;
import com.comcast.sumproject.util.ConfigPropertyManager;

/**
 * SumServiceImplTest class to test business logic with various inputs
 * 
 * @author Himani Patel
 *
 */
public class SumServiceImplTest {

	/*
	 * Decimal digits sum test cases - started
	 */

	@Test
	public void testGetDigitsSumValidStr1() {
		// valid string with numbers
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = "abc123";
		long sum = objSumService.getDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 6);
	}

	@Test
	public void testGetDigitsSumValidStr2() {
		// valid string with numbers
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = "   98  hi60  ";
		long sum = objSumService.getDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 23);
	}

	@Test
	public void testGetDigitsSumStrWithoutDigits() {
		// string without digits
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = "no numbers";
		long sum = objSumService.getDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 0);
	}

	@Test
	public void testGetDigitsSumEmptyString() {
		// empty string
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = "";
		long sum = objSumService.getDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 0);
	}

	@Test
	public void testGetDigitsSumNULLString() {
		// NULL string
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = null;
		long sum = objSumService.getDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 0);
	}

	@Test
	public void testGetDigitsSumLargeValue() {
		// long string
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = "   test 99999999 \n 45676875467864785643786 578346578";
		long sum = objSumService.getDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 262);
	}

	/*
	 * Hexadecimal digits sum test cases - started
	 */

	@Test
	public void testgetHexDigitsSumValidStr1() {
		// valid string with numbers
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = "abc123";
		long sum = objSumService.getHexDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 39);
	}

	@Test
	public void testgetHexDigitsSumValidStr2() {
		// valid string with numbers
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = " fbc 123    ";
		long sum = objSumService.getHexDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 44);
	}

	@Test
	public void testgetHexDigitsSumValidStr3() {
		// non-hexadecimal values
		SumService objSumService = new SumServiceImpl();
		// ignore t,s and space characters
		String mockInputStr = " test fbc 123    ";
		long sum = objSumService.getHexDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 58);
	}

	@Test
	public void testgetHexDigitsSumEmptyStr() {
		// empty string
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = "    ";
		long sum = objSumService.getHexDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 0);
	}

	@Test
	public void testgetHexDigitsSumNULLStr() {
		// NULL string
		SumService objSumService = new SumServiceImpl();
		String mockInputStr = null;
		long sum = objSumService.getHexDigitsSum(mockInputStr);
		Assert.assertTrue(sum == 0);
	}

	/*
	 * Read from file test cases - started
	 */

	@Test
	public void testGetDigitsSumFromFile() throws IOException {
		// valid file with valid values
		SumService objSumService = new SumServiceImpl();
		String fileName = ConfigPropertyManager.getInstance().getProperty("file.name");
		long sum = objSumService.getDigitsSumFromFile(fileName);
		Assert.assertTrue(sum == 18);
	}

	@Test
	public void testGetDigitsSumFromEmptyFile() throws IOException {
		// File is empty
		SumService objSumService = new SumServiceImpl();
		String fileName = ConfigPropertyManager.getInstance().getProperty("testfile1.name");
		long sum = objSumService.getDigitsSumFromFile(fileName);
		Assert.assertTrue(sum == 0);
	}

	@Test
	public void testGetDigitsSumFromFileWithoutDigits() throws IOException {
		// File contains no digits
		SumService objSumService = new SumServiceImpl();
		String fileName = ConfigPropertyManager.getInstance().getProperty("testfile2.name");
		long sum = objSumService.getDigitsSumFromFile(fileName);
		Assert.assertTrue(sum == 0);
	}

	@Test
	public void testGetDigitsSumFromFileNULL() throws IOException {
		// File name is null
		SumService objSumService = new SumServiceImpl();
		String fileName = null;
		long sum = objSumService.getDigitsSumFromFile(fileName);
		Assert.assertTrue(sum == 0);
	}

	@Test(expected = NullPointerException.class)
	public void testGetDigitsSumFromFileNotExistL() throws IOException {
		// File name is null
		SumService objSumService = new SumServiceImpl();
		String fileName = ConfigPropertyManager.getInstance().getProperty("testfile3.name");
		;
		long sum = objSumService.getDigitsSumFromFile(fileName);
	}

	@Test
	public void testGetDigitsSumFromLargeFile() throws IOException {
		// File size in MB
		SumService objSumService = new SumServiceImpl();
		String fileName = ConfigPropertyManager.getInstance().getProperty("testfile4.name");
		long sum = objSumService.getDigitsSumFromFile(fileName);
		Assert.assertTrue(sum == 73195);
	}
}
