package com.web.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

import com.beans.HtmlBean;
import com.beans.VideoBean;
import com.string.util.StringUtil;
import com.web.actions.GetVideoAuto;

public class GetWebSource {
	/**
	 * �����ṩ��url��ַ��ȡ��Ӧ��վ������������
	 * 
	 * @param url
	 *            ��վurl��ַ
	 * @return in InputStream
	 * @throws IOException
	 */
	public static InputStream getInputStreamFromWeb(String url) {
		InputStream in = null;
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			HttpURLConnection connection = (HttpURLConnection) uc;
			connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			connection.setDoInput(true);
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.connect();
			if (connection.getResponseCode() == 200) {
				in = connection.getInputStream();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return in;
	}

	/**
	 * ͨ��һ��ָ����URL�����ȡ��Ӧ������������
	 * 
	 * @param u
	 *            ָ����URL����
	 * @return in InputStream
	 * @throws IOException
	 */
	public static InputStream getInputStreamFromWeb(URL u) {
		InputStream in = null;
		if (u == null) {
			return null;
		}
		try {
			HttpURLConnection connection = (HttpURLConnection) u.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			connection.setDoInput(true);
			connection.connect();
			if (connection.getResponseCode() == 200) {
				in = connection.getInputStream();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return in;
	}

	/**
	 * ͨ��һ��ָ����ַ ��ȡһ��HtmlBean������������������ַ��Ӧ����ַ�����а���������ͼƬurl��ַ����Ƶ����
	 * 
	 * @param url
	 *            ��ַ
	 * @throws Exception
	 */
	public static HtmlBean getWebPageBean(String url) {
		try {
			if (url.length() > 75) {
				return null;
			}
			HtmlBean htmlBean = null;
			String webHtml = GetWebVideo.getVideoWebHtml(url);
			if (!("".equals(webHtml)) && webHtml != null) {
				htmlBean = new HtmlBean();
				htmlBean.setWebUrl(url);
				htmlBean.setWebHtml(webHtml);
				Set<String> pictureUrls = StringUtil.getPictureUrls(webHtml, url);
				Set<String> LinkUrls = StringUtil.getWebUrls(webHtml, url);
				if (url.indexOf("movieplay") != -1) {
					VideoBean video = GetVideoAuto.getVideoBeanFromWeb(webHtml);
					if (video != null) {
						htmlBean.setVideos(video);
					}
				}
				if (pictureUrls.size() > 0) {
					htmlBean.setPictureUrls(pictureUrls);
				}
				if (LinkUrls.size() > 0) {
					htmlBean.setWebUrls(LinkUrls);
				}
			}
			return htmlBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * ����ָ����HtmlBean�����·����ȡ��������ҳ�е�����ͼƬ
	 * 
	 * @param htmlBean
	 *            ָ������ҳʵ�������汣����������ҳ�е�url��Ϣ
	 * @param fileOutPath
	 *            Ҫ��������ļ�Ŀ¼
	 * @throws IOException
	 */
	public static void downloadPictures(HtmlBean htmlBean, String fileOutPath, int fileSizeLimit) {
		if (htmlBean == null) {
			return;
		}
		Set<String> pictureUrls = htmlBean.getPictureUrls();
		int savePictureNum = 0;
		// String savefloderName = htmlBean.getWebUrl().replace("/", ".");
		// savefloderName = savefloderName.replace(":", ".");
		File directory = new File(fileOutPath);
		if (!directory.exists() || !directory.isDirectory()) {
			directory.mkdir();
		}
		try {
			System.out.println("����ȡ���:");
			for (String url : pictureUrls) {
				URL u = new URL(url);
				String pictureName = u.getPath().replace("/", ".");
				InputStream in = getInputStreamFromWeb(u);
				if (in == null) {
					return;
				}
				File outputFile = new File(directory.getPath() + "\\" + pictureName);
				if (outputFile.exists()) {
					in.close();
					continue;
				}
				FileOutputStream out = new FileOutputStream(outputFile);
				byte[] buffer = new byte[1024 * 45];
				int num = 0;
				while ((num = in.read(buffer, 0, 1024)) != -1) {
					out.write(buffer, 0, num);
					out.flush();
				}
				out.close();
				in.close();
				if (outputFile.length() < fileSizeLimit) {
					outputFile.delete();
					savePictureNum++;
					continue;
				}
				savePictureNum++;
				System.out.print(((int) (savePictureNum * 100 / pictureUrls.size())) + "%��>");
			}
			System.out.println("\n" + "����ȡ��վ:" + htmlBean.getWebUrl() + "������ͼƬ.\n������" + directory.getPath() + "�ļ�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
}
