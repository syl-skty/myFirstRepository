package com.web.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.beans.HtmlBean;
import com.beans.VideoBean;
import com.string.util.VideoStringUtil;
import com.thread.utils.ThreadUtil;
import com.web.utils.GetWebVideo;

public class GetVideoAuto {
	/**
	 * 把一个视频信息包装成一个视频对象
	 * 
	 * @param webHtml
	 *            视频对应网站的html文件
	 * @return
	 */
	public static VideoBean getVideoBeanFromWeb(String webHtml) {
		VideoBean bean = null;
		try {
			String m3u8_url = VideoStringUtil.getVideoUrl_m3u8(webHtml);
			if ((!("".equals(m3u8_url))) && (m3u8_url != null)) {
				String m3u8File = GetWebVideo.getm3u8File(m3u8_url);
				if ((!("".equals(m3u8File))) && (m3u8File != null)) {
					List<String> allTs = VideoStringUtil.get_ts_fromM3u8(m3u8File);
					if (allTs.size() > 0 && allTs != null) {
						List<String> allTs_url = VideoStringUtil.get_ts_urls(m3u8_url, allTs);
						if (allTs_url.size() > 0 && allTs_url != null) {
							bean = new VideoBean();
							bean.setM3u8Url(m3u8_url);
							bean.setAllTsUrlList(allTs_url);
							int lastdot = m3u8_url.lastIndexOf(".");
							int seconddot = m3u8_url.lastIndexOf("/");
							String name = m3u8_url.substring(seconddot + 1, lastdot) + ".mp4";
							bean.setVideoName(name);

						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return bean;
	}

	public static void getVideoAuto(List<HtmlBean> htmlBeans, String outDirectory, String cacheDirectory, int blockNum)
			throws InterruptedException, IOException {
		if (htmlBeans.size() == 0) {
			return;
		}

		List<HtmlBean> hs = new ArrayList<HtmlBean>();
		for (HtmlBean h : htmlBeans) {
			if (h.getVideos() != null) {
				hs.add(h);
			}
		}
		int downloadNum = 1;
		int totalNum = hs.size();
		System.out.println("总数" + totalNum);
		for (HtmlBean htmlBean : hs) {
			VideoBean video = htmlBean.getVideos();
			List<String> tsUrls = video.getAllTsUrlList();
			String filePath = outDirectory + File.separator + video.getVideoName();
			if ((new File(filePath)).exists()) {
				continue;
			}
			System.out.println("===========>>正在从" + htmlBean.getWebUrl() + "上下载视频<<=========");

			ThreadUtil.downloadVideoByThreads(tsUrls, filePath, cacheDirectory, blockNum);
			// GetWebVideo.download_ts_Video(tsUrls, filePath);

			System.out.println("===========>>视频：" + video.getVideoName() + "下载完成<<=========");
			System.out.println("总下载完成进度:" + downloadNum + "/" + totalNum);
			downloadNum++;
		}
	}

}
