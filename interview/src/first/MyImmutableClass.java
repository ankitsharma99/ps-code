package first;

public final class MyImmutableClass {
    private final String name;
    private final int age;

    public MyImmutableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
