package sixthquestion;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxOccurringCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");

        try {
            String input = scanner.next();
            Pattern p = Pattern.compile("[^A-Za-z]");
            Matcher m = p.matcher(input);

            if(m.find()) throw new InvalidCharacterException("Input should only have alphabetical characters-[A-Za-z]");
            input = input.toLowerCase();

            int[] cnt = new int[26];

            char maxOccurringCharacter = 0;
            int mx = Integer.MIN_VALUE;

            for(int i = 0; i<input.length(); i++) {
                cnt[input.charAt(i)-'a']++;
            }

            for(int i = 0; i<input.length(); i++) {
                int i1 = cnt[input.charAt(i) - 'a'];
                if(mx < i1) {
                    mx = i1;
                    maxOccurringCharacter = input.charAt(i);
                }
            }
            System.out.println("Max occurring character is : " + maxOccurringCharacter);
            System.out.println("Frequency of maxOccurring character is: "+ mx);
        }
        catch (InvalidCharacterException ex) {
            System.out.print("Caught exception with message: ");
            System.out.print(ex.getMessage());
        }

        scanner.close();
    }
}
