package strings;

public class Permutations {
  public static void main(String[] args) {
    char[] str = "ABC".toCharArray();
    Permutations p = new Permutations();
    //p.permute(str,0,str.length);
    char[] buffer = new char[2 * str.length];
    buffer[0] =str[0];
    p.permuteWithSpaces(str, buffer, 1, 1, str.length);
  }

  public void permute(char[] str, int left, int right) {
    if (left == right) {
      System.out.println(str);
      return;
    }
    for (int i = left; i < right; i++) {
      swap(str, left, i);
      permute(str, left + 1, right);
      swap(str, left, i);
    }
  }

  public void permuteWithSpaces(char[] str, char[] buffer, int i, int j, int len) {
    if (i == len) {
      buffer[j] = '\0';
      System.out.println(buffer);
      return;
    }
    buffer[j] = str[i];
    permuteWithSpaces(str, buffer, i + 1, j + 1, len);
    buffer[j] = ' ';
    buffer[j + 1] = str[i];
    permuteWithSpaces(str, buffer, i + 1, j + 2, len);
  }

  private void swap(char[] str, int left, int i) {
    char temp = str[left];
    str[left] = str[i];
    str[i] = temp;
  }
}
