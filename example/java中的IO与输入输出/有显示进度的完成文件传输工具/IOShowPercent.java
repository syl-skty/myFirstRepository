package 有显示进度的完成文件传输工具;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author 史永龙
 * 
 */
public class IOShowPercent {
	/**
	 * 此方法用于在进行文件传输过程中显示传输的进度
	 * 
	 * @param in
	 *            输入流对象
	 * @param out
	 *            输出流对象
	 * @param bufferSize
	 *            设置缓冲区的大小
	 * @return 返回总传输时间单位毫秒
	 * @throws IOException
	 */
	public static long ShowPercent(InputStream in, OutputStream out,
			int bufferSize) throws IOException {
		byte[] buffer = new byte[bufferSize];// 每次读满这个字节数组
		int length = 0;// 每次读到字节的个数
		long byteNum = 0;// 总共读到的字节
		int percent = 0;// 此次算出的完成百分比
		int lastPercent = 0;// 上一次的百分比
		int fileSize = in.available();// 文件的总大小
		long start = System.currentTimeMillis();// 开始传输时刻
		while ((length = in.read(buffer, 0, buffer.length)) != -1) {
			out.write(buffer, 0, length);
			out.flush();
			byteNum = byteNum + length;
			lastPercent = percent;
			percent = (int) ((byteNum * 100) / fileSize);
			if (lastPercent != percent && percent % 5 == 0) {
				if (percent == 100) {
					System.out.print("完成");
				} else {
					System.out.print(percent + "%—>");
				}
			}
		}
		long end = System.currentTimeMillis();// 结束传输时刻
		System.out.println();
		out.close();
		in.close();
		return end - start;
	}
}
