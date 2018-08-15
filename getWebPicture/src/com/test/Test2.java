package com.test;

import java.util.List;

import com.beans.HtmlBean;
import com.web.actions.GetPictureAuto;
import com.web.utils.GetWebSource;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String urlHead = "https://768ii.com";
		String outPath = "D:\\文件操作测试文件夹\\网上读取的网页\\video\\test2.mp4";
		// String webHtml = GetWebVideo
		// .getVideoWebHtml("https://www.816aa.com/htm/movieplay1/8877.htm");
		HtmlBean bean = GetWebSource
				.getWebPageBean("http://www.tooopen.com/img/87.aspx");
		List<HtmlBean> beans = GetPictureAuto.getBeansFromOne_picture(bean);
		for (HtmlBean htmlBean : beans) {
			for (String u : htmlBean.getWebUrls()) {
				System.out.println(u);
			}
			// VideoBean v = htmlBean.getVideos();
			// if (v != null) {
			// System.out.println(v.getM3u8Url());
			// }
		}
	}
}
// https://www.816aa.com/htm/movie2/8886.htm
// https://www.816aa.com/htm/movie2/8814.htm
// https://www.816aa.com/htm/movie2/8871.htm
// https://www.816aa.com/htm/movie2/8830.htm
// https://www.816aa.com/htm/movie2/8822.htm
// https://www.816aa.com/htm/movie2/8846.htm
// https://www.816aa.com/htm/movie2/8847.htm
