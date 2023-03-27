package secondquestion;

public final class Currency {
    private String currencyName;
    private int[] currencyValues;

    Currency (String currencyName, int[] currencyValues) {
        this.currencyName = currencyName;
        this.currencyValues = currencyValues;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public int[] getCurrencyValues() {
        return this.currencyValues;
    }

}