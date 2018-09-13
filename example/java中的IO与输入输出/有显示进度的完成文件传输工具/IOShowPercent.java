package ����ʾ���ȵ�����ļ����乤��;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author ʷ����
 * 
 */
public class IOShowPercent {
	/**
	 * �˷��������ڽ����ļ������������ʾ����Ľ���
	 * 
	 * @param in
	 *            ����������
	 * @param out
	 *            ���������
	 * @param bufferSize
	 *            ���û������Ĵ�С
	 * @return �����ܴ���ʱ�䵥λ����
	 * @throws IOException
	 */
	public static long ShowPercent(InputStream in, OutputStream out,
			int bufferSize) throws IOException {
		byte[] buffer = new byte[bufferSize];// ÿ�ζ�������ֽ�����
		int length = 0;// ÿ�ζ����ֽڵĸ���
		long byteNum = 0;// �ܹ��������ֽ�
		int percent = 0;// �˴��������ɰٷֱ�
		int lastPercent = 0;// ��һ�εİٷֱ�
		int fileSize = in.available();// �ļ����ܴ�С
		long start = System.currentTimeMillis();// ��ʼ����ʱ��
		while ((length = in.read(buffer, 0, buffer.length)) != -1) {
			out.write(buffer, 0, length);
			out.flush();
			byteNum = byteNum + length;
			lastPercent = percent;
			percent = (int) ((byteNum * 100) / fileSize);
			if (lastPercent != percent && percent % 5 == 0) {
				if (percent == 100) {
					System.out.print("���");
				} else {
					System.out.print(percent + "%��>");
				}
			}
		}
		long end = System.currentTimeMillis();// ��������ʱ��
		System.out.println();
		out.close();
		in.close();
		return end - start;
	}
}
