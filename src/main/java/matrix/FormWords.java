package matrix;

import java.util.HashMap;
import java.util.Map;

public class FormWords {
  public static int[] arr = {-1, 0, 1};

  public static void main(String[] args) {
    //String[][] mat = new String[3][3];
    String[][] mat = {{"d", "e", "f"}, {"o", "s", "a"}, {"t", "n", "a"}};
    Map<String, Boolean> dictionary = new HashMap<>();
    dictionary.put("doe", false);
    dictionary.put("fast", false);
    dictionary.put("ant", false);
    String word;
    boolean[][] visited = new boolean[3][3];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (isSafe(i, j, visited)) {
          word = "";
          dfs(i, j, mat, visited, dictionary, word);
        }
      }

    }
  }

  private static boolean dfs(int i, int j, String[][] mat, boolean[][] visited, Map<String, Boolean> dictionary, String word) {
    if (dictionary.get(word) != null && dictionary.get(word) == false) {
      System.out.println(word);
      dictionary.put(word, true);
      return true;
    }
    //marking visited as soon as the node come so as to avoid repetitive access to the same node.
    for (int k = 0; k < arr.length; k++) {
      for (int l = 0; l < arr.length; l++) {
        if (isSafe(i + arr[k], j + arr[l], visited)){
          visited[i + arr[k]][j + arr[l]] = true;
          if (dfs(i + arr[k], j + arr[l], mat, visited, dictionary, word + mat[i + arr[k]][j + arr[l]])) {
            return true;
          }
          visited[i + arr[k]][j + arr[l]] = false;
        }
      }
    }
    return false;
  }

  private static boolean isSafe(int i, int j, boolean[][] visited) {
    return i >= 0 && j >= 0 && i < visited.length && j < visited[0].length && visited[i][j] == false;
  }

}
