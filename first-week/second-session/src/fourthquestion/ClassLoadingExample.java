
public class ClassLoadingExample {
    public static void main(String[] args) {
        try {
            Class myClass = Class.forName("LoadClass");
            Object obj = myClass.getDeclaredConstructor().newInstance();

            ((LoadClass)obj).printSomething();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class LoadClass {
    public void printSomething() {
        System.out.println("LoadClass printed");
    }
}
