package tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedTransferQueue;

public class BinaryTreeQuestion {

  public static void zigZag(TreeNode node) {
    Queue<TreeNode> queue = new LinkedTransferQueue<>();
    queue.add(node);
    Stack<TreeNode> secondStack = new Stack<>();
    Stack<TreeNode> currentStack = new Stack<>();
    boolean leftToRight = true;
    currentStack.push(node);
    while (!currentStack.empty()){
      node = currentStack.pop();
      System.out.println(node.data);
      if (leftToRight){
        if (node.left!= null){
          secondStack.push(node.left);
        }
        if (node.right!= null){
          secondStack.push(node.right);
        }

      }else {
        if (node.left!= null){
          secondStack.push(node.left);
        }
        if (node.right!= null){
          secondStack.push(node.right);
        }
      }
      if (currentStack.empty()){
        leftToRight = leftToRight ? false : true;
        Stack<TreeNode> temp = currentStack;
        currentStack = secondStack;
        secondStack = temp;
      }
    }
  }
}
