import java.awt.Color;

public class Main {
	public static void main(String [] args) {
		int size100 = 1000;
		String png = "C:\\Java\\png1000.png";
		String bmp = "C:\\Java\\bmp1000.bmp";
		Picture png100 = new Picture(size100,size100);
		Picture bmp100 = new Picture(size100, size100);
		for(int x = 0; x < size100; x++) {
			for(int y = 0; y < size100; y++) {
				png100.setImg(x, y, new Color(255,0,0));
				bmp100.setImg(x, y, new Color(255,0,0));
			}
		}
		
		png100.writeImg(png, "png");
		bmp100.writeImg(bmp, "bmp");
		System.out.println("success");
	}
}
