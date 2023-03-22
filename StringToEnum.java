import java.util.Scanner;


public class StringToEnum {
    public enum MyEnum {
        JAVA,
        CPP,
        PYTHON,
        RUBY
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        MyEnum myEnum = MyEnum.valueOf(str);
        System.out.println(myEnum);
        scanner.close();
    }
}
