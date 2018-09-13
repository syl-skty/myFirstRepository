package ≤‚ ‘NIo;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class TestNIO {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		String s = new String("÷–".getBytes(), "gbk");
		System.out.println("÷–".getBytes("utf-8").length);
		char c = s.charAt(0);
		System.out.println(c);

	}

}
