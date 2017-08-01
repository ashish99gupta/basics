package dp;


/**
 *    B   A   N   A   N   A
 * B  1 | 0 | 0 | 0 | 0 | 0 |
 * A  0 | 1 | 0 | 1 | 0 | 1 |
 * N  0 | 0 | 1 | 0 | 1 | 0 |
 * A  0 | 0 | 0 | 1 | 0 | 1 |
 * N  0 | 0 | 0 | 0 | 1 | 0 |
 * A  0 | 0 | 0 | 0 | 0 | 1 |
 */
/**
 * take a min cut array of word length
 *
 * fill all matrix by Integer.Max
 *
 *  if matrix[0][wordpos]=1 means that word is palindrome already-> no cuts required
 *    cut[i] = 0
 *  else
 *    start from cut[i+1] pos to wordpos where i=0
 *      Ex- B  A  N  A <- wordPos      | B [A  N  A] -> 1 cut required
 *          i i+1
 *        check in matrix[i+1][wordPos] -> ANA which will be palindrome and 1 value in matrix
 *      So, cuts[i] -> cuts[i]+1 -> 0 + 1
 *
 * Min Cuts Array:[0, 1, 2, 1, 2, 1]
 */
public class PalindromePartioning {
  public static void main(String[] args) {
    char[] word = "ababbbabbababa".toCharArray();
    int[][] palin = new int[word.length][word.length];
    boolean[][] p = new boolean[word.length][word.length];
    //parray(palin,word);

    fillPalindrome(palin, word);
    displayMatrix(palin);
    cuts(palin,word);
  }

  private static void parray(int[][] P, char[] str) {
    int n = str.length;
    int i,j,L;
    for (i=0; i<n; i++)
    {
      P[i][i] = 1;
    }

    /* L is substring length. Build the solution in bottom up manner by
       considering all substrings of length starting from 2 to n. */
    for (L=2; L<=n; L++)
    {
      // For substring of length L, set different possible starting indexes
      for (i=0; i<n-L+1; i++)
      {
        j = i+L-1; // Set ending index

        // If L is 2, then we just need to compare two characters. Else
        // need to check two corner characters and value of P[i+1][j-1]
        if (L == 2){
          if (str[i] == str[j])
            P[i][j] =1;
        }
        else{
          if (str[i] == str[j] && P[i+1][j-1] ==1)
            P[i][j] =1;

        }
      }
    }
    displayMatrix(P);
  }

  private static void displayMatrixboolean(boolean[][] palin) {
    for (int i = 0; i < palin.length; i++) {
      for (int j = 0; j < palin[0].length; j++) {
        System.out.print(palin[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void cuts(int[][] palin, char[] word) {
    int[] cuts= new int[word.length];
    for (int i = 0; i < word.length; i++) {
      cuts[i] = Integer.MAX_VALUE;
      if (palin[0][i] == 1)
        cuts[i] = 0;
      else {
        for (int j = 0; j < i; j++)
          if (palin[j+1][i] == 1 && cuts[j]+1<cuts[i]){
            cuts[i] = cuts[j]+1;
          }

      }
    }

    System.out.println(cuts[word.length-1]);
  }

  private static void displayMatrix(int[][] palin) {
    for (int i = 0; i < palin.length; i++) {
      for (int j = 0; j < palin[0].length; j++) {
        System.out.print(palin[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void fillPalindrome(int[][] palin, char[] word) {
    for (int i = 0; i < word.length; i++) {
      for (int j = 0; i + j < word.length; j++) {
        if (word[j]==word[i+j]){
          if (i == 0 || i == 1) {
            palin[j][i + j] = 1;
          }else {
            if (palin[j+1][i+j-1] == 1)
              palin[j][i + j] = 1;
          }
        }
      }
    }
  }
}
