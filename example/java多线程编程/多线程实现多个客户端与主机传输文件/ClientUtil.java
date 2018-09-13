package 多线程实现多个客户端与主机传输文件;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 此类中包含所有客户端所要调用的方法
 * 
 * @author 史永龙
 * 
 */
public class ClientUtil {
	private static Scanner input = new Scanner(System.in);

	/**
	 * 负责向服务器发送文件的方法
	 * 
	 * @param host
	 *            服务器ip
	 * @param port
	 *            服务器端口
	 * 
	 * @throws IOException
	 */
	public static void SendFile(String host, int port) {
		String tag = "";
		BufferedInputStream bis = null;
		File file = null;
		String filePath = null;
		FileBean fileBean = null;
		ObjectOutputStream objectOut = null;
		Socket socket = null;
		while (!tag.equals("q")) {
			System.out.print("请输入要发送的文件的绝对路径：");
			filePath = input.next();
			file = new File(filePath);
			if (!file.exists() || !file.isFile()) {
				System.out.println("请输入正确的文件路径！");
				continue;
			} else {
				try {
					bis = new BufferedInputStream(new FileInputStream(file),
							1024 * 20);
					byte[] content = new byte[bis.available()];
					bis.read(content);
					bis.close();
					fileBean = new FileBean();
					fileBean.setContent(content);
					fileBean.setFileName(file.getName());
					fileBean.setFileSize((content.length) / 1024 + 1);
					socket = new Socket(host, port);
					objectOut = new ObjectOutputStream(socket.getOutputStream());
					objectOut.writeObject(fileBean);
					System.out.println("发送完毕");
					objectOut.close();
					socket.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
