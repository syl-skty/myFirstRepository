package com.test;

import java.util.List;

import com.beans.Block;
import com.beans.HtmlBean;
import com.thread.utils.ThreadUtil;
import com.web.actions.GetPictureAuto;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://www.733ii.com/htm/movieplay2/9455.htm";
		List<HtmlBean> h = GetPictureAuto.autoSearchWeb_picture(url, 0);
		HtmlBean h1 = h.get(0);
		List<String> urls = h1.getVideos().getAllTsUrlList();
		Block[] block = ThreadUtil.split_tsUrls(urls.size(), 20);
		String cacheDirectory = "D:\\�ļ����������ļ���\\���϶�ȡ����ҳ\\t";
		System.out.println("����:" + urls.size());
		for (Block block2 : block) {
			// new DonloadThread_video(block2, urls, cacheDirectory).start();
		}

	}
}
