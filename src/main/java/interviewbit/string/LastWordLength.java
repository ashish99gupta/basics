package interviewbit.string;

public class LastWordLength {
  public static void main(String[] args) {
    LastWordLength lastWordLength = new LastWordLength();
    String p = lastWordLength.longestPalindrome("aaaabaaa");
    System.out.println(p);
  }
  public int lengthOfLastWord(final String a) {
    String[] list = a.split(" ");
    int n = list.length;
    if (n>0){
      String s  = list[n-1];
      return s.length();
    }
    return 0;

  }

  public String longestPalindrome(String a) {
    int[][] mat  = new int[a.length()][a.length()];
    char[] arr = a.toCharArray();
    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j +i<a.length() ; j++) {
        if (arr[j] == arr[i+j]){
          if (i==0||i==1){
            mat[j][i+j] = 1;
          }else if (mat[j+1][i+j-1] ==1){
            mat[j][i+j] = 1;
          }
        }

      }
    }

    int maxlen = 0;
    int start = 0;
    int end = 0;
    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < a.length(); j++) {
        if (mat[i][j]==1){
          int len = j-i+1;
          if (len>maxlen){
            start = i;
            end = j;
            maxlen = len;
          }
        }
      }
    }
    String s = "";
    if (end<a.length()){
      s = a.substring(start,end+1);
    }else {
      s = a.substring(start,end);
      s += a.toCharArray()[end];
    }
    return s;

  }
}
