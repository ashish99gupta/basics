package interviewbit;

import java.util.ArrayList;

public class LongestPrefix {
  public String longestCommonPrefix(ArrayList<String> a) {
    String prefix = a.get(0);
    if (prefix==null)
      return null;
    for (int i = 1; i < a.size(); i++) {
      if (a.get(i).startsWith(prefix))
        continue;
      int len = (a.get(i).length() > prefix.length()) ? prefix.length() : a.get(i).length();
      prefix = getPrefix(prefix,len,a.get(i));
    }
    return prefix;
  }

  private String getPrefix(String prefix, int len, String s) {
    StringBuilder sb  = new StringBuilder();
    char[] preChar = prefix.toCharArray();
    char[] schar = s.toCharArray();
    for (int i = 0; i < len; i++) {
      if (preChar[i] == schar[i]){
        sb.append(preChar[i]);
      }else
        break;
    }
    return sb.toString();
  }
}
