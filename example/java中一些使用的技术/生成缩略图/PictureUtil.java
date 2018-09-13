package 生成缩略图;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 这是一个可以生成一个图片的缩略图的工具类
 * 
 * @author skty
 *
 */
public class PictureUtil {

	/**
	 * 这个方法可以根据输入的图片的文件路径，生成指定像素大小的压缩后的图片
	 * 
	 * @param imagePath
	 *            输入的未压缩的图片文件的路径
	 * @param outpath
	 *            修改完成后的图片指定的要保存到文件路径
	 * @param format
	 *            修改完成后指定要生成的图片的格式
	 * @param height
	 *            指定要修改成的图片的高度
	 * @param width
	 *            指定要修改成的图片的宽度
	 * @return true 修改成功 false 修改失败
	 * @throws IOException
	 */
	public static boolean resizeImage(String imagePath, String outpath, int height, int width) {

		try {
			// 使用指定的路径创建一个File对象
			File in = new File(imagePath);
			if (!in.exists() || !in.isFile())// 判断文件是否存在
			{
				System.out.println("====================你输入的图片路径有误，请重新选择============");
				return false;
			}
			// 获取输出图片的后缀名
			String format = imagePath.substring(outpath.lastIndexOf(".") + 1);
			// 使用我们指定的文件，使用ImageIO对象的静态方法read以图片的格式，创建一个BufferedImage对象（相当于一个图片）
			// 相当于使用指定的文件创建一个文图片对象
			BufferedImage image = ImageIO.read(in);

			// 创建一个我们压缩后要生成的图片的对象，这里使用我们指定压缩的图片的宽高来创建一个我们需要的图片对象
			// 同时第三个参数是指定我们构建的这张图片的图片类型为RGB格式
			// 现在创建的这张图片是一张空白的图片，待会我们要将我们指定的图片进行压缩后，写入这张空白的图片
			BufferedImage _image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			// 使用我们创建的空白的图片并获取他的画笔，并使用这个画笔来在我们空白的图片上绘制一张压缩后的图片
			// 使用drawImage(要压缩的图片，画笔起始的x坐标，画笔起始的y坐标，要画的宽度，绘制图形的高度，指定绘制完成后要通知的观察者（一般不指定）)
			boolean tag = _image.getGraphics().drawImage(image, 0, 0, width, height, null);
			if (tag == true) {
				// 使用图片输出流以指定的格式输出到指定文件
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
	 * 这个方法实现了将指定的图片的长和宽都压缩（或放大）成指定长度的图片的作用
	 * 
	 * @param imagePath
	 *            要被压缩（放大）的图片的文件位置
	 * 
	 * @param outpath
	 *            经处理后的图片输出的路径
	 * @param format
	 *            输出图片的格式
	 * @param size
	 *            要调整的图片的倍数
	 * @return 是否处理成功
	 * @throws IOException
	 */
	public static boolean resizeImage(String imagePath, String outpath, double size) {
		try {
			File in = new File(imagePath);
			if (!in.exists() || !in.isFile())// 判断文件是否存在
			{
				System.out.println("====================你输入的图片路径有误，请重新选择============");
				return false;
			}
			// 获取输出图片的后缀名
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
	 * 按照百分比来缩放图片
	 * 
	 * @param imagePath
	 *            输入图片文件路径
	 * @param outpath
	 *            输出处理图片的路径
	 * @param format
	 *            输出图片的格式
	 * @param height_part
	 *            高度占比
	 * @param width_part
	 *            宽度占比
	 * @return
	 */
	public static boolean resizeImage(String imagePath, String outpath, double height_part, double width_part) {
		try {
			File in = new File(imagePath);
			if (!in.exists() || !in.isFile())// 判断文件是否存在
			{
				System.out.println("====================你输入的图片路径有误，请重新选择============");
				return false;
			}
			// 获取输出图片的后缀名
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
	 *            原始图片的路径
	 * @param outPath
	 *            插入文字后图片的输出路径
	 * @param word
	 *            要插入的文字
	 * @param font
	 *            插入文字的样式
	 * @param color
	 *            插入文字的颜色
	 * @param x_part
	 *            插入字体在图片位置y轴上占的百分比位置
	 * @param y_part
	 *            插入文字在图片位置y轴上占的百分比位置
	 * @throws IOException
	 */
	public static boolean drawWordsOnPicture(String imagePath, String outPath, String word, Font font, Color color,
			double x_part, double y_part) {
		try {
			File in = new File(imagePath);
			if (!in.exists() || !in.isFile())// 判断文件是否存在
			{
				System.out.println("====================你输入的图片路径有误，请重新选择============");
				return false;
			}
			// 获取原始图片的后缀名
			String format = imagePath.substring(imagePath.lastIndexOf(".") + 1);
			// 读入原始图片
			BufferedImage image = ImageIO.read(in);
			// 获取原始图片的长宽
			int height = image.getHeight();
			int width = image.getWidth();
			// 创建图片对象用于存放添加文字后的图片内容（这里不能直接在原始图片上加字，必须创建一个新的对象来承接，不然无效）
			BufferedImage _image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			// 获取新建图像的画笔
			Graphics g = _image.getGraphics();
			// 创建一个字体对象来对我们要添加的字体设置样式
			// Font font = new Font("宋体", Font.BOLD, 30);
			// 给画笔设置新的字体
			g.setFont(font);
			// 设置画笔的颜色，设置添加字体的颜色
			g.setColor(color);
			// 将原始图片绘制到我们新建的图片中（因为我们不能直接在原始图片上添加字体）
			g.drawImage(image, 0, 0, width, height, null);
			// 将图片位置的百分比位置转换为实际像素位置
			int x = (int) (width * x_part);
			int y = (int) (height * y_part);
			// 开始给新建图片写上字体
			g.drawString(word, x, y);
			// 将新建的图片输出到我们原始图片的路径，同时覆盖原始图片
			return ImageIO.write(_image, format, new File(outPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
