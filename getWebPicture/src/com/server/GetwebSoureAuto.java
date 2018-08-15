package com.server;

import java.io.IOException;
import java.util.List;

import com.beans.HtmlBean;
import com.web.actions.GetPictureAuto;
import com.web.actions.GetVideoAuto;

/**
 * ��������������Ĺ��ܽ��еķ�װ
 * 
 * @author ʷ����
 * 
 */
public class GetwebSoureAuto {
	/**
	 * �Զ�������վ�е�ͼƬ����������ָ���ļ�����
	 * 
	 * @param outFile
	 *            Ҫ���浽���ļ���
	 * @param seedUrl
	 *            �����������վ
	 * @param searchDepth
	 *            �������
	 * @param fileSizeLimit
	 *            ��ͼƬ��С������
	 */
	public void getWebPictureAuto(String outFile, String seedUrl, int searchDepth, int fileSizeLimit) {
		List<HtmlBean> htmlBeans = GetPictureAuto.autoSearchWeb_picture(seedUrl, searchDepth);
		GetPictureAuto.getPicturesAuto(htmlBeans, outFile, fileSizeLimit);
	}

	/**
	 * �Զ�����ָ����վ�е���Ƶ�����浽ָ����Ŀ¼��
	 * 
	 * @param seedUrl
	 *            ָ����������վ
	 * @param searchDepth
	 *            ���������
	 * @param outPath
	 *            Ҫ��������ļ�Ŀ¼
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void getWebVideoAuto(String seedUrl, int searchDepth, String outDirectory, String cacheDirectory,
			int blockNum) throws InterruptedException, IOException {
		List<HtmlBean> htmlBeans = GetPictureAuto.autoSearchWeb_video(seedUrl, searchDepth);

		GetVideoAuto.getVideoAuto(htmlBeans, outDirectory, cacheDirectory, blockNum);
	}
}
