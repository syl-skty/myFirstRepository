package com.web.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class GetWebVideo {

	public static String getVideoHead() {
		String urlHead = "https://768ii.com";
		return urlHead;
	}

	/**
	 * 获取对应url网址对应的html文件
	 * 
	 * @param url
	 *            String网址
	 * @return
	 */
	public static String getVideoWebHtml(String url) {
		String html = "";
		InputStream in = GetWebSource.getInputStreamFromWeb(url);
		try {
			if (in != null && in.available() < 1024 * 20) {
				System.out.println("============正在搜索" + url
						+ " ================");
				BufferedReader bfr = new BufferedReader(new InputStreamReader(
						in, "utf-8"));
				String buffer = "";
				while ((buffer = bfr.readLine()) != null) {
					html = html + buffer;
					// System.out.println(buffer);
				}
				bfr.close();
				in.close();
				System.out.println("============网站:" + url
						+ " 搜索完成================");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return html;
	}

	/**
	 * 从网站读取视频对应的m3u8文件，并以字符串的形式返回
	 * 
	 * @param m3u8Url
	 *            m3u8文件对应的url
	 * @return
	 */
	public static String getm3u8File(String m3u8Url) {
		String m3u8File = "";
		if ((!("".equals(m3u8Url))) && m3u8Url != null) {
			try {
				InputStream in = GetWebSource.getInputStreamFromWeb(m3u8Url);
				if (in != null) {
					BufferedReader bfr = new BufferedReader(
							new InputStreamReader(in), 1024);
					String buffer = "";
					while ((buffer = bfr.readLine()) != null) {
						m3u8File = m3u8File + buffer;
					}
					bfr.close();
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return m3u8File;
	}

	/**
	 * 负责根据提供的ts完整url下载所有ts文件，并拼接成一个视频
	 * 
	 * @param tsUrls
	 *            完整的tsurl集合
	 * @param outPath
	 */
	public static void download_ts_Video(List<String> tsUrls, String outPath) {
		if (tsUrls.size() > 0 && tsUrls != null) {
			try {
				File outFile = new File(outPath);
				if (outFile.exists()) {
					System.out.println("文件已存在");
					return;
				}
				FileOutputStream out = new FileOutputStream(outFile, true);
				int beDownloadenum = 0;
				int total = tsUrls.size();
				int lastPercent = 0;
				int percent = 0;
				for (String tsurl : tsUrls) {
					InputStream in = GetWebSource.getInputStreamFromWeb(tsurl);
					if (in != null) {
						byte[] buffer = new byte[1024 * 5];
						int num = 0;
						while ((num = in.read(buffer, 0, buffer.length)) != -1) {
							out.write(buffer, 0, num);
							out.flush();
						}
						in.close();
						beDownloadenum++;
						lastPercent = percent;
						percent = (int) (beDownloadenum * 100 / total);
						if (lastPercent != percent) {
							if (percent == 100) {
								System.out.println("100");
							} else {
								if (percent % 5 == 0)
									System.out.print(percent + "%->");
							}
						}
					}
				}
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
	}
}
