package 生成缩略图;

import java.awt.Color;
import java.awt.Font;

public class ImageTest {

	public static void main(String[] args) {
		String inpath = "D:\\文件操作测试文件夹\\1.jpg";
		String outpath = "D:\\文件操作测试文件夹\\2.png";
		PictureUtil.drawWordsOnPicture(inpath, outpath, "年撒娇啊就是", new Font("宋体", Font.BOLD, 30), Color.red, 0.5, 0.4);
		System.out.println("转换完毕");
	}

}
