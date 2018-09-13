package 基于TCP协议的socket网络通信;

import java.io.IOException;
import java.net.Socket;

public class SocketThread extends Thread {
	private Socket socket;

	@Override
	public void run() {
		try {
			SocketUtil.receiveFile(this.socket, "D:\\文件操作测试文件夹\\客户端与服务器\\服务器");
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
