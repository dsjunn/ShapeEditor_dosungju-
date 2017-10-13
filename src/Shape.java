import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

abstract class Shape implements Cloneable {
    int x;
    int y;
    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(PApplet pApplet) {
        System.out.println("Shape draw");

    }

    public abstract boolean checkCollision (int posX,int posY);

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void setX(int x){
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
}
