package firstquestion.staticclass;

public class StaticClassExample {

    static class NestedStaticClass {
        static class NestedAgain {
            public static String staticVariable = "NestedAgain";

            public static void staticMethod() {
                System.out.println("Static Method of NestedAgain Class");
            }
        }
        public static String staticVariable  = "NestedStaticClass";
        public static void staticMethod() {
            System.out.println("Static method of Nested Static Class");
        }
    }
    public static void main(String[] args) {

        System.out.println(NestedStaticClass.staticVariable);
        System.out.println(NestedStaticClass.NestedAgain.staticVariable);
        NestedStaticClass.NestedAgain.staticMethod();
        NestedStaticClass.staticMethod();
    }
}
