package 基于TCP协议的socket网络通信;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import 有显示进度的完成文件传输工具.IOShowPercent;

public class SocketUtil {
	private static Scanner input = new Scanner(System.in);

	/**
	 * 创建服务器端并实现其基本功能
	 * 
	 * @param port
	 *            端口号
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void createServer(int port) throws IOException,
			InterruptedException {

		ServerSocket server = new ServerSocket(port);// 创建ServerSocket对象
		System.out
				.println("===================================服务器正在运行===================================");
		int fileNum = 1;
		while (true) {
			Socket socket = server.accept();// 监听指定端口号，如果有客户端连接，则会创建出一个Socket对象
			if (fileNum == 1) {
				System.out
						.println("===================================客服端已连接===================================");
			}
			SocketThread thread = new SocketThread();
			thread.setSocket(socket);
			thread.start();
			thread.join();
			fileNum++;
		}
	}

	/**
	 * 创建客户端并实现功能
	 * 
	 * @param ip
	 *            服务器端的ip
	 * @param port
	 *            服务器端的端口
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void createClient(String ip, int port)
			throws UnknownHostException, IOException {

		sendFile();
	}

	/**
	 * 实现发送信息的方法
	 * 
	 * @param os
	 *            发送信息的输出流对象
	 */
	public static void sendMessage(PrintWriter pw) {
		System.out
				.println("================================开始聊天================================");
		String tag = " ";
		while (!tag.equals("q")) {
			String message = input.next();
			pw.println(message);
			System.out.print("输入q结束否则继续！");
			tag = input.next();
		}
	}

	/**
	 * 实现接收信息并显示的方法
	 * 
	 * @param br
	 * @throws IOException
	 */
	public static void receiveMessage(BufferedReader br) throws IOException {
		String buffer = null;
		while ((buffer = br.readLine()) != null) {
			System.out.print(buffer + "\n");
		}
	}

	/**
	 * 发送文件的方法
	 * 
	 * @param out
	 *            输出流对象
	 * @throws IOException
	 */
	public static void sendFile() throws IOException {
		System.out
				.println("================================开始发文件================================");
		String tag = " ";
		while (!tag.equals("q")) {
			System.out.print("输入文件路径：");
			String filePath = input.next();
			filePath.replace("\\", "\\\\");
			File file = new File(filePath);
			if (!file.isFile() || !file.exists()) {
				System.out.println("请输入正确的路径");
				continue;
			} else {
				long fileSize = file.length();
				String sizeAndName = file.getName() + " " + fileSize;
				System.out.println("文件大小为" + (fileSize / 1024) + 1 + "KB");
				Socket socket = new Socket("localhost", 8888);
				OutputStream out1 = socket.getOutputStream();
				byte[] b1 = new byte[1024];
				byte[] b2 = sizeAndName.getBytes();
				for (int i = 0; i < b2.length; i++) {
					b1[i] = b2[i];
				}
				out1.write(b1);
				FileOutputStream out = (FileOutputStream) socket
						.getOutputStream();
				FileInputStream in = new FileInputStream(filePath);
				long timeUse = IOShowPercent.ShowPercent(in, out, 1024 * 20);
				socket.close();
				System.out.print("文件: " + file.getName() + " 》》发送完成《《\t耗时："
						+ timeUse + "毫秒\t 输入q结束否则继续");
				tag = input.next();
			}
		}
	}

	/**
	 * 负责接受收文件的方法
	 * 
	 * @param in
	 * @param fileOutPath
	 * @throws IOException
	 */
	public static void receiveFile(Socket socket, String fileOutPath)
			throws IOException {
		InputStream in1 = socket.getInputStream();
		byte[] nameAndSizeByte = new byte[1024];
		int length1 = in1.read(nameAndSizeByte, 0, 1024);
		String fileNameAndSize = new String(nameAndSizeByte, 0, length1);
		fileNameAndSize = fileNameAndSize.trim();
		String two[] = fileNameAndSize.split(" ", 2);
		String fileName = two[0];
		String Size = two[1];
		Long fileSize = new Long(Size);
		File file = new File(fileOutPath + "\\\\" + fileName);
		FileOutputStream out = new FileOutputStream(file);
		InputStream in = socket.getInputStream();
		byte[] buffer = new byte[1024 * 20];
		int length;
		long start = System.currentTimeMillis();
		System.out.println("开始从" + (socket.getInetAddress()).getHostAddress()
				+ "接收文件:" + fileName + " 大小为" + (fileSize / 1024 + 1) + "KB");
		long byteNum = 0;
		int percent = 0;
		int lastPercent = 0;
		while ((length = in.read(buffer, 0, buffer.length)) != -1) {
			out.write(buffer, 0, length);
			out.flush();
			byteNum = byteNum + length;
			lastPercent = percent;
			percent = (int) ((byteNum * 100) / fileSize);
			if (lastPercent != percent && percent % 5 == 0) {
				if (percent == 100) {
					System.out.print("完成");
				} else {
					System.out.print(percent + "%—>");
				}
			}
		}
		System.out.println();
		in.close();
		out.close();
		socket.close();
		long end = System.currentTimeMillis();
		System.out.println("文件: " + fileName + "   》》接收成功《《\t保存在："
				+ fileOutPath + "  目录下  \t耗时：" + (end - start) + "毫秒。");
		System.out
				.println("===============================================================================================");
	}
}
