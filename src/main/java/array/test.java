package array;

public class test {
  public static void main(String[] args) {
    int[] p = {-5,4,-2,3,1,-1,-6,-1,9};
    int max = Integer.MAX_VALUE;
    int sum =0;
    for (int i = 0; i < p.length; i++) {
      sum = sum +p[i];
      if(sum<max){
        max = sum;
      }
    }
    System.out.println(Math.abs(max) +1);
  }
}
