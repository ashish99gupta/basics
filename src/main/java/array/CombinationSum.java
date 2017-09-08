package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSum {
  private HashMap<String,Boolean> map = new HashMap<>();
  public static void main(String[] args) {
    int[] arr = {2,1,3,4};
    int sum = 5;
    CombinationSum combinationSum = new CombinationSum();
    combinationSum.printSol(arr, sum);

  }

  private void printSol(int[] arr, int sum) {
    List<List<Integer>> listList = new ArrayList<>();
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      List<Integer> list = new ArrayList<>();
      getRepeatedList(arr, i, sum,list);
      //getList(arr, i, sum,list );
      //listList.add(list);
    }
  }

  private void getList(int[] arr, int start, int sum, List<Integer> list) {
   if (sum == 0){
     String key ="";
     for (Integer in : list){
       key = key.concat(String.valueOf(in));
     }
     if (!map.containsKey(key)){
       list.forEach(in -> System.out.print(in + " "));
       System.out.println();
       map.put(key,true);
     }
     return;
   }
    for (int i = start; i < arr.length; i++) {
      if (sum-arr[i] >=0 ){
        if (list.contains(arr[i]))
          continue;
        list.add(arr[i]);
        getList(arr,i+1,sum-arr[i],list);
        list.remove(list.size()-1);
      }else {
        break;
      }
    }
  }

  private void getRepeatedList(int[] arr, int start, int sum, List<Integer> list) {
    if (sum == 0){
      String key ="";
      for (Integer in : list){
        key = key.concat(String.valueOf(in));
      }
      if (!map.containsKey(key)){
        list.forEach(in -> System.out.print(in + " "));
        System.out.println();
        map.put(key,true);
      }
      return;
    }
    for (int i = start; i < arr.length; i++) {
      if (sum-arr[i] >=0 ){
        list.add(arr[i]);
        getRepeatedList(arr,i,sum-arr[i],list);
        list.remove(list.size()-1);
      }else {
        break;
      }
    }
  }
}
