package interview.HotStar;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NthPalindrome {
  private Map<Long,Integer> palinMap = new HashMap<>();
  public static void main(String[] args) {

  }

  private void formGroup(int length){

  }

  private static Long getBinaryNumber(int n){
    Stack<Integer> stack = new Stack<>();
    int x;
    while (n!=0){
      x = n%2;
      stack.push(x);
      n=n/2;
    }
    String s="";
    while (!stack.isEmpty()){
      s=s+String.valueOf(stack.pop());
    }
    return Long.valueOf(s);
  }
}
