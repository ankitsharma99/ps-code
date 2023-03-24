

public class StaticKeywordExamples {
    public static void main(String[] args) {
        // prints Homo Sapiens
        System.out.println(Human.scientificName);

        Human ankit = new Human("Ankit", 23, "Panthera tigris");
        System.out.println("Human details: " + ankit);

        // for every access now on, will print Panthera Tigris (until not changed)
        System.out.println(Human.scientificName);
    }
}


class Human {
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
