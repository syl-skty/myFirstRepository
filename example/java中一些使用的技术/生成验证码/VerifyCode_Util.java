package 生成验证码;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCode_Util {
	private static Random random = new Random();

	/**
	 * 通过这个工具方法，可以实现输入指定的子符串，得到一个指定大小的验证码图片
	 * 
	 * @param verfyCode
	 *            要输入的验证码字符
	 * @param font
	 *            字符要使用的字体
	 * @param height
	 *            验证码图片的高度
	 * @param width
	 *            验证码图片的宽度
	 * @return 返回一个BufferedImage对象
	 */
	public static BufferedImage getVerifyImg(String verfyCode, Font font, int height, int width) {
		// 创建一个图片对象(在内存中创建了一个图片对象)
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取画笔对象
		Graphics graphics = image.getGraphics();

		// ========================= 为图片绘制背景颜色===========================//
		// 将画笔的颜色设置为随机的颜色
		graphics.setColor(getRandomColor(200, 250));
		// 使用画笔给图片绘制背景颜色,使用画笔填充指定的矩形区域，fillRect(绘制的开始x坐标，绘制开始的y坐标，要绘制的宽度，要绘制的高度)
		graphics.fillRect(0, 0, width, height);

		// ========================= 为图片绘制白色边框========================//
		// 修改画笔的颜色为白色
		graphics.setColor(Color.WHITE);
		// 使用画笔绘制一个矩形区域
		graphics.drawRect(0, 0, width - 1, height - 1);

		// ========================= 为图片添加上指定的字体========================//
		// 将前面获取的graphics画笔对象转换成其子类graphics2d对象，
		// 这个子类对象添加（扩展）了一个用于旋转画笔的坐标轴，实现画出旋转的字体或图片
		Graphics2D graphics2d = (Graphics2D) graphics;
		// 设置要绘制的字符所使用的字体
		graphics2d.setFont(font);
		int x = (int) ((width / (verfyCode.length()) - (font.getSize())) / 2);// 设定画笔开始绘制的x坐标
		int y = (int) ((height / 2) + (font.getSize()) / 2);// 设置画笔的坐标系的y

		// 分别对指定的验证码内容的每个字符绘制到图片上，并随机调整他们绘制的样式
		for (int i = 0; i < verfyCode.length(); i++) {
			char c = verfyCode.charAt(i);
			// 为要绘制的字体随机设置一个颜色,随机改变画笔的颜色
			graphics2d
					.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

			// 随机生成一个字体旋转的角度（范围在30°到-30°之间）
			int jiaodu = random.nextInt(60) - 30;
			// 将角度换算成弧度（由于在进行绘制的时候，调用的绘制方法要求输入的是弧度值）
			double theta = jiaodu * Math.PI / 180;

			// 将画笔的坐标系以指定的坐标点，旋转指定的角度
			graphics2d.rotate(theta, x, y);
			// 绘制字体，由于前面的画笔的坐标系被旋转，这里绘制的文字将是被旋转的
			graphics2d.drawString(String.valueOf(c), x, y);

			// 绘制完成后，将画笔坐标系重置(反向旋转坐标系)
			graphics2d.rotate(-theta, x, y);

			// 移动画笔绘制坐标的x轴
			x = x + (int) (width / (verfyCode.length()));
		}

		// ========================= 绘制完成，输出========================//
		return image;
	}

	/**
	 * 随机获取一个颜色，用于给验证码图片的背景着色
	 * 
	 * @param fc
	 *            颜色生成的下限
	 * @param bc
	 *            颜色生成的上限
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
