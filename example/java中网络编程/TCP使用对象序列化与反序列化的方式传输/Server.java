package TCPʹ�ö������л��뷴���л��ķ�ʽ����;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			createServer(8800, "D:\\�ļ����������ļ���\\�ͻ����������\\������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createServer(int port, String outputFile)
			throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(port);
		while (true) {
			Socket socket = serverSocket.accept();
			receiveFile(socket, outputFile);
		}
	}

	public static void receiveFile(Socket socket, String outputFile)
			throws IOException, ClassNotFoundException {
		FileBean fileBean = null;
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		fileBean = (FileBean) ois.readObject();
		byte[] content = fileBean.getContent();
		FileOutputStream out = new FileOutputStream(outputFile + "\\\\"
				+ fileBean.getFileName());
		BufferedOutputStream bos = new BufferedOutputStream(out, 1024 * 20);
		bos.write(content);
		System.out.println("�ļ�" + fileBean.getFileName() + "������ɴ�С��"
				+ fileBean.getFileSize() + "KB");
		out.close();
		ois.close();
		bos.close();
	}
}
