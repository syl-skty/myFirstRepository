package 字符流的基本操作;

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
 * 使用字符流的基本操作完成文本文件的相关操作
 * 
 * @author 史永龙
 * 
 */
public class TxtUtil {
	/**
	 * 使用InputStreamReader的方式拷贝文本文件
	 * 
	 * @param copyTxt
	 *            被拷贝的文件
	 * @param pasteTxt
	 *            复制到的文件
	 * @throws IOException
	 */
	public static void copyTxtByISR(File copyTxt, File pasteTxt)
			throws IOException {
		if (!copyTxt.exists() || !copyTxt.isFile()) {
			throw new IllegalArgumentException("你要拷贝的文本文件不存在！");
		}
		FileInputStream in = new FileInputStream(copyTxt);
		InputStreamReader isr = new InputStreamReader(in);
		FileOutputStream out = new FileOutputStream(pasteTxt);
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");// 将文本的格式转换为utf-8格式存储
		char[] buffer = new char[100];
		int num;
		long start = System.currentTimeMillis();
		while ((num = isr.read(buffer, 0, 100)) != -1) {
			osw.write(buffer, 0, num);
			osw.flush();
		}
		long end = System.currentTimeMillis();
		System.out.println("文本文件" + copyTxt.getName() + "复制完毕,耗时："
				+ (end - start) + "毫秒！");
		isr.close();
		osw.close();
	}

	/**
	 * 采用FileReader的方式拷贝文本文件 方便创建对象，但无法指定复制的编码格式
	 * 
	 * @param copyTxt
	 * @param pasteTxt
	 * @throws IOException
	 */
	public static void copyTxtByFR(File copyTxt, File pasteTxt)
			throws IOException {
		if (!copyTxt.exists() || !copyTxt.isFile()) {
			throw new IllegalArgumentException("你要拷贝的文本文件不存在！");
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
		System.out.println("文本文件" + copyTxt.getName() + "复制完毕,耗时："
				+ (end - start) + "毫秒！");
		fr.close();
		fw.close();
	}

	/**
	 * 采用过滤器bufferReader方法完成文本文件的复制,可以调用readLine()方法读取一行的字符串
	 * 
	 * @param copyTxt
	 * @param pasteTxt
	 * @throws IOException
	 */
	public static void copyTxtByBR(File copyTxt, File pasteTxt)
			throws IOException {
		if (!copyTxt.exists() || !copyTxt.isFile()) {
			throw new IllegalArgumentException("你要拷贝的文本文件不存在！");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(copyTxt)));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
				new FileOutputStream(pasteTxt), "utf-8"), true);// 设置自动刷新缓冲
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
		// new FileOutputStream(pasteTxt), "utf-8"));
		String buffer = new String();
		long start = System.currentTimeMillis();
		while ((buffer = br.readLine()) != null) {
			// bw.write(buffer);
			// bw.newLine();// 采用BufferWriter写入字符串时不会自动换行，要调用newLine()方法换行
			// bw.flush();
			pw.println(buffer);
			// pw.flush();
		}
		long end = System.currentTimeMillis();
		System.out.println("文本文件" + copyTxt.getName() + "复制完毕,耗时："
				+ (end - start) + "毫秒！");
		br.close();
		// bw.close();
		pw.close();
	}
}
