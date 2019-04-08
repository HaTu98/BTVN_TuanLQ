import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Picture {
	String pad;
	int width;
	int height;
	BufferedImage bufImg;
	
	public Picture(int width, int height) {
		this.width = width;
		this.height = height;
		bufImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public void setImg(int x, int y, Color rgb) {
		bufImg.setRGB(x, y, rgb.getRGB());
	}
	
	public void writeImg(String pad, String type) {
		try {
			File file = new File(pad);
			ImageIO.write(bufImg, type, file);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
