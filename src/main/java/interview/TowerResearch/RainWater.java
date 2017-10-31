package interview.TowerResearch;

import java.util.Arrays;
import java.util.Scanner;

public class RainWater {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int res = trappedWater(arr);
    System.out.println(res);
  }


  public static int trappedWater(int [] towers){

    int totalTrappedWater=0;


    int rightToLeft[]= makeMaxArray(towers);

    int maxHeightFromLeft=0;

    for(int i=0;i<towers.length;i++){

      if(towers[i]>maxHeightFromLeft){

        maxHeightFromLeft=towers[i];

      }

      totalTrappedWater+=Math.max(Math.min(maxHeightFromLeft,rightToLeft[i])-towers[i],0);

    }

    return totalTrappedWater;

  }


  public static int[] makeMaxArray(int[] arr){

    int maxArray[] = Arrays.copyOf(arr, arr.length); // don't want to change original basics.array
    int max=Integer.MIN_VALUE;

    for(int i=maxArray.length-1;i>=0;i--){

      if (maxArray[i] > max) {

        max=maxArray[i];

      }
      else {
        maxArray[i]=max;
      }

    }

    return maxArray;

  }
}
