package dp;

public class EggDroping {
  public static void main(String[] args) {
    int floor = 10;
    int egg = 2;
    int[][] mat = new int[egg][floor+1];
    EggDroping ed = new EggDroping();
    ed.prepareMatrix(mat);
  }

  private void prepareMatrix(int[][] mat) {
    int attempts;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 1; j < mat[0].length; j++) {
        if (i==0){
          mat[i][j] = mat[i][j-1] + 1;
        }else if (i+1>=j){
          mat[i][j] = mat[i-1][j];
        }
        else {
          //here if egg breaks on kth floor then we need to check floors below kth or if egg doesn't break on kth floor
          //then all the floors from j to k needs to be checked, thus we have to take worst case or all possibiltes among the two
          mat[i][j] = Integer.MAX_VALUE;
          for (int k = 1; k <= j; k++) {
            attempts = 1+ Math.max(mat[i-1][k-1],mat[i][j-k]);
            if (attempts < mat[i][j]){
              mat[i][j] = attempts;
            }
          }
        }
      }
    }
    MatrixUtil.display2dMatrix(mat);
  }
}
