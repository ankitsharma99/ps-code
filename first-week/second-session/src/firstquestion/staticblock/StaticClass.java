 package firstquestion.staticblock;

public class StaticClass {
    static {
        System.out.println("printing from static block");
    }

    StaticClass() {
        System.out.println("Static class Constructor");
    }
}
