package ����TCPЭ���socket����ͨ��;

import java.io.IOException;

public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SocketUtil.createServer(8888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
