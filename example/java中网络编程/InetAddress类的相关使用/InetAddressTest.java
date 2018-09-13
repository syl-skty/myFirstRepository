package InetAddress类的相关使用;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress address1 = InetAddress.getLocalHost();// 获取本地主机的对象
		System.out.println("调用toString方法返回的主机名和ip地址：" + address1);
		byte[] a = address1.getAddress();// 获取本地主机的IP地址字节形式
		System.out.println("本地主机的IP地址字节形式为：" + Arrays.toString(a));
		String localAddress = address1.getHostAddress();// 获取本地主机ip地址返回String类型
		System.out.println("本地主机的IP地址字符形式为：" + localAddress);
		InetAddress address2 = InetAddress.getByName(localAddress);// 通过主机ip地址获得对象
		InetAddress address3 = InetAddress.getByName(address1.getHostName());// 通过主机名获取对象

	}
}
