package com.sp.utils;

import java.security.MessageDigest;

public class MD5Utils {
	/**
	 * 
	 * @param 待加密字符串
	 * @return 加密后32位MD5字符串
	 */
	public static String String2MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		byte[] byteArray = inStr.getBytes();
		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {

			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString().toUpperCase();
	}
	public static void main(String[] args) {
		//21   3C59DC048E8850243BE8079A5C74D079
		//zhp  B66857686B995B799AA86398BD98AB52
		//dsds 4AB47E54C2F73AD4C0EB3974709721CD
		//111 698D51A19D8A121CE581499D7B701668
		//sa C12E01F2A13FF5587E1E9E4AEDB8242D
		System.out.println(String2MD5("sa"));
	}
}