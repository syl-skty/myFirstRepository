package 多线程实现多个客户端与主机传输文件;

import java.net.Socket;

public class CreateThread extends Thread {
	private Socket socket = null;

	@Override
	public void run() {
		ServerUtil.receiveFile(this.socket, "D:\\文件操作测试文件夹\\客户端与服务器\\服务器");
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
