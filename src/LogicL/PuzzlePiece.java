package LogicL;

import javax.swing.*;

public class PuzzlePiece {
    private int index;
    private ImageIcon image;
    private boolean moveable;

    public PuzzlePiece(int index, ImageIcon image) {
        this.index = index;
        this.image = image;
        this.moveable = false;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }
}
