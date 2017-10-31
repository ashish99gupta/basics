package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets {
  private Set<String> set = new HashSet<>();

  public static void main(String[] args) {
    char[] arr = "[1,2,1,2]".toCharArray();
    for (int i = 0; i < arr.length; i++) {
      printallCombination(arr,i);
    }
    //Arrays.sort(arr);
    System.out.println();
  }

  private static void printallCombination(char[] arr, int i) {
    List<String> list = new ArrayList<>();
    for (int j = i; j < arr.length; j++) {

    }
  }
}
