package String类中的方法;

//字符数组位数由0开始
public class skty2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "hello everyone,I love java";
		// int length():返回当前字符串的长度
		System.out.println("当前字符串的长度为：" + a.length());
		// int indexOf(char ch):返回ch在字符串中第一次出现的位置
		System.out.println("字符ll在当前字符串第一次出现的位置为：" + a.indexOf("ll"));
		// int lastIndexOf(char h):返回h字符最后出现的位置
		System.out.println("l字符最后出现的位置为：" + a.lastIndexOf("l"));
		// >>>>>>>>>>以上的如果位置不存在或字符不存在则返回-1<<<<<<<

		// String subString(int beginIndex):返回从开始位置beginIndex到结束的字符串
		System.out.println("从3号位到结尾的字符串为:" + a.substring(3));
		System.out.println("从3号位到9号位的字符串为：" + a.substring(3, 9));
		// String trim():返回去除空格的字符串
		System.out.println("去除空格后的字符串为：" + a.trim());
		// boolean equals(String b):判断与b字符的值是否相等
		System.out.println("判断a与b是否相等：" + a.equals("hi"));
		// String toLowercase():转换为小写
		System.out.println("转换为小写后为：" + a.toLowerCase());
		System.out.println("转换为大写为：" + a.toUpperCase());
		// char charAt( int index):返回在index位置上的字符
		System.out.println("在4号位上的字符为：" + a.charAt(4));
		// String[] split(String regex,int limit):将字符拆分为字符存入数组,每次到空格就拆分
		String[] b = a.split(" ");
		for (String i : b) {
			System.out.print(i + "\t");
		}
		System.out.println();
		// byte[] getBytes():将字符串转换为字byte数组
		byte[] by = a.getBytes();
		for (byte i : by) {
			System.out.print(i + "\t");
		}
	}

}
