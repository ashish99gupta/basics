package interview.TowerResearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MaxProfit {
  private static Map<Long, Long> map = new HashMap<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Long t = sc.nextLong();
    List<Long> list = new ArrayList<>();

    if (t <= Long.valueOf("10000000000")) {
      while (t > 0) {
        long n = sc.nextLong();
        list.add(n);
        t--;
      }

    }
    for (Long l : list) {
      long rs = func(l);
      System.out.println(rs);
    }
    String s1 = "{connid=1}";
    String[] arr = s1.split("=");
    int len = arr[1].length();
    String id = arr[1].substring(0,len);
    String s = "{\"stat:ok\"}";
  }

  private static long func(long n) {
    if (n == 0)
      return 0;
    if (map.get(n) != null)
      return map.get(n);

    else {
      long c;
      long temp = n / 2 + n / 3 + n / 4 + func(n / 2) + func(n / 3) + func(n / 4);
      long profit = temp - n;
      if (profit > 0) {
        c = profit;
      } else {
        c = 0;
      }
      map.put(n, c);
      return c;
    }
  }

}
