package interview.microsoft;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

  public static void main(String[] args) {
    int n = 3;
    List<String> list = new ArrayList<>();
    char[] arr = new char[2*n];
    allParenthesis(n, n, 0, n, list, arr);
    for (String s : list) {
      System.out.println(s);
    }

  }

  private static void allParenthesis(int open, int closing, int pos, int size, List<String> list, char[] arr) {
    if (closing == 0) {
      list.add(String.valueOf(arr));
      return;
    }
    if (open > 0) {
      arr[pos] = '(';
      allParenthesis(open - 1, closing, pos + 1, size, list, arr);
    }
    if (open<closing) {
      arr[pos] = ')';
      allParenthesis(open, closing - 1, pos + 1, size, list, arr);
    }
  }

}
