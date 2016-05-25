package library;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageBufferDrawing {

	 public static BufferedImage removeAlphaChannel(BufferedImage image) {
	        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = newImage.createGraphics();
	        g2d.setColor(Color.WHITE);
	        g2d.fillRect(0, 0, newImage.getWidth(), newImage.getHeight());
	        g2d.drawImage(image, 0, 0, null);
	        g2d.dispose();
	        return newImage;
	    }
	 
}