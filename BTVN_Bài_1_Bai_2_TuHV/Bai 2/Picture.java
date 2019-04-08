import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Picture {
	String imgName;
	BufferedImage bufImg;
	int width;
	int height;
	
	public Picture(String name) {
		this.imgName = name;
		
		try {
			bufImg = ImageIO.read(new File(imgName));
			System.out.println(bufImg);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public Picture(int width, int height) {
		this.width = width;
		this.height = height;
		bufImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public int width() {
		width = bufImg.getWidth();
		return width;
	}
	
	public int height() {
		height = bufImg.getHeight();
		return height;
	}
	
	public int getColor(int x, int y) {
		int color = bufImg.getRGB(x, y);
		return color;
	}
	
	public void setColor (int x, int y, int color) {
		bufImg.setRGB(x, y, color);
	};
	
	public void showImg() {
		try {
			File newImg = new File("C:\\Java\\BTVN_Bài_1_TuHV\\src\\new.jpg");
			ImageIO.write(bufImg, "jpg", newImg);
			Desktop.getDesktop().open(newImg);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
