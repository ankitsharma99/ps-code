package firstquestion.staticvariable;

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
