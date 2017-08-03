package matrix;

public class IslandsNo {
  static int row = 4;
  static int col = 5;
  static int[] traverse = {-1, 0, 1};

  public static void main(String[] args) {
    MatrixNode[][] matrix = createMatix();
    int islands = countIslands(matrix);
    System.out.println(islands);
  }

  private static int countIslands(MatrixNode[][] matrix) {
    int islands = 0;
    int count =0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j].val == 1 && !matrix[i][j].isVisted) {
          islands++;
          count = DFS(matrix[i][j], matrix, i, j);
          System.out.println(count);
        } else {
          matrix[i][j].isVisted = true;
        }

      }
    }
    return islands;
  }

  private static int DFS(MatrixNode matrixNode, MatrixNode[][] matrix, int row, int col) {
    matrixNode.isVisted = true;
    int count = 0;
    for (int i = 0; i < traverse.length; i++) {
      for (int j = 0; j < traverse.length; j++) {
        if (isSafe(matrix, traverse, i, j, row, col)) {
          count = count + DFS(matrix[row + traverse[i]][col + traverse[j]],
              matrix,row + traverse[i],col + traverse[j]);
        }
      }

    }
    return 1+count;
  }

  private static boolean isSafe(MatrixNode[][] matrix, int[] traverse, int i, int j, int row, int col) {
    return row + traverse[i] >= 0 && row + traverse[i] < matrix.length
        && col + traverse[j] >= 0 && col + traverse[j] < matrix[0].length
        && matrix[row + traverse[i]][col + traverse[j]].val == 1
        && !matrix[row + traverse[i]][col + traverse[j]].isVisted;
  }

  /*
                { 0 0 1 1 0
                  1 0 1 1 0
                  0 1 0 0 0
                  0 0 0 0 1 }
   */
  private static MatrixNode[][] createMatix() {
    MatrixNode[][] matrix = new MatrixNode[row][col];
    matrix[0][0] = new MatrixNode(0);
    matrix[0][1] = new MatrixNode(0);
    matrix[0][2] = new MatrixNode(1);
    matrix[0][3] = new MatrixNode(1);
    matrix[0][4] = new MatrixNode(0);
    matrix[1][0] = new MatrixNode(1);
    matrix[1][1] = new MatrixNode(0);
    matrix[1][2] = new MatrixNode(1);
    matrix[1][3] = new MatrixNode(1);
    matrix[1][4] = new MatrixNode(0);
    matrix[2][0] = new MatrixNode(0);
    matrix[2][1] = new MatrixNode(1);
    matrix[2][2] = new MatrixNode(0);
    matrix[2][3] = new MatrixNode(0);
    matrix[2][4] = new MatrixNode(0);
    matrix[3][0] = new MatrixNode(0);
    matrix[3][1] = new MatrixNode(0);
    matrix[3][2] = new MatrixNode(0);
    matrix[3][3] = new MatrixNode(0);
    matrix[3][4] = new MatrixNode(1);
    return matrix;
  }
}

class MatrixNode {
  int val;
  boolean isVisted;

  MatrixNode(int val) {
    this.val = val;
  }
}
