package interview.TowerResearch;

import java.util.Scanner;

public class MinimumCabsRequired {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.next() + " " + sc.next();

    }
    int rs = minCabs(arr);
    System.out.println(rs);
  }

  public static int minCabs(String[] intervals){
    int[] minCabs= new int[1441];
    int max=0;
    for(String interval:intervals){
      String[] arr=interval.split(" ");
      String first=arr[0];
      String second=arr[1];
      String h1=first.split(":")[0];
      String m1=first.split(":")[1];
      int h1_num=Integer.parseInt(h1)*60;
      int m1_num=Integer.parseInt(m1);
      int start=h1_num+m1_num;
      String h2=second.split(":")[0];
      String m2=second.split(":")[1];
      int h2_num=Integer.parseInt(h2)*60;
      int m2_num=Integer.parseInt(m2);
      int end=h2_num+m2_num;
      for(int i=start;i<end;i++){
        minCabs[i]+=1;
      }
      for(int j=0;j<minCabs.length;j++){
        max=Math.max(max,minCabs[j]);
      }
    }
    return max;
  }
}
