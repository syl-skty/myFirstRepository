package com.test;

import java.io.IOException;

import com.server.GetwebSoureAuto;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seedUrl = "https://www.907aa.com/htm/movielist2/";
		int searchDepth = 5;
		String outDirectory = "D:\\�ļ����������ļ���\\���϶�ȡ����ҳ\\v";
		String cacheDirectory = "D:\\�ļ����������ļ���\\���϶�ȡ����ҳ\\cache";
		GetwebSoureAuto g = new GetwebSoureAuto();
		// g.getWebPictureAuto(outFile, seedUrl, searchDepth, fileSizeLimit);
		try {
			g.getWebVideoAuto(seedUrl, searchDepth, outDirectory, cacheDirectory, 20);
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}