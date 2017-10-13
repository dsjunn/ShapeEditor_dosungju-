import processing.core.PApplet;

class Triangle extends Shape {

    Triangle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(PApplet pApplet) {
        pApplet.triangle(x-20,y+20, x, y-20,x+20, y+20);
    }

    @Override
    public boolean checkCollision(int posX, int posY) {

        double a1 = (getX()-(0.5)*getY()+10-posX+0.5*posY)*0.025;
        double a2 = (20+getY()-posY)*0.025;
        double a3 = (10-getX()-(getY()*0.5)+posX+(posY*0.5))*0.025;

        return a1>=0 && a2>=0 && a3>=0;

    }

    @Override
    public Triangle clone() {
        return (Triangle) super.clone();
    }
}