package array;

import java.util.Arrays;

public class test1 {
  //int a;
  //test1(int x):a(x){}
  public static void main(String[] args) {
    String a1 = new String("hek");
    String b = new String("jk");
    String c = new String();
    c=a1+b;
    System.out.println(c);
    String[] v = {"dc"};

    Double ds = 10.0/-0;
    System.out.println(ds);
    Arrays.asList(v);


    int[] a = {1};
    inc(a);
    System.out.println(a[a.length-1]);

    String temp[] = {"a", "b"};
    for (int i = 0; i < temp.length; i++) {
      //System.out.println(temp[i]);
    }

    int c1 =-1;
    try {
      c1 = 4/0;
    }catch (Exception e){
      System.out.println("ex");
    }finally {
      System.out.println("finally");
    }

    System.out.println(c);

  }

  private static void inc(int[] a) {
    a[a.length-1]++;
  }
}
