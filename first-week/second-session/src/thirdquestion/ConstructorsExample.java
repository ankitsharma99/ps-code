

public class ConstructorsExample {
    public static void main(String[] args) {
        TataCars tata = new TataCars();

        TataCars tataHarrier = new TataCars("Harrier", 5.0, 22L);
    }
}

class TataCars {
    private String carModelName;
    private Double safetyRating;
    private Long priceInLacs;

    TataCars () {
        this.carModelName = "Tata";
        this.safetyRating = 4.5;
        this.priceInLacs = 10L;
        System.out.println(this.carModelName + " has an overall safety rating of: " + this.safetyRating + " and a base price of: " + this.priceInLacs + " lacs");
    }

    TataCars (String carModelName, Double safetyRating, Long priceInLacs) {
        this.carModelName = carModelName;
        this.safetyRating = safetyRating;
        this.priceInLacs = priceInLacs;

        System.out.println( "Tata " +this.carModelName + " has a safety rating of: " + this.safetyRating + " and a price of: " + this.priceInLacs + " lacs");
    }
}
