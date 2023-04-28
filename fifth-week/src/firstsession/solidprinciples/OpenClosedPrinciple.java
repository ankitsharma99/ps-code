package firstsession.solidprinciples;

// Open for extension but closed for modification
enum PaymentMethod {
    UPI,
    CRYPTO

}

class PaymentProcessor {
    public void doPayment(String paymentMethod) {
        if(paymentMethod.equalsIgnoreCase(String.valueOf(PaymentMethod.UPI))) {
            System.out.println("Processed payment from UPI");
        }
        else {
            throw new IllegalArgumentException("Invalid Payment Method");
        }
    }
}

// added new functionality of Crypto
class CryptoPaymentsProcessor extends PaymentProcessor {
    public void doPayment(String paymentMethod) {
        if(paymentMethod.equalsIgnoreCase(String.valueOf(PaymentMethod.CRYPTO))) {
            // new implementation for CRYPTO payments
            System.out.println("Processed payment from CRYPTO");
        }
        else {
            throw new IllegalArgumentException("Invalid Payment Method");
        }
    }
}


public class OpenClosedPrinciple {
    public static void main(String[] args) {
        PaymentProcessor upiPaymentProcessor = new PaymentProcessor();
        upiPaymentProcessor.doPayment(String.valueOf(PaymentMethod.UPI));


        CryptoPaymentsProcessor cryptoPaymentsProcessor = new CryptoPaymentsProcessor();
        cryptoPaymentsProcessor.doPayment(String.valueOf(PaymentMethod.CRYPTO));

    }
}
