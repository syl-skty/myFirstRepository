package com.string.util;

import java.util.ArrayList;
import java.util.List;

import com.web.utils.GetWebVideo;

public class VideoStringUtil {
	/**
	 * 获取视频对应的m3u8文件地址
	 * 
	 * @param webHtml
	 * @param urlHead
	 * @return
	 */
	public static String getVideoUrl_m3u8(String webHtml) {
		String url = "";
		try {
			if ((!"".equals(webHtml)) && webHtml != null) {
				int m3u8Index = webHtml.indexOf(".m3u8", 0);
				if (m3u8Index != -1) {
					int dotIndex = webHtml.lastIndexOf("'", m3u8Index);
					if (dotIndex != -1) {
						// String theString = webHtml.substring(playurlIndex +
						// 7,
						// dotIndex - 2);
						// theString = theString.replace("'", "\"");
						// int first = theString.indexOf("\"", 0);
						// int second = theString.indexOf("\"", first + 1);
						String urlTail = webHtml.substring(dotIndex + 1,
								m3u8Index + 5).trim();
						url = GetWebVideo.getVideoHead() + urlTail;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return url;
	}

	/**
	 * 从一个m3u8文件中读取出所有ts链接
	 * 
	 * @param m3u8File
	 *            一个存储了m3u8文件的String文件
	 * @return
	 */
	public static List<String> get_ts_fromM3u8(String m3u8File) {
		List<String> allTs = new ArrayList<String>();
		try {
			if (!("".equals(m3u8File)) && m3u8File != null) {
				int tsIndex = 0;
				while ((tsIndex = m3u8File.indexOf(".ts", tsIndex)) != -1) {
					tsIndex++;
					int fontIndex = m3u8File.lastIndexOf(",", tsIndex);
					if (fontIndex != -1) {
						String theString = m3u8File.substring(fontIndex + 1,
								tsIndex + 3);
						String a_ts = theString.trim();
						allTs.add(a_ts);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return allTs;
	}

	/**
	 * 获取并拼接所有ts链接使其成为完整可访问的url
	 * 
	 * @param m3u8_url
	 *            一个已经拼好的m3u8Url
	 * @param ts
	 *            一个刚截取并未拼接的ts url
	 * @return
	 */
	public static List<String> get_ts_urls(String m3u8_url, List<String> ts) {
		List<String> allTs_url = new ArrayList<String>();
		try {
			if ((!("".equals(m3u8_url))) && (m3u8_url != null)) {
				int theIndex = m3u8_url.lastIndexOf("/");
				String firstUrl = m3u8_url.substring(0, theIndex + 1);
				if (ts.size() > 0) {
					for (String string : ts) {
						String a_ts_url = firstUrl + string;
						allTs_url.add(a_ts_url);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return allTs_url;
	}
}
