package week4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class YearPredicate implements Predicate<Transaction> {

    @Override
    public boolean test(Transaction transaction) {
        return transaction.getYear() == 2011;
    }
}

class ValueComparator implements Comparator<Transaction> {

    @Override
    public int compare(Transaction o1, Transaction o2) {
        return o1.getValue() - o2.getValue();
    }
}

class TraderCityMapper implements Function<Transaction, String> {

    @Override
    public String apply(Transaction transaction) {
        return transaction.getTrader().getCity();
    }
}

class CityPredicate implements Predicate<Trader> {
    private String cityName;
    public CityPredicate(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean test(Trader trader) {
        return trader.getCity().equalsIgnoreCase(cityName);
    }
}

class NameMapper implements Function<Transaction, String> {

    @Override
    public String apply(Transaction transaction) {
        return transaction.getTrader().getName();
    }
}

class TransactionPredicate implements Predicate<Transaction> {

    private String cityName;
    public TransactionPredicate (String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean test(Transaction transaction) {
        return transaction.getTrader().getCity().equalsIgnoreCase(this.cityName);
    }
}
public class TraderTxn {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");


        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


//        1. Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> transactions1 = transactions.stream().filter(new YearPredicate()).sorted(new ValueComparator()).collect(Collectors.toList());
        System.out.println("Txns in 2011 and sorted by value: " + transactions1);



//        2. What are all the unique cities where the traders work?
        List<String> cities = transactions.stream().map(new TraderCityMapper()).distinct().collect(Collectors.toList());
        System.out.println("Unique cities: " + cities);



//        3. Find all traders from Cambridge and sort them by name.
        List<Trader> traders =  transactions.stream().map(Transaction::getTrader).filter(new CityPredicate("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println("Traders from Cambridge sorted by name: " + traders);



//        4. Return a string of all traders’ names sorted alphabetically.
        List<String> tradersSorted = transactions.stream().map(new NameMapper()).sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        System.out.println("Trader names sorted alphabetically: " + tradersSorted);




//        5. Are any traders based in Milan?
        List<Trader> milanTraders = transactions.stream().map(Transaction::getTrader).filter(new CityPredicate("Milan")).collect(Collectors.toList());
        System.out.println("All traders from Milan: " + milanTraders);


//        6. Print all transactions’ values from the traders living in Cambridge.
        List<Integer> txnValuesFromCambridge = transactions.stream().filter(new TransactionPredicate("Cambridge")).map(Transaction::getValue).collect(Collectors.toList());
        System.out.println("Transaction Values from Cambridge: " + txnValuesFromCambridge);



//        7. What’s the highest value of all the transactions?
        OptionalInt highestValue = transactions.stream().mapToInt(Transaction::getValue).max();
        System.out.println("Highest Value is: " + highestValue.getAsInt());



//        8. Find the transaction with the smallest value

        OptionalInt smallestValue = transactions.stream().mapToInt(Transaction::getValue).min();
        System.out.println("Smallest Value is: " + smallestValue.getAsInt());
    }
}


class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}

class Trader{
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}