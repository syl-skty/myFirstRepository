package TCP使用对象序列化与反序列化的方式传输;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			createClient("localhost", 8800);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createClient(String host, int port) throws IOException {
		sendFile(host, port);
	}

	public static void sendFile(String host, int port) throws IOException {
		String tag = " ";
		while (!tag.equals("q")) {
			System.out.print("请输入文件路径：");
			String filePath = input.next();
			File file = new File(filePath);
			if (!file.exists() || !file.isFile()) {
				System.out.println("请输入正确的文件路径!");
				continue;
			} else {
				Socket socket = new Socket(host, port);
				FileInputStream in = new FileInputStream(file);
				FileBean fileBean = new FileBean();
				byte[] content = new byte[in.available()];
				BufferedInputStream bis = new BufferedInputStream(in, 1024 * 2);
				bis.read(content);
				fileBean.setContent(content);
				fileBean.setFileName(file.getName());
				fileBean.setFileSize(file.length() / 1024 + 1);
				ObjectOutputStream oos = new ObjectOutputStream(
						socket.getOutputStream());
				oos.writeObject(fileBean);
				System.out.println("发送完成");
				in.close();
				bis.close();
				oos.close();
				socket.close();
			}
		}
	}
}
