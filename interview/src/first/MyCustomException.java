package first;

public class MyCustomException extends Exception{
    public MyCustomException (String msg) {
        super(msg);
        System.out.println("THis exception occured");
    }
}
