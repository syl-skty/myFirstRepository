package ����UDP������ͨ��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * ����UDP�ķ�ʽʵ�ֿͻ�����������˵����ͨ�Ų���
 * 
 * @author ʷ����
 * 
 */
public class UDPUtil {
	private static Scanner input = new Scanner(System.in);

	/**
	 * ���ڴ����ͻ��˳���ķ���
	 * 
	 * @param serverIp
	 * @param serverPort
	 * @throws Exception
	 */
	public static void createClient(String serverIp, int serverPort)
			throws Exception {
		InetAddress address = InetAddress.getByName(serverIp);// ����һ��InetAddress�������ڴ���DatagramSocket����
		DatagramSocket socket = new DatagramSocket();// ����һ������ָ���˿ں�ָ����ַ��DatagramSocket����
		sendFile(address, serverPort, socket);
	}

	public static void createServer(int port) throws Exception {
		DatagramSocket socket = new DatagramSocket(port);

		receiveFile(socket, "D:\\�ļ����������ļ���\\�ͻ����������\\������\\udp");

	}

	/**
	 * ���ڿͻ��˷����ļ��ķ���
	 * 
	 * @param address
	 *            ��������ַ
	 * @param port
	 *            �������˿�
	 * @param socket
	 *            DatagramSocket����
	 * @throws IOException
	 */
	public static void sendFile(InetAddress address, int port,
			DatagramSocket socket) throws IOException {
		System.out
				.println("======================================��ʼ�����ļ�==================================");
		String tag = " ";
		while (!tag.equals("q")) {
			System.out.print("������Ҫ�����ļ���·����");
			String filePath = (input.next()).replace("\\", "\\\\");
			File file = new File(filePath);
			if (!file.exists() || !file.isFile()) {
				System.out.println("��������ȷ���ļ�·����");
				continue;
			}
			FileInputStream in = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int length = 0;
			int i = 1;
			while ((length = in.read(buffer, 0, buffer.length)) != -1) {
				DatagramPacket packet = new DatagramPacket(buffer, length,
						address, port);
				socket.send(packet);
				System.out.println("����" + i);
				i++;
			}
			in.close();
		}
	}

	/**
	 * ���ڷ����������ļ��ķ����� ����ʹ��UDP���䣬�ᵼ�½��յ����ֽ��ļ���ͻ��˷��͵��ֽ����ļ�ż�����в�һ������֤��UDP��һ�ֲ���ȫ��ͨѶ��ʽ
	 * 
	 * @param socket
	 * @param fileOutPath
	 * @throws IOException
	 */
	public static void receiveFile(DatagramSocket socket, String fileOutPath)
			throws IOException {
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		int i = 1;
		FileOutputStream out = new FileOutputStream(fileOutPath);
		while (true) {
			socket.receive(packet);
			if (packet.getLength() == 1024) {
				out.write(data, 0, 1024);
				out.flush();
			} else {
				out.write(data, 0, packet.getLength());
				out.flush();
				System.out.println("�������");
				out.close();
				out = new FileOutputStream(fileOutPath + i);
				i++;
			}

		}
	}
}
