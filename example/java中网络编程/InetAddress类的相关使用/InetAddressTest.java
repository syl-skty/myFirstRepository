package InetAddress������ʹ��;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress address1 = InetAddress.getLocalHost();// ��ȡ���������Ķ���
		System.out.println("����toString�������ص���������ip��ַ��" + address1);
		byte[] a = address1.getAddress();// ��ȡ����������IP��ַ�ֽ���ʽ
		System.out.println("����������IP��ַ�ֽ���ʽΪ��" + Arrays.toString(a));
		String localAddress = address1.getHostAddress();// ��ȡ��������ip��ַ����String����
		System.out.println("����������IP��ַ�ַ���ʽΪ��" + localAddress);
		InetAddress address2 = InetAddress.getByName(localAddress);// ͨ������ip��ַ��ö���
		InetAddress address3 = InetAddress.getByName(address1.getHostName());// ͨ����������ȡ����

	}
}
