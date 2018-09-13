package 使用MD5加密字符串;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用MD5加密字符串的方式，主要使用的是MessageDigest类的操作
 * 
 * 将原始字符转换为加密后的字节数组，
 * 
 * 之后将该字节数组转换为16进制的字符串，
 * 
 * 最后将加密的字符串前面补零将其补为满32位的字符
 * 
 * @author skty
 *
 */
public class MD5Util {

	public static String getMD5String(String str) {

		String md5String = null;

		// 创建一个字节数组用于存放加密时产生的字节码
		byte[] secretBytes = null;

		try {
			// 获取md5加密算法对象
			MessageDigest instance = MessageDigest.getInstance("md5");

			// 将要加密的字符串分解为字节数组，并使用md5算法加密获取一个新的字节数组
			secretBytes = instance.digest(str.getBytes());

			// 将得到的加密后字节数组生成一个大整型整数，并将其转换为String类型
			// 数字表示符号，前面的1表示正数。0表示0，-1表示负数
			// 并将其转换为以16进制编码的字符串
			md5String = new BigInteger(1, secretBytes).toString(16);

			// 由于生成的加密后的字符串有可能不满32二位的标准MD5字符,于是在其前面加零保证其为32位
			for (int i = 0; i < 32 - md5String.length(); i++) {
				md5String = "0" + md5String;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5String;
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.getMD5String("123"));
	}
}
