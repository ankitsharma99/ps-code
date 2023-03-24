
public class StaticBlockExample {

    public static void main(String[] args) {
        System.out.println("Printing from main method");

        new StaticClass();
    }
}

class StaticClass {
    static {
        System.out.println("printing from static block");
    }

    StaticClass() {
        System.out.println("Static class Constructor");
    }
}
