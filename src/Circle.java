import processing.core.PApplet;

class Circle extends Shape {
    Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(PApplet pApplet) {
        pApplet.ellipse(x,y,100,100);
    }

    @Override
    public boolean checkCollision(int posX, int posY) {
        return ((posX-x)*(posX-x) + (posY-y)*(posY-y)) < (100*100);
    }

    @Override
    public Circle clone() {
        return (Circle) super.clone();
    }
}