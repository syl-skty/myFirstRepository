package com.thread.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.beans.Block;
import com.thread.DonloadThread_video;

public class ThreadUtil {

	/**
	 * ����һ��m3u8�ӵ�����ts��Ӧ��url���зֿ飬��ʵ����ÿ���̷ֵ߳�һ����ts�ļ�������
	 * 
	 * @param amount
	 *            һ����Ƶts�ļ���Ӧ��url������
	 * @param blockNum
	 *            ��������ƵҪ����ts�ļ��ֿ������
	 * @return Block һ�����������п������List�е�����������յ������Ķ������� ʹ���������ʱ��ӦΪ����ұյ�
	 */
	public static Block[] split_tsUrls(int amount, int blockNum) {
		int blocksize = (int) (amount / blockNum);// �����ÿ������������ts-url������
		Block[] points = new Block[blockNum];
		for (int i = 0; i < (blockNum - 1); i++) {
			points[i] = new Block(blocksize * i, blocksize * (i + 1) - 1, i);
		}
		points[blockNum - 1] = new Block(blocksize * (blockNum - 1), amount - 1, blockNum - 1);
		return points;
	}

	/**
	 * ʹ�ö���߳�����ָ����ts_urls�����а�����������Ƶ�ļ�
	 * 
	 * @param ts_urls
	 *            ָ����ts_urls���ϣ���������ts��Ƶ�ļ��������ַ��
	 * @param outFilePath
	 *            ָ��������ɵ���Ƶ�ľ���·���������ļ������׺��
	 * @param cachePath
	 *            ָ�����ÿ���߳�������������Ƶ���ŵĻ����ļ���
	 * @param blockNum
	 *            Ҫ��ָ����Ƶ�ֿ�Ŀ���
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void downloadVideoByThreads(List<String> ts_urls, String outFilePath, String cacheDirectory,
			int blockNum) throws InterruptedException, IOException {
		Block[] blocks = split_tsUrls(ts_urls.size(), blockNum);
		CountDownLatch latch = new CountDownLatch(blockNum);// ����һ�����������ڵȴ�һ����Ƶ������ɺ���ִ����һ����Ƶ������
		for (Block block : blocks)// ����ָ����Ŀ���߳�ȥ������Ƶ
		{
			new DonloadThread_video(block, ts_urls, cacheDirectory, latch).start();
		}
		latch.await();// ���̵߳ȴ����ȴ���Щ����ͬһ����Ƶ�Ĳ�ͬ����߳���ɺ������
		combine_Video_Blocks(cacheDirectory, outFilePath);// ����Ƶ���ϲ������ָ���ļ���
		System.gc();
	}

	/**
	 * �����߳�������Ķ����Ƶ����ƴ�ӣ�ʹ���Ϊһ����������Ƶ
	 * 
	 * @param cacheDirectory
	 *            ��ʱ��Ÿ�����Ƶ�Ļ����ļ���
	 * @param outFilePath
	 *            ���ɵ���Ƶ�ļ�Ҫ�������Ŀ¼
	 * @throws IOException
	 */
	public static void combine_Video_Blocks(String cacheDirectory, String outFilePath) throws IOException {
		File file = new File(cacheDirectory);
		String[] fs = file.list();
		int[] files_name = new int[fs.length];
		for (int i = 0; i < fs.length; i++) {
			files_name[i] = Integer.parseInt(fs[i]);
		}
		Arrays.sort(files_name);
		FileOutputStream out = new FileOutputStream(outFilePath, true);
		for (int name : files_name) {
			File video_file = new File(cacheDirectory + File.separator + name);
			FileInputStream in = new FileInputStream(video_file);
			int num = 0;
			byte[] buffer = new byte[1024 * 20];
			while ((num = in.read(buffer, 0, buffer.length)) != -1) {
				out.write(buffer, 0, num);
				out.flush();
			}
			in.close();
			if (!video_file.delete()) {
				System.out.println("�޷�ɾ���������Ƶ���ļ�");
			}
		}
		out.close();
	}
}
