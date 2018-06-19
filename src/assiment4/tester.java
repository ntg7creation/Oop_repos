package assiment4;

import assiment4.entitys.MyEntity;
import assiment4.logic.Moving_Direction;
import assiment4.entitys.Attacks.*;
import assiment4.entitys.Pacmans.*;
import assiment4.entitys.Ghosts.*;
import assiment4.entitys.Food.*;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class tester {

	public static void main(String[] arg) {
		MyEntity fireball = new Fire_Ball();
		MyEntity waterSplash = new Water_Splash();
		MyEntity apple = new Apple();
		MyEntity energy = new Energy_Palet();
		MyEntity pine = new Pineapple();
		MyEntity straw = new Strawberry();
		MyEntity yellowP = new Yello_Palet();
		MyEntity ghostGreen = new Ghost_Green();
		MyEntity ghostRed = new Ghost_Red();
		MyEntity ghostYellow = new Ghost_Yellow();
		MyEntity yellowPacman = new Pacman_Yellow();
		MyEntity redPacman = new Pacman_Red();
		MyEntity bluePacman = new Pacman_Blue();

        Graphics g = new Graphics() {
            @Override
            public Graphics create() {
                return null;
            }

            @Override
            public void translate(int x, int y) {

            }

            @Override
            public Color getColor() {
                return null;
            }

            @Override
            public void setColor(Color c) {

            }

            @Override
            public void setPaintMode() {

            }

            @Override
            public void setXORMode(Color c1) {

            }

            @Override
            public Font getFont() {
                return null;
            }

            @Override
            public void setFont(Font font) {

            }

            @Override
            public FontMetrics getFontMetrics(Font f) {
                return null;
            }

            @Override
            public Rectangle getClipBounds() {
                return null;
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {

            }

            @Override
            public void setClip(int x, int y, int width, int height) {

            }

            @Override
            public Shape getClip() {
                return null;
            }

            @Override
            public void setClip(Shape clip) {

            }

            @Override
            public void copyArea(int x, int y, int width, int height, int dx, int dy) {

            }

            @Override
            public void drawLine(int x1, int y1, int x2, int y2) {

            }

            @Override
            public void fillRect(int x, int y, int width, int height) {

            }

            @Override
            public void clearRect(int x, int y, int width, int height) {

            }

            @Override
            public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void drawOval(int x, int y, int width, int height) {

            }

            @Override
            public void fillOval(int x, int y, int width, int height) {

            }

            @Override
            public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawString(String str, int x, int y) {

            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {

            }

            @Override
            public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public void dispose() {

            }
        };
		yellowPacman.draw(g);
		/*
		Moving_Direction dirc;

		int[][] tempcsv = new int[][] {
			{1,1,1,1,1,1,1,1,1,1,1,1},
			{1,2,2,2,2,2,1,2,2,2,2,1},
			{1,2,2,2,2,16,2,2,2,2,2,1},
			{1,2,4,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,8,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,1,2,2,1},
			{1,2,2,2,2,2,2,1,2,2,2,1},
			{1,2,32,2,2,2,2,2,2,2,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,1},
			{1,1,1,1,1,1,1,1,1,1,1,1},
		};
		dirc = Moving_Direction.Up;
		System.out.println(tempcsv[1][6]);
		System.out.println(dirc.can_Move());
	*/
	}

}
