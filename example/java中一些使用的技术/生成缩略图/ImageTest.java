package ��������ͼ;

import java.awt.Color;
import java.awt.Font;

public class ImageTest {

	public static void main(String[] args) {
		String inpath = "D:\\�ļ����������ļ���\\1.jpg";
		String outpath = "D:\\�ļ����������ļ���\\2.png";
		PictureUtil.drawWordsOnPicture(inpath, outpath, "������������", new Font("����", Font.BOLD, 30), Color.red, 0.5, 0.4);
		System.out.println("ת�����");
	}

}
