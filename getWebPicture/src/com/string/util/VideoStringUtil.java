package com.string.util;

import java.util.ArrayList;
import java.util.List;

import com.web.utils.GetWebVideo;

public class VideoStringUtil {
	/**
	 * ��ȡ��Ƶ��Ӧ��m3u8�ļ���ַ
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
	 * ��һ��m3u8�ļ��ж�ȡ������ts����
	 * 
	 * @param m3u8File
	 *            һ���洢��m3u8�ļ���String�ļ�
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
	 * ��ȡ��ƴ������ts����ʹ���Ϊ�����ɷ��ʵ�url
	 * 
	 * @param m3u8_url
	 *            һ���Ѿ�ƴ�õ�m3u8Url
	 * @param ts
	 *            һ���ս�ȡ��δƴ�ӵ�ts url
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
