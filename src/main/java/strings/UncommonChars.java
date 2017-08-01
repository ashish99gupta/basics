package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UncommonChars {
  static UncommonChars uncommonChars = new UncommonChars();

  public static void main(String[] args) {
    //String s1 = "characters";
    //String s2 = "alphabets";
    Scanner sc = new Scanner(System.in);
    long T = sc.nextLong();
    if(T<0 || T>100000){
      return;
    }
    while(T>0){
      String s1 = sc.next();
      String s2 = sc.next();
      int[] arr = new int[26];

      for (char c : s1.toCharArray()) {
        arr[c-97] = 1;
      }

      for (char c : s2.toCharArray()) {
        if (arr[c-97] == 0){
          arr[c-97] = 2;
        }else if (arr[c-97]==1){
          arr[c-97] = -1;
        }
      }

      for (int i = 0; i < 26; i++) {
        if (arr[i] ==1 || arr[i] ==2){
          char c = (char) (i+97);
          System.out.println(c);
        }
      }
      T--;
    }

  }

}
