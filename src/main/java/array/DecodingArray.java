package array;

import java.util.HashMap;
import java.util.Map;

public class DecodingArray {
  Map<Integer,Character> map = new HashMap<>();
  int count =0;
  public static void main(String[] args) {
    DecodingArray decodingArray = new DecodingArray();
    decodingArray.prepareHashMap();
    int[] arr = {1,2,3};
    decodingArray.countDecodeArray(arr,arr.length);
    System.out.println(decodingArray.count);

  }

  private void printdecodeArray(int[] arr, int i, int n) {
    printdecodeArray(arr, 1,n-1);count += countDecodeArray(arr,n-2);

    if ((arr[n-2] == 1 || arr[n-2] == 2 )&& (arr[n-1] < 7)){
      printdecodeArray(arr, 2,n-2);
    }
  }

  private int countDecodeArray(int[] arr, int n) {
    if (n==1 || n==0){
      return 1;
    }
    count += countDecodeArray(arr,n-1);
    if ((arr[n-2] == 1 || arr[n-2] == 2 )&& (arr[n-1] < 7)){
      count += countDecodeArray(arr,n-2);
    }
    return count;
  }

  private void prepareHashMap(){
    for (int i = 1; i < 27; i++) {
      map.put(i,Character.valueOf((char) (i+64)));
    }
  }
}
