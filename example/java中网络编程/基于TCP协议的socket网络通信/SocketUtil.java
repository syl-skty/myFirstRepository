package ����TCPЭ���socket����ͨ��;

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

import ����ʾ���ȵ�����ļ����乤��.IOShowPercent;

public class SocketUtil {
	private static Scanner input = new Scanner(System.in);

	/**
	 * �����������˲�ʵ�����������
	 * 
	 * @param port
	 *            �˿ں�
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void createServer(int port) throws IOException,
			InterruptedException {

		ServerSocket server = new ServerSocket(port);// ����ServerSocket����
		System.out
				.println("===================================��������������===================================");
		int fileNum = 1;
		while (true) {
			Socket socket = server.accept();// ����ָ���˿ںţ�����пͻ������ӣ���ᴴ����һ��Socket����
			if (fileNum == 1) {
				System.out
						.println("===================================�ͷ���������===================================");
			}
			SocketThread thread = new SocketThread();
			thread.setSocket(socket);
			thread.start();
			thread.join();
			fileNum++;
		}
	}

	/**
	 * �����ͻ��˲�ʵ�ֹ���
	 * 
	 * @param ip
	 *            �������˵�ip
	 * @param port
	 *            �������˵Ķ˿�
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void createClient(String ip, int port)
			throws UnknownHostException, IOException {

		sendFile();
	}

	/**
	 * ʵ�ַ�����Ϣ�ķ���
	 * 
	 * @param os
	 *            ������Ϣ�����������
	 */
	public static void sendMessage(PrintWriter pw) {
		System.out
				.println("================================��ʼ����================================");
		String tag = " ";
		while (!tag.equals("q")) {
			String message = input.next();
			pw.println(message);
			System.out.print("����q�������������");
			tag = input.next();
		}
	}

	/**
	 * ʵ�ֽ�����Ϣ����ʾ�ķ���
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
	 * �����ļ��ķ���
	 * 
	 * @param out
	 *            ���������
	 * @throws IOException
	 */
	public static void sendFile() throws IOException {
		System.out
				.println("================================��ʼ���ļ�================================");
		String tag = " ";
		while (!tag.equals("q")) {
			System.out.print("�����ļ�·����");
			String filePath = input.next();
			filePath.replace("\\", "\\\\");
			File file = new File(filePath);
			if (!file.isFile() || !file.exists()) {
				System.out.println("��������ȷ��·��");
				continue;
			} else {
				long fileSize = file.length();
				String sizeAndName = file.getName() + " " + fileSize;
				System.out.println("�ļ���СΪ" + (fileSize / 1024) + 1 + "KB");
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
				System.out.print("�ļ�: " + file.getName() + " ����������ɡ���\t��ʱ��"
						+ timeUse + "����\t ����q�����������");
				tag = input.next();
			}
		}
	}

	/**
	 * ����������ļ��ķ���
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
		System.out.println("��ʼ��" + (socket.getInetAddress()).getHostAddress()
				+ "�����ļ�:" + fileName + " ��СΪ" + (fileSize / 1024 + 1) + "KB");
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
					System.out.print("���");
				} else {
					System.out.print(percent + "%��>");
				}
			}
		}
		System.out.println();
		in.close();
		out.close();
		socket.close();
		long end = System.currentTimeMillis();
		System.out.println("�ļ�: " + fileName + "   �������ճɹ�����\t�����ڣ�"
				+ fileOutPath + "  Ŀ¼��  \t��ʱ��" + (end - start) + "���롣");
		System.out
				.println("===============================================================================================");
	}
}
