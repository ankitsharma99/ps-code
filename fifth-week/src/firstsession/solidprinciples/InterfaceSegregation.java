package firstsession.solidprinciples;

// classes should not be forced to depend on interfaces that they do not use

interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

class FaxMachine implements Printable, Scannable {

    @Override
    public void print() {
        System.out.println("Printing from Fax Machine");
    }

    @Override
    public void scan() {
        System.out.println("Scanning from Fax Machine");
    }
}

class InkjetPrinter implements Printable {

    @Override
    public void print() {
        System.out.println("Printing from InkJet Printer");
    }
}

public class InterfaceSegregation {
    public static void main(String[] args) {
        FaxMachine faxMachine = new FaxMachine();
        faxMachine.print();
        faxMachine.scan();

        InkjetPrinter inkjetPrinter = new InkjetPrinter();
        inkjetPrinter.print();
    }
}
