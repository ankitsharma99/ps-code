package secondsession.secondquestion;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChainingExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<User> fetchUserDetailsFuture = CompletableFuture.supplyAsync(CompletableFutureChainingExample::fetchUserDetails);

        System.out.println("userDetailsFuture: " + fetchUserDetailsFuture);
        System.out.println();

        CompletableFuture<String> extractEmailAddressFuture = fetchUserDetailsFuture.thenApply(CompletableFutureChainingExample::extractEmailAddress);

        System.out.println("extractEmailAddressFuture: " + extractEmailAddressFuture);
        System.out.println();

        CompletableFuture<Void> sendEmailFuture = extractEmailAddressFuture.thenAccept(CompletableFutureChainingExample::sendEmail);

        System.out.println("sendEmailFuture: " + sendEmailFuture);
        System.out.println();

        sendEmailFuture.get();
        System.out.println();

        System.out.println("userDetailsFuture: " + fetchUserDetailsFuture);
        System.out.println();
        System.out.println("extractEmailAddressFuture: " + extractEmailAddressFuture);
        System.out.println();
        System.out.println("sendEmailFuture: " + sendEmailFuture);
        System.out.println();
    }

    private static User fetchUserDetails() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User("Ankit", "Sharma", "ankit.sharma99@gmail.com");
    }

    private static String extractEmailAddress(User user) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user.getEmailAddress();
    }

    private static void sendEmail(String emailAddress) {
        try {
            Thread.sleep(1000);
            System.out.println("Email sent to " + emailAddress);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class User {
        private final String firstName;
        private final String lastName;
        private final String emailAddress;

        public User(String firstName, String lastName, String emailAddress) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
        }

        public String getEmailAddress() {
            return emailAddress;
        }
    }
}
