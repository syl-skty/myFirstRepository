package ���߳�ʵ�ֶ���ͻ��������������ļ�;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * �������Ĺ�����
 * 
 * @author ʷ����
 * 
 */
public class ServerUtil {
	public static void receiveFile(Socket socket, String fileSaveDirectory) {
		try {
			File outPutFile = null;
			FileBean fileBean = null;
			ObjectInputStream ois = null;
			BufferedOutputStream bos = null;
			ois = new ObjectInputStream(socket.getInputStream());
			fileBean = (FileBean) ois.readObject();
			outPutFile = new File(fileSaveDirectory + "\\\\"
					+ fileBean.getFileName());
			bos = new BufferedOutputStream(new FileOutputStream(outPutFile),
					1024 * 20);
			bos.write(fileBean.getContent());
			System.out.println("�������");
			bos.close();
			ois.close();
			socket.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
