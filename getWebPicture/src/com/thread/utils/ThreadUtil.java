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
	 * 根据一个m3u8视的所有ts对应的url进行分块，以实现让每个线程分担一部分ts文件的下载
	 * 
	 * @param amount
	 *            一个视频ts文件对应的url的总数
	 * @param blockNum
	 *            对整个视频要对其ts文件分块的数量
	 * @return Block 一个包含了所有块的中在List中的起点索引和终点索引的对象数组 使用这个数组时，应为左闭右闭的
	 */
	public static Block[] split_tsUrls(int amount, int blockNum) {
		int blocksize = (int) (amount / blockNum);// 计算出每个块所包含的ts-url的数量
		Block[] points = new Block[blockNum];
		for (int i = 0; i < (blockNum - 1); i++) {
			points[i] = new Block(blocksize * i, blocksize * (i + 1) - 1, i);
		}
		points[blockNum - 1] = new Block(blocksize * (blockNum - 1), amount - 1, blockNum - 1);
		return points;
	}

	/**
	 * 使用多个线程下载指定的ts_urls集合中包含的所有视频文件
	 * 
	 * @param ts_urls
	 *            指定的ts_urls集合（包含所有ts视频文件的网络地址）
	 * @param outFilePath
	 *            指定下载完成的视频的绝对路径（包含文件名与后缀）
	 * @param cachePath
	 *            指定存放每个线程下载下来的视频块存放的缓存文件夹
	 * @param blockNum
	 *            要把指定视频分块的块数
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void downloadVideoByThreads(List<String> ts_urls, String outFilePath, String cacheDirectory,
			int blockNum) throws InterruptedException, IOException {
		Block[] blocks = split_tsUrls(ts_urls.size(), blockNum);
		CountDownLatch latch = new CountDownLatch(blockNum);// 定义一个闭锁，用于等待一个视频下载完成后再执行下一个视频的下载
		for (Block block : blocks)// 开启指定数目的线程去下载视频
		{
			new DonloadThread_video(block, ts_urls, cacheDirectory, latch).start();
		}
		latch.await();// 主线程等待，等待那些下载同一个视频的不同块的线程完成后才启动
		combine_Video_Blocks(cacheDirectory, outFilePath);// 将视频块结合并输出到指定文件夹
		System.gc();
	}

	/**
	 * 将各线程下载完的多个视频进行拼接，使其成为一个完整的视频
	 * 
	 * @param cacheDirectory
	 *            临时存放各个视频的缓存文件夹
	 * @param outFilePath
	 *            生成的视频文件要输出到的目录
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
				System.out.println("无法删除缓存的视频块文件");
			}
		}
		out.close();
	}
}
