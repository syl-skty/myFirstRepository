package ��Ӧ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OpenApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cmd = "calc";// ��win10�Դ��ļ�����(��������cmd����)
		Runtime runtime = Runtime.getRuntime();
		try {

			Process p = runtime.exec(cmd);
			InputStream in = p.getInputStream();
			BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
			String buffer = "";
			while ((buffer = bfr.readLine()) != null) {
				System.out.println(buffer);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
