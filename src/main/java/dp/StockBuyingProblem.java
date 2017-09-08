package dp;

public class StockBuyingProblem {
  public static void main(String[] args) {
    int[] prices = {2, 5, 7, 1, 4, 3, 1, 3};
    int k = 3;
    int[][] mat = new int[k + 1][prices.length];
    StockBuyingProblem sb = new StockBuyingProblem();
    sb.solution(mat, prices);
  }

  private void solution(int[][] mat, int[] prices) {
    int max;
    for (int i = 1; i < mat.length; i++) {
      for (int j = 1; j < mat[0].length; j++) {
        mat[i][j] = mat[i][j - 1];
        for (int k = 0; k < j; k++) {
          max = prices[j] - prices[k] + mat[i - 1][k];
          if (mat[i][j] < max) {
            mat[i][j] = max;
          }
        }
      }
    }
    MatrixUtil.display2dMatrix(mat);
    System.out.println();
  }
}
