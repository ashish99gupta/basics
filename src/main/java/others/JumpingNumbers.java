package others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class JumpingNumbers {
  public static void main(String[] args) {
    int x = 50;
    printUsingBFS(x);
    //printUsingDFS(x);
  }

  private static void printUsingDFS(int x) {
    DFSNode node = new DFSNode(0);
    DFS(node, x);
  }

  private static void DFS(DFSNode node, int x) {
    if (!node.isVisted) {
      if (node.val <= x) {
        System.out.println(node.val);
        node.isVisted=true;
        int reminder = node.val % 10;
        populateList(node,reminder);
        for (int i = 0; i < node.nodeList.size(); i++) {
          DFS(node.nodeList.get(i),x);
        }
      }
    }
  }

  private static void populateList(DFSNode node, int reminder) {
    if (reminder == 0) {
      node.nodeList.add(new DFSNode(node.val * 10 + reminder + 1));
    } else if (reminder == 9) {
      node.nodeList.add(new DFSNode(node.val * 10 + reminder - 1));
    } else {
      node.nodeList.add(new DFSNode(node.val * 10 + reminder - 1));
      node.nodeList.add(new DFSNode(node.val * 10 + reminder + 1));
    }
    if (reminder == node.val && node.val != 9 && node.val != 0) {
      node.nodeList.add(new DFSNode(reminder + 1));
    }
  }

  private static void printUsingBFS(int x) {
    Queue<Integer> queue = new ArrayDeque<>();
    int n, reminder;
    queue.add(0);
    while (!queue.isEmpty()) {
      n = queue.poll();
      if (n <= x) {
        System.out.println(n);
        reminder = n % 10;
        if (reminder == 0) {
          queue.add(n * 10 + reminder + 1);
        } else if (reminder == 9) {
          queue.add(n * 10 + reminder - 1);
        } else {
          queue.add(n * 10 + reminder - 1);
          queue.add(n * 10 + reminder + 1);
        }
        if (reminder == n && n != 9 && n != 0) {
          queue.add(reminder + 1);
        }
      }
    }
  }
}

class DFSNode {
  int val;
  boolean isVisted;
  List<DFSNode> nodeList = new ArrayList<>();

  public DFSNode(int val) {
    this.val = val;
  }
}

