package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KStreamMedian {
  public static void main(String[] args) {
    int[] arr = {9, 5, 15, 25, 67, 32, 23, 1};
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < arr.length; i++) {
      System.out.println(getMedian(arr[i], minHeap, maxHeap));
    }
  }

  private static double getMedian(int val, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
    addVal(val, minHeap, maxHeap);
    rebalanceHeaps(minHeap, maxHeap);
    return retrieveMedian(minHeap,maxHeap);
  }

  private static double retrieveMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
    if (minHeap.size() == maxHeap.size()){
      return (minHeap.peek() + maxHeap.peek())/2;
    }else if (minHeap.size()>maxHeap.size()){
      return minHeap.peek();
    }else return maxHeap.peek();
  }

  private static void rebalanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
    if (maxHeap.size() > (minHeap.size() + 1)) {
      minHeap.add(maxHeap.poll());
    } else if (minHeap.size() > (maxHeap.size() + 1)) {
      maxHeap.add(minHeap.poll());
    }
  }

  private static void addVal(int val, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
    if (maxHeap.peek() == null || maxHeap.peek() >= val) {
      maxHeap.add(val);
    } else {
      minHeap.add(val);
    }
  }
}
