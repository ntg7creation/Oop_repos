package PresentationL;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;






public class Image_Panel extends JPanel{
   
	private BufferedImage image;
	private Image Nimage;
	private int Width;
	private int Hight;
	
    public Image_Panel(int width, int hight) {
    	super();
    	Width = width;
    	Hight = hight;
       try {                
    	   //defult path
          image = ImageIO.read(new File("sample_pictures/cyber/cyber.jpeg"));


       } catch (IOException ex) {
            System.out.println("error");
       }
    }
    
    public void changeImage(BufferedImage image)
    {
    	this.image = image;
    	paint(getGraphics());
    }
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Nimage = image.getScaledInstance(Width,Hight, image.SCALE_DEFAULT);
        g.drawImage(Nimage, 0, 0, this); // see javadoc for more info on the parameters            
    }



}
