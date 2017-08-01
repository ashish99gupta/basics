package array;

import static sorting.HeapSort.swap;

public class RotatedArray {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8,9,10};
    int rotateBy = 4;
    rotateArray(rotateBy,arr);
  }

  private static void rotateArray(int rotateBy, int[] arr) {
    for (int i = 0,j = rotateBy-1; i <= j; i++,j--) {
      swap(arr,i,j);
    }
    for (int i = rotateBy,j = arr.length-1; i <= j; i++,j--) {
      swap(arr,i,j);
    }
    for (int i = 0,j = arr.length-1; i <= j; i++,j--) {
      swap(arr,i,j);
    }
    for (int i = 0;i<= arr.length-1; i++) {
      System.out.print(arr[i]+ " ");
    }
  }
}
