package 基于TCP协议的socket网络通信;

import java.io.IOException;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SocketUtil.createClient("localhost", 8888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}// E:\douyou\DoyoGames\Download\10102174\10102174.rar
// E:\实用教程资源\java编程相关\myeclipse-pro-2014-GA-offline-installer-windows.exe
