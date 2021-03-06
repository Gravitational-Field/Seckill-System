package org.lzj.miaosha.util;

import org.springframework.util.DigestUtils;

public class MD5Util {
	
	public static String md5(String src) {
		return DigestUtils.md5DigestAsHex(src.getBytes());
	}
	    
	private static final String salt = "1a2b3c4d";

	//输入密码到form表单密码
	public static String inputPassToFormPass(String inputPass) {
		String str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
		System.out.println(str);
		return md5(str);
	}

	//从form表单密码到DB密码
	public static String formPassToDBPass(String formPass, String salt) {
		String str = ""+salt.charAt(0)+salt.charAt(2) + formPass +salt.charAt(5) + salt.charAt(4);
		return md5(str);
	}

	//从输入密码到DB密码 ：集结了前两者
	public static String inputPassToDbPass(String inputPass, String saltDB) {
		String formPass = inputPassToFormPass(inputPass);
		String dbPass = formPassToDBPass(formPass, saltDB);
		return dbPass;
	}
	
	public static void main(String[] args) {
		System.out.println(inputPassToFormPass("123456"));//d3b1294a61a07da9b49b6e22b2cbd7f9
		//一个固定的盐 + 一个随机的盐，数据库中存取的是随机的盐
		//System.out.println(formPassToDBPass(inputPassToFormPass("123456"), "1a2b3c4d"));
		//System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));//b7797cce01b4b131b433b6acf4add449
	}
	
}