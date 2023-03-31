package fourthquestion;


public class ClassLoadingExample {
    public static void main(String[] args) {
        try {

            Class myClass = Class.forName("fourthquestion.LoadClass");
            Object obj = myClass.getDeclaredConstructor().newInstance();

            ((LoadClass)obj).printSomething();

            System.out.println(myClass);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
