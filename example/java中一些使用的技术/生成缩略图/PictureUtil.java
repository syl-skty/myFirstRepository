package ��������ͼ;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ����һ����������һ��ͼƬ������ͼ�Ĺ�����
 * 
 * @author skty
 *
 */
public class PictureUtil {

	/**
	 * ����������Ը��������ͼƬ���ļ�·��������ָ�����ش�С��ѹ�����ͼƬ
	 * 
	 * @param imagePath
	 *            �����δѹ����ͼƬ�ļ���·��
	 * @param outpath
	 *            �޸���ɺ��ͼƬָ����Ҫ���浽�ļ�·��
	 * @param format
	 *            �޸���ɺ�ָ��Ҫ���ɵ�ͼƬ�ĸ�ʽ
	 * @param height
	 *            ָ��Ҫ�޸ĳɵ�ͼƬ�ĸ߶�
	 * @param width
	 *            ָ��Ҫ�޸ĳɵ�ͼƬ�Ŀ��
	 * @return true �޸ĳɹ� false �޸�ʧ��
	 * @throws IOException
	 */
	public static boolean resizeImage(String imagePath, String outpath, int height, int width) {

		try {
			// ʹ��ָ����·������һ��File����
			File in = new File(imagePath);
			if (!in.exists() || !in.isFile())// �ж��ļ��Ƿ����
			{
				System.out.println("====================�������ͼƬ·������������ѡ��============");
				return false;
			}
			// ��ȡ���ͼƬ�ĺ�׺��
			String format = imagePath.substring(outpath.lastIndexOf(".") + 1);
			// ʹ������ָ�����ļ���ʹ��ImageIO����ľ�̬����read��ͼƬ�ĸ�ʽ������һ��BufferedImage�����൱��һ��ͼƬ��
			// �൱��ʹ��ָ�����ļ�����һ����ͼƬ����
			BufferedImage image = ImageIO.read(in);

			// ����һ������ѹ����Ҫ���ɵ�ͼƬ�Ķ�������ʹ������ָ��ѹ����ͼƬ�Ŀ��������һ��������Ҫ��ͼƬ����
			// ͬʱ������������ָ�����ǹ���������ͼƬ��ͼƬ����ΪRGB��ʽ
			// ���ڴ���������ͼƬ��һ�ſհ׵�ͼƬ����������Ҫ������ָ����ͼƬ����ѹ����д�����ſհ׵�ͼƬ
			BufferedImage _image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			// ʹ�����Ǵ����Ŀհ׵�ͼƬ����ȡ���Ļ��ʣ���ʹ����������������ǿհ׵�ͼƬ�ϻ���һ��ѹ�����ͼƬ
			// ʹ��drawImage(Ҫѹ����ͼƬ��������ʼ��x���꣬������ʼ��y���꣬Ҫ���Ŀ�ȣ�����ͼ�εĸ߶ȣ�ָ��������ɺ�Ҫ֪ͨ�Ĺ۲��ߣ�һ�㲻ָ����)
			boolean tag = _image.getGraphics().drawImage(image, 0, 0, width, height, null);
			if (tag == true) {
				// ʹ��ͼƬ�������ָ���ĸ�ʽ�����ָ���ļ�
				ImageIO.write(_image, format, new File(outpath));
				return true;
			}
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * �������ʵ���˽�ָ����ͼƬ�ĳ��Ϳ�ѹ������Ŵ󣩳�ָ�����ȵ�ͼƬ������
	 * 
	 * @param imagePath
	 *            Ҫ��ѹ�����Ŵ󣩵�ͼƬ���ļ�λ��
	 * 
	 * @param outpath
	 *            ��������ͼƬ�����·��
	 * @param format
	 *            ���ͼƬ�ĸ�ʽ
	 * @param size
	 *            Ҫ������ͼƬ�ı���
	 * @return �Ƿ���ɹ�
	 * @throws IOException
	 */
	public static boolean resizeImage(String imagePath, String outpath, double size) {
		try {
			File in = new File(imagePath);
			if (!in.exists() || !in.isFile())// �ж��ļ��Ƿ����
			{
				System.out.println("====================�������ͼƬ·������������ѡ��============");
				return false;
			}
			// ��ȡ���ͼƬ�ĺ�׺��
			String format = imagePath.substring(outpath.lastIndexOf(".") + 1);
			BufferedImage image = ImageIO.read(in);
			int height = (int) (image.getHeight() * size);
			int width = (int) (image.getWidth() * size);
			BufferedImage _image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			boolean tag = _image.getGraphics().drawImage(image, 0, 0, width, height, null);
			if (tag == true) {
				ImageIO.write(_image, format, new File(outpath));
				return true;
			}
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ���հٷֱ�������ͼƬ
	 * 
	 * @param imagePath
	 *            ����ͼƬ�ļ�·��
	 * @param outpath
	 *            �������ͼƬ��·��
	 * @param format
	 *            ���ͼƬ�ĸ�ʽ
	 * @param height_part
	 *            �߶�ռ��
	 * @param width_part
	 *            ���ռ��
	 * @return
	 */
	public static boolean resizeImage(String imagePath, String outpath, double height_part, double width_part) {
		try {
			File in = new File(imagePath);
			if (!in.exists() || !in.isFile())// �ж��ļ��Ƿ����
			{
				System.out.println("====================�������ͼƬ·������������ѡ��============");
				return false;
			}
			// ��ȡ���ͼƬ�ĺ�׺��
			String format = imagePath.substring(outpath.lastIndexOf(".") + 1);
			BufferedImage image = ImageIO.read(in);
			int height = (int) (image.getHeight() * height_part);
			int width = (int) (image.getWidth() * width_part);
			BufferedImage _image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			boolean tag = _image.getGraphics().drawImage(image, 0, 0, width, height, null);
			if (tag == true) {
				ImageIO.write(_image, format, new File(outpath));
				return true;
			}
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param imagePath
	 *            ԭʼͼƬ��·��
	 * @param outPath
	 *            �������ֺ�ͼƬ�����·��
	 * @param word
	 *            Ҫ���������
	 * @param font
	 *            �������ֵ���ʽ
	 * @param color
	 *            �������ֵ���ɫ
	 * @param x_part
	 *            ����������ͼƬλ��y����ռ�İٷֱ�λ��
	 * @param y_part
	 *            ����������ͼƬλ��y����ռ�İٷֱ�λ��
	 * @throws IOException
	 */
	public static boolean drawWordsOnPicture(String imagePath, String outPath, String word, Font font, Color color,
			double x_part, double y_part) {
		try {
			File in = new File(imagePath);
			if (!in.exists() || !in.isFile())// �ж��ļ��Ƿ����
			{
				System.out.println("====================�������ͼƬ·������������ѡ��============");
				return false;
			}
			// ��ȡԭʼͼƬ�ĺ�׺��
			String format = imagePath.substring(imagePath.lastIndexOf(".") + 1);
			// ����ԭʼͼƬ
			BufferedImage image = ImageIO.read(in);
			// ��ȡԭʼͼƬ�ĳ���
			int height = image.getHeight();
			int width = image.getWidth();
			// ����ͼƬ�������ڴ��������ֺ��ͼƬ���ݣ����ﲻ��ֱ����ԭʼͼƬ�ϼ��֣����봴��һ���µĶ������нӣ���Ȼ��Ч��
			BufferedImage _image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			// ��ȡ�½�ͼ��Ļ���
			Graphics g = _image.getGraphics();
			// ����һ�����������������Ҫ��ӵ�����������ʽ
			// Font font = new Font("����", Font.BOLD, 30);
			// �����������µ�����
			g.setFont(font);
			// ���û��ʵ���ɫ����������������ɫ
			g.setColor(color);
			// ��ԭʼͼƬ���Ƶ������½���ͼƬ�У���Ϊ���ǲ���ֱ����ԭʼͼƬ��������壩
			g.drawImage(image, 0, 0, width, height, null);
			// ��ͼƬλ�õİٷֱ�λ��ת��Ϊʵ������λ��
			int x = (int) (width * x_part);
			int y = (int) (height * y_part);
			// ��ʼ���½�ͼƬд������
			g.drawString(word, x, y);
			// ���½���ͼƬ���������ԭʼͼƬ��·����ͬʱ����ԭʼͼƬ
			return ImageIO.write(_image, format, new File(outPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
