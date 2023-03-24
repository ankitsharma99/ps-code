
import java.util.Scanner;

public class MaxOccurringCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String input = scanner.next();

        int[] cnt = new int[256];

        char maxOccurringCharacter = 0;
        int mx = Integer.MIN_VALUE;

        char[] arr = input.toCharArray();

        for(int i = 0; i<arr.length; i++) {
            cnt[arr[i]]++;
        }

        for(int i = 0; i<arr.length; i++) {
            if(mx < cnt[arr[i]]) {
                mx = cnt[arr[i]];
                maxOccurringCharacter = arr[i];
            }
        }

        System.out.println("Max occurring character is : " + maxOccurringCharacter);
        System.out.println("Frequency of maxOccurring character is: "+ mx);
        scanner.close();
    }
}
