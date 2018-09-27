package com.comcast.sumproject.executor;

import java.io.IOException;
import java.util.Scanner;

import com.comcast.sumproject.service.SumService;
import com.comcast.sumproject.service.impl.SumServiceImpl;
import com.comcast.sumproject.util.ConfigPropertyManager;

public class SumProjectExecutor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Please enter command from below options:\n f) Read from file \n x)  Hexadecimal sum \n n) None");
		String command = sc.nextLine();
		SumService sumServiceImpl = new SumServiceImpl();

		switch (command) {
		case "f":
			String fileName = ConfigPropertyManager.getInstance().getProperty("file.name");
			try {
				System.out.println(sumServiceImpl.getDigitsSumFromFile(fileName)); // -f
			} catch (IOException e) {
				System.out.println("Exception:" + e.getMessage());
			}
			break;
		case "x":
			System.out.println("Please enter input string:");
			String s1 = sc.nextLine();
			// hexadecimal sum
			System.out.println("Base 10 sum:" + sumServiceImpl.getHexDigitsSum(s1)); // -x
			break;
		case "n":
			System.out.println("Please enter input string:");
			String s2 = sc.nextLine();
			// no command, so sum in decimal
			System.out.println("Base 10 sum:" + sumServiceImpl.getDigitsSum(s2));
			break;
		default:
			System.out.println("Invalid input command");
		}

	}
}
