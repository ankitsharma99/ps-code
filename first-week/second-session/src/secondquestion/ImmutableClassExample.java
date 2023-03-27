package secondquestion;

import java.util.Arrays;

public class ImmutableClassExample {
    public static void main(String[] args) {
        Currency rupees = new Currency("Rupees", new int[]{1, 2, 5, 10, 20, 50, 100, 500, 2000});

        System.out.println(rupees.getCurrencyName());
        System.out.println(Arrays.toString(rupees.getCurrencyValues()));

    }
}
