package dp;

public class MatrixUtil<T> {
  public void display(T[][] matrix) {
    for(int j=0;j<matrix.length;j++){
      for(int i=0;i<matrix[0].length;i++){
        if(matrix[j][i]==null){
          System.out.print("___ |");
        }
        else{
          System.out.print(matrix[j][i]+","+matrix[j][i]+" | ");
        }
      }
      System.out.println();
    }
  }

  public static void display2dMatrix(int[][] matrix){
    for(int j=0;j<matrix.length;j++){
      for(int i=0;i<matrix[0].length;i++){
        System.out.print(matrix[j][i]+" | ");
      }
      System.out.println();
    }
  }

  public static void display2dMatrix(boolean[][] matrix){
    for(int j=0;j<matrix.length;j++){
      for(int i=0;i<matrix[0].length;i++){
        if(matrix[j][i]){
          System.out.print("T | ");
        }
        else{
          System.out.print("F | ");
        }
      }
      System.out.println();
    }
  }

  public static void display(ProfitNode[][] matrix) {
    for(int j=0;j<matrix.length;j++){
      for(int i=0;i<matrix[0].length;i++){
        if(matrix[j][i]==null){
          System.out.print("___ |");
        }
        else{
          System.out.print(matrix[j][i].first+","+matrix[j][i].second+" | ");
        }
      }
      System.out.println();
    }
  }
}
