import processing.core.PApplet;
import processing.event.KeyEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {

    private static final String FILE_PATH = "/Users/sungjundo/IdeaProjects/ShapeEditor_Dosungjun/dsj.txt";


    private List<Shape> shapes = new ArrayList<>();
    private int type;
    private Shape selectedShape;

    public static void main(String[] args) {
        // write your code here
        PApplet.main("Main");
    }

    public Shape findShape (int x, int y) {
        for(Shape shape : shapes) {
            if (shape.checkCollision(mouseX, mouseY)) {
                return shape;
            }
        }
        return null;
    }

    @Override
    public void draw() {
        background(255);
        for (Shape shape : shapes) {
            shape.draw(this);

        }
    }

    @Override
    public void mousePressed() {
        if (type == 1) {
            shapes.add(new Circle(mouseX, mouseY));
        } else if (type == 2) {
            shapes.add(new Rect(mouseX, mouseY));
        } else if (type == 3) {
            shapes.add(new Triangle(mouseX, mouseY));
        }
    }

    @Override
    public void mouseDragged() {
        if (selectedShape == null) {
            selectedShape = findShape(mouseX, mouseY);
        }else {
            selectedShape.setX(mouseX);
            selectedShape.setY(mouseY);
        }

    }

    @Override
    public void mouseReleased() {
        selectedShape = null;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if(event.getKey() == '1') {
            type = 1;
        }else if(event.getKey() == '2'){
            type = 2;
        }else if(event.getKey() == '3') {
            type = 3;
        }else if(event.getKey() == 'd'){
            for(Shape shape : shapes){
                if(shape.checkCollision(mouseX, mouseY)) {
                    Shape newOne = shape.clone();
                    newOne.x = newOne.x + 20;
                    shapes.add(newOne);
                    System.out.println("copy");
                    return;
                }
            }
        }else if(event.getKey() == 's') {
            saveFile();
        }else if(event.getKey() == 'o') {
            loadFile();
        }
    }

    @Override
    public void settings() {
        this.size(600,600);
    }

    @Override
    public void setup() {
        //draw에 필요한 값 초기화
        this.background(255);
        System.out.println("Setup");
        type = 0;
    }

    public void cutString(String str) {
        shapes = new ArrayList<>();
        String[] info = str.split("/");
        for(int i=0; i<info.length; i+=3){
            if(info[i].contains("Rect")) {
                shapes.add(new Rect(parseInt(info[i + 1]), parseInt(info[i + 2])));
            }else if(info[i].contains("Circle")){
                shapes.add(new Circle(parseInt(info[i + 1]), parseInt(info[i + 2])));
            }else if(info[i].contains("Triangle")){
                shapes.add(new Triangle(parseInt(info[i + 1]), parseInt(info[i + 2])));
            }
        }
    }

    public void saveFile(){
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            for(Shape shape : shapes) {
                bos.write((shape.getClass() + "/" + shape.getX() + "/" + shape.getY() + "/").getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("save");
    }
    public void loadFile(){



        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            int ch;
            String str = "";

            while ((ch = bis.read()) != -1) {
                str += (char)ch;
            }
            cutString(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


