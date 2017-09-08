package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {
  /**
   * You have been given a word i.e. iammat and a dictionary : "i","a","am","at","mat" you need to tell, word can be
   * broke into small words present in dictionary
   *
   * To move diagonally use i+j in innerloop to iterate
   *
   * i to i+j gives you word from 1->2->3 of word length in each iteration
   *
   * # first we'll check if i to i+j word is in dictionary or not # if not then check if i to k and k to i+j both word
   * exist or not
   *
   *
   *     i   a   m   m   a   t
   *  i  T | T | T | F | F | T
   *  a  _ | T | T | F | F | T
   *  m  _ | _ | F | F | F | F
   *  m  _ | _ | _ | F | F | T
   *  a  _ | _ | _ | _ | T | T
   *  t  _ | _ | _ | _ | _ | F
   *
   * 1-> i,a,m,m,a,t
   * 2-> ia,am,mm,ma,at
   * 3-> iam,amm,mma,mat
   * 4-> iamm,amma,mmat
   * 5-> iammma,ammat
   * 6-> iammat
   */

  public static void main(String[] args) {
    Set<String> dic = new HashSet<>();
    WordBreakProblem wbp = new WordBreakProblem();
    wbp.populateDictionary(dic);
    String word = "iammat";
    wbp.prepareMatrix(word, dic);

  }

  private void prepareMatrix(String word, Set<String> dic) {
    boolean[][] mat = new boolean[word.length()][word.length()];

    for (int i = 0; i < word.length(); i++) {
      for (int j = 0; j + i < word.length(); j++) {
        char[] w = Arrays.copyOfRange(word.toCharArray(), j, i + j + 1);
        if (dic.contains(String.valueOf(w))) {
          mat[j][i + j] = true;
        } else {
          if (i > 0) {
            for (int k = 0; k < i; k++) {
              if (mat[j][j + k] && mat[j + k + 1][j + i]) {
                mat[j][i + j] = true;
                break;
              }
            }
          }
        }
      }
    }

    MatrixUtil.display2dMatrix(mat);
    System.out.println();
  }

  private void populateDictionary(Set<String> dic) {
    String[] arr = {"i", "a", "am", "at", "mat"};
    dic.addAll(Arrays.asList(arr));
  }
}
