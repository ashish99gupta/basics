package strings;

import sorting.HeapSort;

/*
Given a string of lowercase alphabets and a number k, the task is to print the minimum value of the
 string after removal of ‘k’ characters. The value of a string is defined as the sum of squares of
  the count of each distinct character.
Example:
Input : str = abccc, K = 1
Output : 6
We remove c to get the value as 1^1 + 1^1 + 2^2
 */

public class GameWithString {
  public static void main(String[] args) {
    String s = "abccc";
    int k = 2;
    int sum = 0;
    int[] frequency = new int[26];
    for (char c: s.toCharArray()){
      frequency[c-97]++;
    }

    for (int i = frequency.length/2; i >= 0; i--) {
      HeapSort.maxTopDownHeapify(frequency,frequency.length,i);
    }

    for (int i = k; i > 0 ; i--){
      frequency[0]--;
      HeapSort.maxTopDownHeapify(frequency,frequency.length,0);
    }
    for (int i = 0; i <26 ; i++) {
      if (frequency[i]>0){
        sum = sum + frequency[i]*frequency[i];
      }
    }

    System.out.println(sum);
  }
}
