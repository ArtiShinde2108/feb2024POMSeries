package com.qa.opencart.utils;

public class StringUtils {

	public static String getRandomEmailId() {
		String Emailid = "userauto" + System.currentTimeMillis() + "opencart.com";
		return Emailid;
	}

}
