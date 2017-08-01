package matrix;

public class RatMazeProblem {
    public static void main(String[] args) {
        int[][] matrix = MatrixCreation.create();
        char[] arr = new char[matrix.length*matrix.length];
        boolean res = mazeSol(matrix, 0, 0, matrix.length,arr,0);
        System.out.println(arr);
    }

    private static boolean mazeSol(int[][] matrix, int i, int j, int length, char[] s, int slength) {
        if (i == length-1 && j == length-1){
            return true;
        }
        if (isValid(matrix,i ,j, length)){
            if (mazeSol(matrix,i+1, j, length,s, slength+1)){
                s[slength] = 'D';
                return true;
            }
            if (mazeSol(matrix, i, j+1, length, s, slength+1)){
                s[slength] = 'R';
                return true;
            }

            return false;
        }
        return false;
    }

    static boolean isValid(int[][] mat, int i, int j,int n){
        return (i>=0 && i<n && j>=0 && j<n && mat[i][j] == 1);
    }

}
