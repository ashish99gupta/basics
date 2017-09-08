package dp;

public class GameStrategy {


  public static void main(String[] args) {
    Integer[] arr = {6,7,1,4};
    ProfitNode[][] mat = new ProfitNode[arr.length][arr.length];
    GameStrategy gm = new GameStrategy();
    gm.prepareStrategy(mat,arr);
  }

  private void prepareStrategy(ProfitNode[][] mat, Integer[] arr) {
    for (int i = 0; i < arr.length; i++) {
      mat[i][i] = new ProfitNode(arr[i],0);
    }

    int left=0,down=0,first,second;
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; i+j < arr.length; j++) {
        left = arr[i+j] + mat[j][i+j-1].second;
        down = arr[j] + mat[j+1][i+j].second;
        if (left>down){
          first = left;
          second = mat[j][i+j-1].first;
        }else {
          first = down;
          second = mat[j+1][i+j].first;
        }
        mat[j][i+j] = new ProfitNode(first,second);
      }
    }

    MatrixUtil.display(mat);
    System.out.println(mat[0][arr.length-1].first);
  }

}
class ProfitNode{
  int first;
  int second;

  public ProfitNode(int first, int second) {
    this.first = first;
    this.second = second;
  }
}
