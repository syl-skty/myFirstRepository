package URL���ʹ��;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://mm.chinasareview.com/wp-content/uploads/2017a/08/02/01.jpg";
		String path = "D:\\�ļ����������ļ���\\1.jpg";
		try {
			URL_util.getPage(url, path);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
