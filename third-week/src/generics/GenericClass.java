package generics;


class MyGenericClass<T> {
    T obj;
    void setObj(T obj) {
        this.obj = obj;
    }
    T getObj() {
        return this.obj;
    }
}

class InternalClass {
    String name;
    int age;
    InternalClass (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + this.name  + "-" +this.age + "]";
    }
}
public class GenericClass {
    public static void main(String[] args) {
        MyGenericClass<InternalClass> obj = new MyGenericClass<>();
        InternalClass internalClass = new InternalClass("Rohit", 36);
        obj.setObj(internalClass);
        System.out.println(obj.getObj());
    }
}
