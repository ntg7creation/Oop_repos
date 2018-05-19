package StorageL;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class image_Loader {

	private BufferedImage[][] images;
	private String path = "src/Resources/";
	private Boolean allLoaded = false;

	public image_Loader(String name) {
		load_Images(name);
	}

	public Boolean isLoaded() {
		return allLoaded;
	}

	private void load_Images(String name) {
		BufferedImage temp;
		images = new BufferedImage[4][];
		images[0] = new BufferedImage[1];
		allLoaded = true;
		try {
			String path = this.path + name + "/" + name + ".jpeg";
			// System.out.println("trying to load : " + path);
			
			temp = ImageIO.read(new File(path));
			images[0][0] = temp;
		} catch (IOException e) {
			System.out.println("fail to load img");
			allLoaded = false;
		}

		
		for (int size = 3; size <= 5; size++) {
			images[size - 2] = new BufferedImage[size * size];
			for (int i = 1; i <= size * size; i++) {
				String path = this.path + name + "/" + name + "_" + Integer.toString(size) + "x"
						+ Integer.toString(size) + "/" + Integer.toString(i) + ".jpeg";

				try {
					// System.out.println("trying to load : " + path);
					temp = ImageIO.read(new File(path));
					images[size - 2][i - 1] = temp;
				} catch (IOException e) {
					System.out.println("fail to load img");
					allLoaded = false;
				}
			}
		}
	}

	public BufferedImage get_Image(int size, int n) {
		if (size == 0)
			return images[0][0];

		if (size > 5 | size < 3 | n > size * size | n < 1)
			throw new ArrayIndexOutOfBoundsException();

		return images[size - 2][n - 1];
	}

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}

}
