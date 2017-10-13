import processing.core.PApplet;

class Rect extends Shape {
    Rect(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(PApplet pApplet) {
        pApplet.rect(x,y,100,100);
    }

    @Override
    public boolean checkCollision(int posX, int posY) {
        return (posX > x) && (posX < x+100) && (posY > y) && (posY < y+100);
    }

    @Override
    public Rect clone() {
        return (Rect) super.clone();
    }
}