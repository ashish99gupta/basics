package strings;

public class KMP {

  public static void main(String[] args) {
    KMP kmp = new KMP();
    String s = "AABAACAADAABAABA";
    String p = "AABA";
    char[] txt = s.toCharArray();
    char[] pat = p.toCharArray();
    int[] lps = kmp.longestPrefixSuffix(s.toCharArray());
    for (int i = 0,j=0; i < txt.length;) {
      if (txt[i] == pat[j]){
        i++;
        j++;
      }else {    //because i cann count those chars which are in suffix of already matched in the prefix of next window
        if (j!=0){
          j= lps[j-1];
        }else {
          i++;
        }
      }

      if (j==pat.length){
        System.out.println(i-j+1);
        j= lps[j-1];
      }

    }
  }

  public int[] longestPrefixSuffix(char[] charArray){
    int[] lps = new int[charArray.length];
    lps[0] = 0;
    int len = 1;
    for (int i = 0; len < charArray.length;) {
      if (charArray[i] == charArray[len]){
        i++;
        lps[len] = i;
        len++;
      }else {
        lps[len] = lps[len-1];
        len++;
      }
    }
    return lps;
   }
}
