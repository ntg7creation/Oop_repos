package assiment4.entitys;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import assiment4.logic.Timer_Listener;

import javax.imageio.ImageIO;

public abstract class MyEntity implements Timer_Listener {

    private final int pixelOfCell = 25;
    final protected int TPS = 25;
    protected int X;
    protected int Y;
    protected int offsetX;
    protected int offsetY;
    protected BufferedImage[] sprites;


    public void set_start(int x, int y) {
        X = x;
        Y = y;
    }

    public void draw(Graphics g) {

    }

    public int get_X() {
        return X;
    }

    public int get_Y() {
        return Y;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    protected boolean loadSprite(String[] imagesPath) {
        try {
            this.sprites = new BufferedImage[imagesPath.length];

            for (int i = 0; i < imagesPath.length; i++) {
                BufferedImage src = ImageIO.read(new File(imagesPath[i]));
                this.sprites[i] = resize(src, pixelOfCell, pixelOfCell);
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}