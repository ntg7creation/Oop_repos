package Storage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
* Responsible for loading the images
* Using Singleton DP
* */
public class ImageLoader {

    private final int pixelOfCell = 25;

    private Image[] redPacman;
    private Image[] bluePacman;
    private Image[] yellowPacman;
    private Image[] greenGhost;
    private Image[] redGhost;
    private Image[] yellowGhost;
    private Image[] apple;
    private Image[] energyPalet;
    private Image[] pineapple;
    private Image[] strawberry;
    private Image[] yellowPalet;
    private Image[] fireBall;
    private Image[] waterSplash;

    private final String path = "res/Images/";

    private static ImageLoader instance = null;

    private ImageLoader() {
        String pacmanPath = path + "Pacman/";
        String bluePPath = pacmanPath + "Blue/";
        bluePacman = this.generateSprite(bluePPath, 8);
        String redPPath = pacmanPath + "Red/";
        redPacman = this.generateSprite(redPPath, 8);
        String yellowPPath = pacmanPath + "Yellow/";
        yellowPacman = this.generateSprite(yellowPPath, 8);

        String ghostPath = path + "Ghosts/";
        String greenGPath = ghostPath + "GhostGreen.png";
        greenGhost = generateSprite(greenGPath);
        String redGPath = ghostPath + "GhostRed.png";
        redGhost = generateSprite(redGPath);
        String yellowGPath = ghostPath + "GhostYellow.png";
        yellowGhost = generateSprite(yellowGPath);

        String attacksPath = path + "Attacks/";
        String fireballPath = attacksPath + "Fireball/";
        fireBall = this.generateSprite(fireballPath, 4);
        String waterSplashPath = attacksPath + "WaterSplash/";
        waterSplash = this.generateSprite(waterSplashPath, 4);

        String foodPath = path + "Food/";
        String applePath = foodPath + "Apple.png";
        apple = generateSprite(applePath);
        String energyPath = foodPath + "EnergyPills.png";
        energyPalet = generateSprite(energyPath);
        String pineapplePath = foodPath + "Pineapple.png";
        pineapple = generateSprite(pineapplePath);
        String strawPath = foodPath + "Strawberry.png";
        strawberry = generateSprite(strawPath);
        String yellowPaletPath = foodPath + "NormalPill.png";
        yellowPalet = generateSprite(yellowPaletPath);
    }

    private Image[] generateSprite(String imagePath) {
        Image[] sprite = new Image[1];
        sprite[0] = loadImage(imagePath);

        if (sprite[0] == null)
            return null;

        return sprite;
    }

    private Image[] generateSprite(String folderPath, int numOfPics) {
        boolean success = true;
        Image[] sprite = new Image[numOfPics];
        for (int i = 0; i < numOfPics && success; i++) {
            sprite[i] = loadImage(folderPath + String.valueOf(i) + ".png");
            if (sprite[i] == null) {
                success = false;
            }
        }

        if (!success) {
            sprite = null;
        }

        return sprite;
    }

    private Image loadImage(String imagePath) {
        try {
            BufferedImage src = ImageIO.read(new File(imagePath));
            return resize(src, pixelOfCell, pixelOfCell);
        } catch (IOException e) {
            return null;
        }
    }


    private Image resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }

        return instance;
    }

    //region Getters
    public Image[] getRedPacman() {
        return redPacman;
    }

    public Image[] getBluePacman() {
        return bluePacman;
    }

    public Image[] getYellowPacman() {
        return yellowPacman;
    }

    public Image[] getGreenGhost() {
        return greenGhost;
    }

    public Image[] getRedGhost() {
        return redGhost;
    }

    public Image[] getYellowGhost() {
        return yellowGhost;
    }

    public Image[] getApple() {
        return apple;
    }

    public Image[] getEnergyPalet() {
        return energyPalet;
    }

    public Image[] getYellowPalet() {
        return yellowPalet;
    }

    public Image[] getPineapple() {
        return pineapple;
    }

    public Image[] getStrawberry() {
        return strawberry;
    }

    public Image[] getFireBall() {
        return fireBall;
    }

    public Image[] getWaterSplash() {
        return waterSplash;
    }
    //endregion
}
