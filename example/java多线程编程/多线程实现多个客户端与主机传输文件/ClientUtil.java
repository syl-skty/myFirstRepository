package ���߳�ʵ�ֶ���ͻ��������������ļ�;

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
 * �����а������пͻ�����Ҫ���õķ���
 * 
 * @author ʷ����
 * 
 */
public class ClientUtil {
	private static Scanner input = new Scanner(System.in);

	/**
	 * ����������������ļ��ķ���
	 * 
	 * @param host
	 *            ������ip
	 * @param port
	 *            �������˿�
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
			System.out.print("������Ҫ���͵��ļ��ľ���·����");
			filePath = input.next();
			file = new File(filePath);
			if (!file.exists() || !file.isFile()) {
				System.out.println("��������ȷ���ļ�·����");
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
					System.out.println("�������");
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
