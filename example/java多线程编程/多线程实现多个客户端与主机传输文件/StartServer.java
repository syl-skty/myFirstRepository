package 多线程实现多个客户端与主机传输文件;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StartServer {
	public static void main(String[] args) {
		runServer(8800);
	}

	public static void runServer(int port) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				int i = 1;
				Socket socket = serverSocket.accept();
				CreateThread serverThread = new CreateThread();
				System.out.println("我是接收进程" + i + "我的进程id是："
						+ serverThread.getId() + "名字是："
						+ serverThread.getName());
				serverThread.setSocket(socket);
				serverThread.start();
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
