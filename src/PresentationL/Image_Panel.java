package PresentationL;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Image_Panel extends JPanel {

	private BufferedImage image;
	private Image Nimage;
	private int Width;
	private int Hight;

	public Image_Panel(int width, int hight) {
		super();
		Width = width;
		Hight = hight;
		image = null;
	}

	public void changeImage(BufferedImage image) {
		this.image = image;
		paint(getGraphics());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			Nimage = image.getScaledInstance(Width, Hight, image.SCALE_DEFAULT);
			g.drawImage(Nimage, 0, 0, this); // see javadoc for more info on the parameters
		}
	}

}
