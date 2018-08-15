package com.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.beans.Block;
import com.web.utils.GetWebSource;

/**
 * ����һ������������Ƶ���࣬ʹ������࣬����ʵ������һ����Ƶ��ĳ����Ƶ��
 * 
 * @author skty
 *
 */
public class DonloadThread_video extends Thread {
	private Block block;// ��ǰ�߳���Ҫ����ts�ļ����ϵĿ�ʼ�����ͽ��������İ�װ��
	private List<String> ts_urls;// һ����Ƶ����ts-url�ļ��ļ���
	private String cacheDirectory;// ������Ƶ�ļ���Ŀ¼
	private CountDownLatch latch;// ����ǰ�߳�������ɺ�֪ͨ���̵߳ı���

	/**
	 * 
	 * @param block
	 *            �߳�Ҫ���ص���Ƶ��
	 * @param ts_urls
	 *            ������Ƶ��Ӧ��ts-url�ļ���
	 * @param cacheDirectory
	 *            ָ�����𻺴�Ļ����ļ���
	 */

	@Override
	public void run() {
		try {
			downloadByThread();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DonloadThread_video(Block block, List<String> ts_urls, String cacheDirectory, CountDownLatch latch) {
		super();
		this.block = block;
		this.ts_urls = ts_urls;
		this.cacheDirectory = cacheDirectory;
		this.latch = latch;
	}

	private void downloadByThread() throws IOException {
		File outFile = new File(cacheDirectory + File.separator + block.blockNum);
		if (outFile.exists()) {
			System.out.println("�ļ��Ѵ���");
			return;
		}
		System.out.println("=======�߳�" + currentThread().getName() + "������ʼ����=====");
		FileOutputStream out = new FileOutputStream(outFile, true);
		int size = block.end - block.start;
		int sum = 0;
		for (int i = block.start; i <= block.end; i++) {
			InputStream in = GetWebSource.getInputStreamFromWeb(ts_urls.get(i));
			if (in != null) {
				byte[] buffer = new byte[1024 * 5];
				int num = 0;
				while ((num = in.read(buffer, 0, buffer.length)) != -1) {
					out.write(buffer, 0, num);
					out.flush();
				}
				in.close();
				sum++;
				System.out.println("�߳�" + currentThread().getName() + "�����:" + ((int) (sum * 100 / size)) + "%");
			}
		}
		out.close();
		latch.countDown();
		System.out.println("=======�߳�" + currentThread().getName() + "�����Ƶ�������");

	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public List<String> getTs_urls() {
		return ts_urls;
	}

	public void setTs_urls(List<String> ts_urls) {
		this.ts_urls = ts_urls;
	}

	public String getCacheDirectory() {
		return cacheDirectory;
	}

	public void setCacheDirectory(String cacheDirectory) {
		this.cacheDirectory = cacheDirectory;
	}

}
