package ���߳�ʵ�ֶ���ͻ��������������ļ�;

import java.net.Socket;

public class CreateThread extends Thread {
	private Socket socket = null;

	@Override
	public void run() {
		ServerUtil.receiveFile(this.socket, "D:\\�ļ����������ļ���\\�ͻ����������\\������");
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
