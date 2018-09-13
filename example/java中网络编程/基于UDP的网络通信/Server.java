package 基于UDP的网络通信;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UDPUtil.createServer(8800);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
