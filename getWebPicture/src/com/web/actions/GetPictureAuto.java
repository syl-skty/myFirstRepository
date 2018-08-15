package com.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.beans.HtmlBean;
import com.web.utils.GetWebSource;

public class GetPictureAuto {

	// private static Set<HtmlBean> htmlBeans_beSearched = new
	// HashSet<HtmlBean>();// 定义一个集合保存已经被搜索过的网站

	public static List<HtmlBean> autoSearchWeb_video(String seedUrl, int searchDepth) {
		List<HtmlBean> htmlBeans = new ArrayList<HtmlBean>();
		htmlBeans.add(GetWebSource.getWebPageBean(seedUrl));
		for (int i = 0; i < searchDepth; i++)// 此循环语句可能会报错
		{
			List<HtmlBean> beans = getBeansFromOne_picture(htmlBeans.get(i));
			if (beans.size() > 0) {
				List<HtmlBean> bs = new ArrayList<HtmlBean>();
				for (int j = 0; j < beans.size(); j++) {
					if (htmlBeans.contains(beans.get(j))) {
						continue;
					} else {
						bs.add(beans.get(j));
					}
				}
				htmlBeans.addAll(i + 1, bs);
			}
		}
		return htmlBeans;
	}

	public static List<HtmlBean> autoSearchWeb_picture(String seedUrl, int searchDepth) {
		List<HtmlBean> htmlBeans = new ArrayList<HtmlBean>();
		htmlBeans.add(GetWebSource.getWebPageBean(seedUrl));
		for (int i = 0; i < searchDepth; i++)// 此循环语句可能会报错
		{
			List<HtmlBean> beans = getBeansFromOne_picture(htmlBeans.get(i));
			if (beans.size() > 0) {
				List<HtmlBean> bs = new ArrayList<HtmlBean>();
				for (int j = 0; j < beans.size(); j++) {
					if (htmlBeans.contains(beans.get(j))) {
						continue;
					} else {
						bs.add(beans.get(j));
					}
				}
				htmlBeans.addAll(bs);
			}
		}
		return htmlBeans;
	}

	public static List<HtmlBean> getBeansFromOne_picture(HtmlBean htmlBean) {
		List<HtmlBean> beans = new ArrayList<HtmlBean>();
		if (htmlBean.getWebUrls().size() == 0)
			return null;
		for (String url : htmlBean.getWebUrls()) {
			HtmlBean h = GetWebSource.getWebPageBean(url);
			if (h != null) {
				if (h.getPictureUrls() == null) {
					continue;
				}
				if (beans.contains(h))
					continue;
				beans.add(h);
			}
		}
		return beans;
	}

	public static List<HtmlBean> getBeansFromOne_video(HtmlBean htmlBean) {
		List<HtmlBean> beans = new ArrayList<HtmlBean>();
		if (htmlBean.getWebUrls().size() == 0)
			return null;
		Set<String> videoWebUrls = htmlBean.getWebUrls();
		if (videoWebUrls.size() > 0) {
			for (String string : videoWebUrls) {
				if (string.indexOf("movie") != -1) {
					HtmlBean bean = GetWebSource.getWebPageBean(string);
					if (bean != null) {
						if (!beans.contains(bean)) {
							beans.add(bean);
						}
					}
				}
			}
		}
		return beans;
	}

	/**
	 * 下载一个存放了所有HtmlBean的list中所有图片
	 * 
	 * @param htmlBeans
	 * @param outFile
	 * @param fileSizeLimit
	 */
	public static void getPicturesAuto(List<HtmlBean> htmlBeans, String outFile, int fileSizeLimit) {
		if (htmlBeans.size() == 0) {
			return;
		}
		int downloadNum = 0;
		int totalNum = htmlBeans.size();
		for (HtmlBean htmlBean : htmlBeans) {
			if (htmlBean.getPictureUrls() == null)
				continue;
			GetWebSource.downloadPictures(htmlBean, outFile, fileSizeLimit);
			System.out.println("总进度已完成:" + ((int) (downloadNum * 100 / totalNum)) + "%");
			downloadNum++;
		}
	}
}
