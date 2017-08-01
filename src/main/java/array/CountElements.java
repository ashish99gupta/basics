package array;

import java.util.Scanner;

public class CountElements {
    public static void main(String[] args) {
        int t,n;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        while (t > 0){
            n = s.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = s.nextInt();
            }
            for (int i = 0; i < n; i++) {
                B[i] = s.nextInt();
            }

            t--;
        }
    }
}
