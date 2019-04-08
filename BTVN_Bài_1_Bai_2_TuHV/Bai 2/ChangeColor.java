import java.awt.Color;

public class ChangeColor {
	public static void main(String[] args) {
		Picture pictureOld = new Picture("C:\\Java\\BTVN_Bài_1_TuHV\\src\\old.jpg");
		System.out.println(pictureOld);
		int width = pictureOld.width();
		int height = pictureOld.height();
		
		Picture pictureNew = new Picture(width, height);
		System.out.println(pictureNew);
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				int color = pictureOld.getColor(x, y);
				
				
				pictureNew.setColor(x, y, color);
				
			}
		}
		pictureNew.showImg();
	}
}
