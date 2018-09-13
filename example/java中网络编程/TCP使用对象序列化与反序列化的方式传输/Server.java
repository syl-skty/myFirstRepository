package TCP使用对象序列化与反序列化的方式传输;

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
			createServer(8800, "D:\\文件操作测试文件夹\\客户端与服务器\\服务器");
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
		System.out.println("文件" + fileBean.getFileName() + "接收完成大小："
				+ fileBean.getFileSize() + "KB");
		out.close();
		ois.close();
		bos.close();
	}
}
