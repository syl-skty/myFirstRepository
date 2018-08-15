package com.server;

import java.io.IOException;
import java.util.List;

import com.beans.HtmlBean;
import com.web.actions.GetPictureAuto;
import com.web.actions.GetVideoAuto;

/**
 * 对所有网络爬虫的功能进行的封装
 * 
 * @author 史永龙
 * 
 */
public class GetwebSoureAuto {
	/**
	 * 自动搜索网站中的图片，并保存在指定文件夹中
	 * 
	 * @param outFile
	 *            要保存到的文件夹
	 * @param seedUrl
	 *            输入的种子网站
	 * @param searchDepth
	 *            搜索深度
	 * @param fileSizeLimit
	 *            对图片大小的限制
	 */
	public void getWebPictureAuto(String outFile, String seedUrl, int searchDepth, int fileSizeLimit) {
		List<HtmlBean> htmlBeans = GetPictureAuto.autoSearchWeb_picture(seedUrl, searchDepth);
		GetPictureAuto.getPicturesAuto(htmlBeans, outFile, fileSizeLimit);
	}

	/**
	 * 自动搜索指定网站中的视频并保存到指定的目录中
	 * 
	 * @param seedUrl
	 *            指定的种子网站
	 * @param searchDepth
	 *            搜索的深度
	 * @param outPath
	 *            要输出到的文件目录
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void getWebVideoAuto(String seedUrl, int searchDepth, String outDirectory, String cacheDirectory,
			int blockNum) throws InterruptedException, IOException {
		List<HtmlBean> htmlBeans = GetPictureAuto.autoSearchWeb_video(seedUrl, searchDepth);

		GetVideoAuto.getVideoAuto(htmlBeans, outDirectory, cacheDirectory, blockNum);
	}
}
