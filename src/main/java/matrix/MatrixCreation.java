package matrix;

import java.util.Scanner;

public class MatrixCreation {

    public static int[][] create2DMatrix(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++){
            System.out.print("enter the "+ m + " number for "+ i +"th row.");
            for (int j = 0; j < m;j++){
                mat[i][j] = sc.nextInt();
            }
            System.out.println();
        }

        return mat;
    }

    public static void printMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static int[][] create(){
        int[][] mat = {{1,0,1},{1,1,0},{0,1,1}};
        return mat;
    }

}
