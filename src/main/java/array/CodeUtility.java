package array;

import java.util.HashSet;

public class CodeUtility {

  public static boolean hasPair(int[] arr,int sum){
    int temp;
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      temp = sum - arr[i];
      if (temp>0 && set.contains(temp)){
        return true;
      }
      set.add(temp);
    }
    return false;
  }

  private static int printSol() {
    int[] a = {4,1,3,2};
    int[] leftmin = leftMin(a);
    int max= Integer.MIN_VALUE;
    int diff;
    for (int i = a.length-1 ;i >=0 ; i--) {
      diff = a[i] - leftmin[i];
      if (diff>max){
        max =diff;
      }
    }
    if (max==Integer.MIN_VALUE || max == 0)
      return -1;
    else return max;
  }

  private static int[] leftMin(int[] arr) {
    int[] leftMin = new int[arr.length];
    leftMin[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] <= leftMin[i - 1]) {
        leftMin[i] = arr[i];
      } else {
        leftMin[i] = leftMin[i - 1];
      }
    }
    return leftMin;
  }

  private static int[] rightMin(int[] arr) {
    int[] rightMin = new int[arr.length];
    rightMin[arr.length - 1] = arr[arr.length - 1];

    for (int i = arr.length - 2; i >= 0; i--) {
      if (arr[i] <= rightMin[i + 1]) {
        rightMin[i] = arr[i];
      } else {
        rightMin[i] = rightMin[i + 1];
      }
    }
    return rightMin;
  }

  private static int[] leftMax(int[] arr) {
    int[] leftMax = new int[arr.length];
    leftMax[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] >= leftMax[i - 1]) {
        leftMax[i] = arr[i];
      } else {
        leftMax[i] = leftMax[i - 1];
      }
    }
    return leftMax;
  }
}
