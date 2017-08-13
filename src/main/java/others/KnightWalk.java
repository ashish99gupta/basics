package others;

public class KnightWalk {
  public static int[] rows = {-2, -1, 1, 2, -2, -1, 1, 2};
  public static int[] cols = {-1, -2, -2, -1, 1, 2, 2, 1};
  public static int maxtillNow = Integer.MAX_VALUE;

  public static void main(String[] args) {
    ChessNode[][] board = createChessBoard(8, 8);
    DFS(board, 0, 0, 0);
    System.out.println(maxtillNow);
  }

  private static void DFS(ChessNode[][] board, int row, int col, int minHops) {
    if (row == 7 && col == 7) {
      maxtillNow = Math.min(minHops, maxtillNow);
      System.out.println(maxtillNow);
    }

    board[row][col].isVisited = true;
      for (int i = 0; i < rows.length; i++) {
        if (isSafe(board, row + rows[i], col + cols[i])) {
          DFS(board, row + rows[i], col + cols[i], minHops + 1);
        }
      }
  }

  private static boolean isSafe(ChessNode[][] board, int row, int col) {
    if (row < 8 && row > -1 && col < 8 && col > -1 && !board[row][col].isVisited) {
      return true;
    }
    return false;
  }

  private static ChessNode[][] createChessBoard(int row, int col) {
    ChessNode[][] board = new ChessNode[row][col];

    for (int k = 0; k < row; k++) {
      for (int i = 0; i < col; i++) {
        board[k][i] = new ChessNode();
      }
    }
    return board;
  }
}

class ChessNode {
  boolean isVisited;
  int val;
}
