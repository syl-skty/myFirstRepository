package ������֤��;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCode_Util {
	private static Random random = new Random();

	/**
	 * ͨ��������߷���������ʵ������ָ�����ӷ������õ�һ��ָ����С����֤��ͼƬ
	 * 
	 * @param verfyCode
	 *            Ҫ�������֤���ַ�
	 * @param font
	 *            �ַ�Ҫʹ�õ�����
	 * @param height
	 *            ��֤��ͼƬ�ĸ߶�
	 * @param width
	 *            ��֤��ͼƬ�Ŀ��
	 * @return ����һ��BufferedImage����
	 */
	public static BufferedImage getVerifyImg(String verfyCode, Font font, int height, int width) {
		// ����һ��ͼƬ����(���ڴ��д�����һ��ͼƬ����)
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// ��ȡ���ʶ���
		Graphics graphics = image.getGraphics();

		// ========================= ΪͼƬ���Ʊ�����ɫ===========================//
		// �����ʵ���ɫ����Ϊ�������ɫ
		graphics.setColor(getRandomColor(200, 250));
		// ʹ�û��ʸ�ͼƬ���Ʊ�����ɫ,ʹ�û������ָ���ľ�������fillRect(���ƵĿ�ʼx���꣬���ƿ�ʼ��y���꣬Ҫ���ƵĿ�ȣ�Ҫ���Ƶĸ߶�)
		graphics.fillRect(0, 0, width, height);

		// ========================= ΪͼƬ���ư�ɫ�߿�========================//
		// �޸Ļ��ʵ���ɫΪ��ɫ
		graphics.setColor(Color.WHITE);
		// ʹ�û��ʻ���һ����������
		graphics.drawRect(0, 0, width - 1, height - 1);

		// ========================= ΪͼƬ�����ָ��������========================//
		// ��ǰ���ȡ��graphics���ʶ���ת����������graphics2d����
		// ������������ӣ���չ����һ��������ת���ʵ������ᣬʵ�ֻ�����ת�������ͼƬ
		Graphics2D graphics2d = (Graphics2D) graphics;
		// ����Ҫ���Ƶ��ַ���ʹ�õ�����
		graphics2d.setFont(font);
		int x = (int) ((width / (verfyCode.length()) - (font.getSize())) / 2);// �趨���ʿ�ʼ���Ƶ�x����
		int y = (int) ((height / 2) + (font.getSize()) / 2);// ���û��ʵ�����ϵ��y

		// �ֱ��ָ������֤�����ݵ�ÿ���ַ����Ƶ�ͼƬ�ϣ�������������ǻ��Ƶ���ʽ
		for (int i = 0; i < verfyCode.length(); i++) {
			char c = verfyCode.charAt(i);
			// ΪҪ���Ƶ������������һ����ɫ,����ı仭�ʵ���ɫ
			graphics2d
					.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

			// �������һ��������ת�ĽǶȣ���Χ��30�㵽-30��֮�䣩
			int jiaodu = random.nextInt(60) - 30;
			// ���ǶȻ���ɻ��ȣ������ڽ��л��Ƶ�ʱ�򣬵��õĻ��Ʒ���Ҫ��������ǻ���ֵ��
			double theta = jiaodu * Math.PI / 180;

			// �����ʵ�����ϵ��ָ��������㣬��תָ���ĽǶ�
			graphics2d.rotate(theta, x, y);
			// �������壬����ǰ��Ļ��ʵ�����ϵ����ת��������Ƶ����ֽ��Ǳ���ת��
			graphics2d.drawString(String.valueOf(c), x, y);

			// ������ɺ󣬽���������ϵ����(������ת����ϵ)
			graphics2d.rotate(-theta, x, y);

			// �ƶ����ʻ��������x��
			x = x + (int) (width / (verfyCode.length()));
		}

		// ========================= ������ɣ����========================//
		return image;
	}

	/**
	 * �����ȡһ����ɫ�����ڸ���֤��ͼƬ�ı�����ɫ
	 * 
	 * @param fc
	 *            ��ɫ���ɵ�����
	 * @param bc
	 *            ��ɫ���ɵ�����
	 * @return
	 */
	public static Color getRandomColor(int fc, int bc) {
		fc = fc > 255 ? 255 : fc;
		bc = bc > 255 ? 255 : bc;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
