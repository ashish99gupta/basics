package graph;

import java.util.ArrayDeque;
import java.util.Queue;

import lombok.Getter;
import lombok.Setter;

public class KnightWalk {
  public static int[] rows = {-2, -1, 1, 2, -2, -1, 1, 2};
  public static int[] cols = {-1, -2, -2, -1, 1, 2, 2, 1};
/* static int[] rows = {2, 2, -2, -2, 1, -1, 1, -1};
 static int[] cols = {1, -1, 1, -1, -2, -2, 2, 2};*/
  public static int maxtillNow = Integer.MAX_VALUE;

  public static void main(String[] args) {
    ChessNode[][] board = createChessBoard(8, 8);
    BFS(board,7,7);
    //DFS(board, 0, 0, 0);
    System.out.println(maxtillNow);
  }

  private static void BFS(ChessNode[][] board, int row, int col){
    int steps = 0;
    Queue<ChessNode> queue = new ArrayDeque<>();
    queue.add(board[0][0]);
    while (!queue.isEmpty()){
      ChessNode node = queue.poll();
      node.isVisited = true;
      steps = node.getDistance();
      if (node.getRow() == row && node.getCol() ==  col){
        System.out.println(node.distance);
        break;
      }
      for (int i = 0; i < rows.length; i++) {
        if (isInside(node.getRow()+rows[i],node.getCol()+cols[i])
            && !board[node.getRow()+rows[i]][node.getCol()+cols[i]].isVisited){
          board[node.getRow()+rows[i]][node.getCol()+cols[i]].setDistance(steps+1);
          queue.add(board[node.getRow()+rows[i]][node.getCol()+cols[i]]);

        }
      }
    }
  }

  private static void DFS(ChessNode[][] board, int row, int col, int minHops) {
    if (row == 7 && col == 7) {
      maxtillNow = Math.min(minHops, maxtillNow);
      System.out.println(maxtillNow);
    }

    board[row][col].isVisited = true;
      for (int i = 0; i < rows.length; i++) {
        if (isInside(row + rows[i],col + cols[i]) && !board[row][col].isVisited) {
          DFS(board, row + rows[i], col + cols[i], minHops + 1);
        }
      }
  }

  private static boolean isInside(int row, int col) {
      return row < 8 && row > -1 && col < 8 && col > -1;
  }

  private static ChessNode[][] createChessBoard(int row, int col) {
    ChessNode[][] board = new ChessNode[row][col];

    for (int k = 0; k < row; k++) {
      for (int i = 0; i < col; i++) {
        board[k][i] = new ChessNode(0,k,i);
      }
    }
    return board;
  }
}

@Getter
@Setter
class ChessNode {
  boolean isVisited;
  int distance;
  int row;
  int col;

  public ChessNode(int distance, int row, int col) {
    this.distance = distance;
    this.row = row;
    this.col = col;
  }
}
