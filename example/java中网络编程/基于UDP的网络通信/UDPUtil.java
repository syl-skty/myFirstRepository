package 基于UDP的网络通信;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 利用UDP的方式实现客户端与服务器端的相关通信操作
 * 
 * @author 史永龙
 * 
 */
public class UDPUtil {
	private static Scanner input = new Scanner(System.in);

	/**
	 * 用于创建客户端程序的方法
	 * 
	 * @param serverIp
	 * @param serverPort
	 * @throws Exception
	 */
	public static void createClient(String serverIp, int serverPort)
			throws Exception {
		InetAddress address = InetAddress.getByName(serverIp);// 创建一个InetAddress对象用于创建DatagramSocket对象
		DatagramSocket socket = new DatagramSocket();// 创建一个绑定在指定端口和指定地址的DatagramSocket对象
		sendFile(address, serverPort, socket);
	}

	public static void createServer(int port) throws Exception {
		DatagramSocket socket = new DatagramSocket(port);

		receiveFile(socket, "D:\\文件操作测试文件夹\\客户端与服务器\\服务器\\udp");

	}

	/**
	 * 用于客户端发送文件的方法
	 * 
	 * @param address
	 *            服务器地址
	 * @param port
	 *            服务器端口
	 * @param socket
	 *            DatagramSocket对象
	 * @throws IOException
	 */
	public static void sendFile(InetAddress address, int port,
			DatagramSocket socket) throws IOException {
		System.out
				.println("======================================开始发送文件==================================");
		String tag = " ";
		while (!tag.equals("q")) {
			System.out.print("请输入要发送文件的路径：");
			String filePath = (input.next()).replace("\\", "\\\\");
			File file = new File(filePath);
			if (!file.exists() || !file.isFile()) {
				System.out.println("请输入正确的文件路径！");
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
				System.out.println("发送" + i);
				i++;
			}
			in.close();
		}
	}

	/**
	 * 用于服务器接收文件的方法， 由于使用UDP传输，会导致接收到的字节文件与客户端发送的字节文文件偶尔会有不一样，这证明UDP是一种不安全的通讯方式
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
				System.out.println("接收完成");
				out.close();
				out = new FileOutputStream(fileOutPath + i);
				i++;
			}

		}
	}
}
