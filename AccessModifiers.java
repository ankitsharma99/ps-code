class Values {
    private int a;
    public int b;
    protected int c;

    Values (int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class  AccessModifiers {
    public static void main(String[] args) {
        Values values = new Values(1, 2, 3);
        // System.out.println(values.a);             // throws error

        System.out.println(values.b);   // outputs 2
        System.out.println(values.c); // 3
    }
}