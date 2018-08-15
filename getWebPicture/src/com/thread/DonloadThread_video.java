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
 * 这是一个负责下载视频的类，使用这个类，可以实现下载一个视频的某个视频块
 * 
 * @author skty
 *
 */
public class DonloadThread_video extends Thread {
	private Block block;// 当前线程所要下载ts文件集合的开始索引和结束索引的包装类
	private List<String> ts_urls;// 一个视频所有ts-url文件的集合
	private String cacheDirectory;// 缓存视频文件的目录
	private CountDownLatch latch;// 负责当前线程下载完成后通知主线程的闭锁

	/**
	 * 
	 * @param block
	 *            线程要下载的视频块
	 * @param ts_urls
	 *            整个视频对应的ts-url的集合
	 * @param cacheDirectory
	 *            指定负责缓存的缓存文件夹
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
			System.out.println("文件已存在");
			return;
		}
		System.out.println("=======线程" + currentThread().getName() + "启动开始下载=====");
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
				System.out.println("线程" + currentThread().getName() + "已完成:" + ((int) (sum * 100 / size)) + "%");
			}
		}
		out.close();
		latch.countDown();
		System.out.println("=======线程" + currentThread().getName() + "完成视频块的下载");

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
