import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class KthLargestKthSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int k = scanner.nextInt();

        if(k > n || k < 0) {
            System.out.println("Enter k less than n or greater than 0");
            System.exit(1);
        }

        System.out.println("Kth largest: " + kthLargest(arr, k));

        System.out.println("Kth Smallest: " + kthSmallest(arr, k));
        scanner.close();
    }

    public static int kthLargest (int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = arr.length;
        for(int i = 0; i<n; i++) {
            pq.add(arr[i]);
        }

        while(pq.size()>0) { 
            k--;
            if(k == 0) break;
            pq.poll();
        }

        return pq.poll();
    }

    public static int kthSmallest (int arr[], int k) {
        Arrays.sort(arr);
        return arr[k-1];
    }
}
