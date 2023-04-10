package generics;

import java.util.ArrayList;
import java.util.List;

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");

    }
}
public class WildcardExtendsAndSuperExample {
    public static void drawShapes (List<? extends Shape> list ) {
        for(Shape s : list) {
            s.draw();
        }
    }
    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());

        drawShapes(rectangles);
        drawShapes(circles);
    }
}
