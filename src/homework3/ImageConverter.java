package homework3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import library.ImageBufferDrawing;

public class ImageConverter {

	public static void main(String[] args) throws IOException {

		File image = new File("heart.png");

		BufferedImage pilt = ImageIO.read(image);
		
		BufferedImage input = ImageBufferDrawing.removeAlphaChannel(pilt);

		for (int j = 4; j < input.getHeight(null); j += 8) {
			for (int i = 4; i < input.getWidth(null); i += 8) {

				int rgb = input.getRGB(i, j);
				float red = ((rgb & 0x00ff0000) >> 16) / 255f;
				float green = ((rgb & 0x0000ff00) >> 8) / 255f;
				float blue = (rgb & 0x000000ff) / 255f;
				float value = ((red + green + blue) / 3f);

				System.out.print((value > 0.5f ? " " : "X"));
				
				/*
				 * ASCII converter Mk4
				 * 
				 * Due to alpha channels being annoying, I had to find a way to remove it, added it to libary.
				 * Output seems satisfactory
				 */
				
			}

			System.out.println();
		}

	}

}
