package strings;

public class KMP {

  public static void main(String[] args) {
    KMP kmp = new KMP();
    String s = "AABAACAADAABAABA";
    String p = "AABA";
    char[] txt = s.toCharArray();
    char[] pat = p.toCharArray();
    int[] lps = kmp.longestPrefixSuffix(p.toCharArray());
    for (int i = 0,j=0; i < txt.length;) {
      if (txt[i] == pat[j]){
        i++;
        j++;
      }else {    //because i can count those chars which are in suffix of already matched in the prefix of next window
        if (j!=0){
          j= lps[j-1];  // lps[j] = k that means first k letters are same as last k letters we compared,
                       // now go past k chars to search and not from the starting
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

  // lps[i] = the longest proper prefix of pat[0..i]
  //             which is also a suffix of pat[0..i].
  /*
  AABAACAABAAC = {0,1,0,1,2,0,1,2,3,4,5,6}
   */
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
        if (i!=0){
          i = lps[i-1];
        }else {
          lps[len] = i;
          len++;

        }
      }
    }

    for (int x : lps)
      System.out.printf(x +" ");
    System.out.println();
    return lps;
   }
}
