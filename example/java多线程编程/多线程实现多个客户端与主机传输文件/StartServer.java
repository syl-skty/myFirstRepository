package ���߳�ʵ�ֶ���ͻ��������������ļ�;

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
				System.out.println("���ǽ��ս���" + i + "�ҵĽ���id�ǣ�"
						+ serverThread.getId() + "�����ǣ�"
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
