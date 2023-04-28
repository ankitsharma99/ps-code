package firstsession.designpatterns.creational;

interface Shape {
    void computeArea();
}

class Circle implements Shape {

    @Override
    public void computeArea() {
        System.out.println("Computing circle area");
    }
}

class Rectangle implements Shape {

    @Override
    public void computeArea() {
        System.out.println("Computing rectangle area");
    }
}

class Polygon implements Shape {

    @Override
    public void computeArea() {
        System.out.println("Computing polygon area");
    }
}

class ShapeInstanceFactory {
    public Shape getShapeInstance(String value) {
        if(value.equals("Circle")) {
            return new Circle();
        }
        else if(value.equals("Rectangle")) {
            return new Rectangle();
        }
        else if(value.equals("Polygon")) {
            return new Polygon();
        }
        return null;
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        ShapeInstanceFactory shapeInstanceFactory = new ShapeInstanceFactory();
        Shape circleObj = shapeInstanceFactory.getShapeInstance("Circle");
        circleObj.computeArea();

    }
}
