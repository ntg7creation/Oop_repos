package StorageL;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import PresentationL.old_Menu_no_need_for_this;

public class image_Loader {

	private BufferedImage[][] cat;
	private BufferedImage[][] cyber;
	private BufferedImage[][] sushi;

	public image_Loader() {
		load_Cat();
		load_Cyber();
		load_Sushi();

	}

	private void load_Cat() {
		BufferedImage temp;
		cat = new BufferedImage[4][];
		cat[0] = new BufferedImage[1];
		try {
			String path = "Resources/Images/cat/cat.jpeg";
			System.out.println("trying to load : " + path);
			temp = ImageIO.read(new File(path));
			cat[0][0] = temp;
		} catch (IOException e) {
			System.out.println("fail to load img");
		}

		for (int size = 3; size <= 5; size++) {
			cat[size - 2] = new BufferedImage[size * size];
			for (int i = 1; i <= size * size; i++) {
				String path = "Resources/Images/cat/cat_" + Integer.toString(size) + "x" + Integer.toString(size) + "/"
						+ Integer.toString(i) + ".jpeg";

				try {
					System.out.println("trying to load : " + path);
					temp = ImageIO.read(new File(path));
					cat[size - 2][i - 1] = temp;
				} catch (IOException e) {
					System.out.println("fail to load img");
				}
			}
		}
	}

	private void load_Cyber() {
		BufferedImage temp;
		cyber = new BufferedImage[4][];
		cyber[0] = new BufferedImage[1];
		try {
			String path = "Resources/Images/cyber/cyber.jpeg";
			System.out.println("trying to load : " + path);
			temp = ImageIO.read(new File(path));
			cyber[0][0] = temp;
		} catch (IOException e) {
			System.out.println("fail to load img");
		}

		for (int size = 3; size <= 5; size++) {
			cyber[size - 2] = new BufferedImage[size * size];
			for (int i = 1; i <= size * size; i++) {
				String path = "Resources/Images/cyber/cyber_" + Integer.toString(size) + "x" + Integer.toString(size)
						+ "/" + Integer.toString(i) + ".jpeg";

				try {
					System.out.println("trying to load : " + path);
					temp = ImageIO.read(new File(path));
					cyber[size - 2][i - 1] = temp;
				} catch (IOException e) {
					System.out.println("fail to load img");
				}
			}
		}
	}

	private void load_Sushi() {
		BufferedImage temp;
		sushi = new BufferedImage[4][];
		sushi[0] = new BufferedImage[1];
		try {
			// y did you make this one jpg
			String path = "Resources/Images/sushi/sushi.jpg";
			System.out.println("trying to load : " + path);
			temp = ImageIO.read(new File(path));
			sushi[0][0] = temp;
		} catch (IOException e) {
			System.out.println("fail to load img");
		}

		for (int size = 3; size <= 5; size++) {
			sushi[size - 2] = new BufferedImage[size * size];
			for (int i = 1; i <= size * size; i++) {
				String path = "Resources/Images/sushi/sushi_" + Integer.toString(size) + "x" + Integer.toString(size)
						+ "/" + Integer.toString(i) + ".jpeg";

				try {
					System.out.println("trying to load : " + path);
					temp = ImageIO.read(new File(path));
					sushi[size - 2][i - 1] = temp;
				} catch (IOException e) {
					System.out.println("fail to load img");
				}
			}
		}
	}

	public BufferedImage get_Cat(int size, int n) {
		if (size == 0)
			return cat[0][0];
		
		if (size > 5 | size < 3 | n > size * size | n < 1)
			throw new ArrayIndexOutOfBoundsException();

		return cat[size - 2][n - 1];
	}

	public BufferedImage get_Cyber(int size, int n) {
		if (size == 0)
			return cyber[0][0];
		
		if (size > 5 | size < 3 | n > size * size | n < 1)
			throw new ArrayIndexOutOfBoundsException();

		return cyber[size - 2][n - 1];
	}

	public BufferedImage get_Sushi(int size, int n) {
		if (size == 0)
			return sushi[0][0];
		
		if (size > 5 | size < 3 | n > size * size | n < 1)
			throw new ArrayIndexOutOfBoundsException();

		return sushi[size - 2][n - 1];
	}

	public static void main(String[] args) {

		new image_Loader();

	}
}
