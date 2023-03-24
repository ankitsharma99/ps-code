

public class ICICI {
    public static void main(String[] args) {
//        Bank bank = new Bank("ICICI");
        Bank.printRegulator();      // static method
    }
}

class Bank {
    public static String regulator = "RBI";

    public String bankName;

    Bank (String bankName) {
        this.bankName = bankName;
    }

    public static void printRegulator() {
        System.out.println("Regulator of Indian banks is: " + Bank.regulator);
        //cannot access non-static member from static method (same in case of main function)
//        System.out.println("Bank name: " + this.bankName);
    }



}

