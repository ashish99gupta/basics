package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uber1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n >= 2 && n <= 1000000) {
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int q = sc.nextInt();
      if (q > 0 && q <= 50) {
        int a, b;
        int[] result = new int[q];
        List<Range> rangeList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
          a = sc.nextInt();
          b = sc.nextInt();
          Range range = new Range(a, b);
          rangeList.add(range);
        }

        int[] leftMax = leftMax(arr);
        int[] rightMin = rightMin(arr);
        boolean display = true;
        for (int j = 0; j < rangeList.size(); j++) {
          a = rangeList.get(j).x;
          b = rangeList.get(j).y;
          if (a >= 0 && a < n && b >= 0 && b < n && a <= b) {
            int max = Integer.MIN_VALUE;
            int diff;
            for (int i = a; i < b; i++) {
              if (i + 1 < arr.length) {
                diff = leftMax[i] - rightMin[i + 1];
                if (diff > max) {
                  max = diff;
                }
              } else {
                continue;
              }
            }
            result[j] = max;
          } else {
            display = false;
          }

        }

        if (display == true) {
          for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
          }
        }
      }
    }
  }

  private static int[] leftMax(int[] arr) {
    int[] leftMax = new int[arr.length];
    leftMax[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] >= leftMax[i - 1]) {
        leftMax[i] = arr[i];
      } else {
        leftMax[i] = leftMax[i - 1];
      }
    }
    return leftMax;
  }

  private static int[] rightMin(int[] arr) {
    int[] rightMin = new int[arr.length];
    rightMin[arr.length - 1] = arr[arr.length - 1];

    for (int i = arr.length - 2; i >= 0; i--) {
      if (arr[i] <= rightMin[i + 1]) {
        rightMin[i] = arr[i];
      } else {
        rightMin[i] = rightMin[i + 1];
      }
    }
    return rightMin;
  }
}

class Range {
  int x;
  int y;

  public Range(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
