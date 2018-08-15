package com.test;

import java.io.IOException;

import com.server.GetwebSoureAuto;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seedUrl = "https://www.907aa.com/htm/movielist2/";
		int searchDepth = 5;
		String outDirectory = "D:\\文件操作测试文件夹\\网上读取的网页\\v";
		String cacheDirectory = "D:\\文件操作测试文件夹\\网上读取的网页\\cache";
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