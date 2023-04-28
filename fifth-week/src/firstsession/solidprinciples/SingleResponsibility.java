package firstsession.solidprinciples;

// a class should only have one responsibility and only one reason to change
class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
    // only things related to dimensions of the rectangle should come here
}

class RectangleDrawer {
    public void printBlackAndWhite(Rectangle rectangle) {
        System.out.println("Printing black and white rectangle");
    }
    public void printColor(Rectangle rectangle) {
        System.out.println("Printing a colorful rectangle");
    }
    // all other ways of printing
}

public class SingleResponsibility {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20);
        RectangleDrawer rectangleDrawer = new RectangleDrawer();

        rectangleDrawer.printBlackAndWhite(rectangle);
        rectangleDrawer.printColor(rectangle);
    }
}
