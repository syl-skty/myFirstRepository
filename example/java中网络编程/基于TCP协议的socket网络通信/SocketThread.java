package ����TCPЭ���socket����ͨ��;

import java.io.IOException;
import java.net.Socket;

public class SocketThread extends Thread {
	private Socket socket;

	@Override
	public void run() {
		try {
			SocketUtil.receiveFile(this.socket, "D:\\�ļ����������ļ���\\�ͻ����������\\������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}
