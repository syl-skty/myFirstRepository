package ��̬����;

public class ProxyTest {

	public static void main(String[] args) {
		BookImp bookImp = new BookImp();
		BookProxy proxy = new BookProxy();
		proxy.bind(bookImp);
		try {
			proxy.invoke(proxy, bookImp.getClass().getMethod("addBook", String.class), new Object[] { "�鱾һ" });
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
