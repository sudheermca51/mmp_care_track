package org.iitwf.healthcare.mmp;

import java.util.Random;

public class RandomUtils {


	private static final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static String generateRandomString(int length) {
		StringBuilder builder = new StringBuilder(length);
		int minIndex = 0;
		int maxIndex = CHAR_SET.length() - 1;
		for (int i = 0; i < length; i++) {
			int randomIndex = generateRandomNo(minIndex, maxIndex);
			builder.append(CHAR_SET.charAt(randomIndex));
		}
		return builder.toString();
	}
	public static int generateRandomNo(int min,int max)
	{
		Random rand = new Random();
		int randInt = min+rand.nextInt(max-min+1);
		return randInt;
	}

	public static void main(String[] args) {

		generateRandomString(10);

		//		String str = new String("Selenium WebDriver");
		//		
		//		String str1= str.replace("WebDriver", "IDE");
		//		
		//		System.out.println("Replaced String:::"+ str1);
		//		
		//		
		//		StringBuilder strb = new StringBuilder("Selenium WebDriver");
		//		
		//		strb.replace(9,strb.length(),"IDE");
		//		
		//		System.out.println("Replaced String Builder::"+ strb);
		//		
		//		Random rand = new Random();
		//
		//		for (int i =0;i<10;i++)
		//		{
		//			int randInt  = rand.nextInt(200);
		//
		//			System.out.println(randInt);
		//		}
		//		int lBound = 10,uBound=99;
		//		int randInt2Digit = lBound+rand.nextInt(uBound-lBound+1);//lBound+(uBound-lBound+1);
		//		System.out.println("Random 2 digit number"+ randInt2Digit);
		//
		//
		//		int j = 65;
		//
		//
		//		char ch = (char) j;
		//
		//		System.out.println(ch);
		//
		//		//upper case 
		//		lBound = 65;
		//		uBound=90;
		//		char upperch = (char) (lBound+rand.nextInt(uBound-lBound+1));
		//		System.out.println("Random uupercase character::" + upperch);
		//
		//		//upper case 
		//		lBound = 97;
		//		uBound=122;
		//		char lowerch = (char) (lBound+rand.nextInt(uBound-lBound+1));
		//		System.out.println("Random uupercase character::" + lowerch);
		//
		//
		//		String randomEmail = "AUTIITWF"+upperch+lowerch+randInt2Digit;
		//		
		//		System.out.println(randomEmail);
		//
		//		
		//
		//		 
		//		Calendar cal = Calendar.getInstance();
		//		long phNo = cal.getTimeInMillis()%1000000000;
		//		System.out.println("Time in milliseconds"+cal.getTimeInMillis()%1000000000);
		//		System.out.println("outcome" + 20%5);



	}
}
