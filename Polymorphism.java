class First {

    public void add (int a, int b) {
        System.out.println(a + b);
    }

    public void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }

    public void printtSomething() {
        System.out.println("Prints from base class");
    }
}


class Second extends First {
    public void printtSomething () {
        System.out.println("prints from child class");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Second second = new Second();

        // compile time polymorphism
        second.add(1, 2);   //// prints (3)
        second.add(1,2,3); // print 6

        // run time polymorphism
        second.printtSomething();
    }
}
