package firstquestion.staticvariable;

public class Human {
    private String name;
    private Integer age;
    public  static String scientificName = "Homo Sapiens";

    Human(String name, Integer age, String scientificName) {
        this.name = name;
        this.age = age;
//        this.scientificName = scientificName;           // gives warning: Static member accessed by instance reference
        Human.scientificName = scientificName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", scientificName=" + Human.scientificName +
                '}';
    }
}
