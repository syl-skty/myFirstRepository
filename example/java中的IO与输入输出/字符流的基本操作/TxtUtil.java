package �ַ����Ļ�������;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * ʹ���ַ����Ļ�����������ı��ļ�����ز���
 * 
 * @author ʷ����
 * 
 */
public class TxtUtil {
	/**
	 * ʹ��InputStreamReader�ķ�ʽ�����ı��ļ�
	 * 
	 * @param copyTxt
	 *            ���������ļ�
	 * @param pasteTxt
	 *            ���Ƶ����ļ�
	 * @throws IOException
	 */
	public static void copyTxtByISR(File copyTxt, File pasteTxt)
			throws IOException {
		if (!copyTxt.exists() || !copyTxt.isFile()) {
			throw new IllegalArgumentException("��Ҫ�������ı��ļ������ڣ�");
		}
		FileInputStream in = new FileInputStream(copyTxt);
		InputStreamReader isr = new InputStreamReader(in);
		FileOutputStream out = new FileOutputStream(pasteTxt);
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");// ���ı��ĸ�ʽת��Ϊutf-8��ʽ�洢
		char[] buffer = new char[100];
		int num;
		long start = System.currentTimeMillis();
		while ((num = isr.read(buffer, 0, 100)) != -1) {
			osw.write(buffer, 0, num);
			osw.flush();
		}
		long end = System.currentTimeMillis();
		System.out.println("�ı��ļ�" + copyTxt.getName() + "�������,��ʱ��"
				+ (end - start) + "���룡");
		isr.close();
		osw.close();
	}

	/**
	 * ����FileReader�ķ�ʽ�����ı��ļ� ���㴴�����󣬵��޷�ָ�����Ƶı����ʽ
	 * 
	 * @param copyTxt
	 * @param pasteTxt
	 * @throws IOException
	 */
	public static void copyTxtByFR(File copyTxt, File pasteTxt)
			throws IOException {
		if (!copyTxt.exists() || !copyTxt.isFile()) {
			throw new IllegalArgumentException("��Ҫ�������ı��ļ������ڣ�");
		}
		FileReader fr = new FileReader(copyTxt);
		FileWriter fw = new FileWriter(pasteTxt);
		char[] buffer = new char[100];
		int num;
		long start = System.currentTimeMillis();
		while ((num = fr.read(buffer, 0, buffer.length)) != -1) {
			fw.write(buffer, 0, num);
			fw.flush();
		}
		long end = System.currentTimeMillis();
		System.out.println("�ı��ļ�" + copyTxt.getName() + "�������,��ʱ��"
				+ (end - start) + "���룡");
		fr.close();
		fw.close();
	}

	/**
	 * ���ù�����bufferReader��������ı��ļ��ĸ���,���Ե���readLine()������ȡһ�е��ַ���
	 * 
	 * @param copyTxt
	 * @param pasteTxt
	 * @throws IOException
	 */
	public static void copyTxtByBR(File copyTxt, File pasteTxt)
			throws IOException {
		if (!copyTxt.exists() || !copyTxt.isFile()) {
			throw new IllegalArgumentException("��Ҫ�������ı��ļ������ڣ�");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(copyTxt)));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
				new FileOutputStream(pasteTxt), "utf-8"), true);// �����Զ�ˢ�»���
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
		// new FileOutputStream(pasteTxt), "utf-8"));
		String buffer = new String();
		long start = System.currentTimeMillis();
		while ((buffer = br.readLine()) != null) {
			// bw.write(buffer);
			// bw.newLine();// ����BufferWriterд���ַ���ʱ�����Զ����У�Ҫ����newLine()��������
			// bw.flush();
			pw.println(buffer);
			// pw.flush();
		}
		long end = System.currentTimeMillis();
		System.out.println("�ı��ļ�" + copyTxt.getName() + "�������,��ʱ��"
				+ (end - start) + "���룡");
		br.close();
		// bw.close();
		pw.close();
	}
}
