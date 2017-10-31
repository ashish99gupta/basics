package interviewbit.string;

public class CountAndSay {
  public static void main(String[] args) {
    CountAndSay cs = new CountAndSay();
    String s = cs.countAndSay1(39);
    System.out.println(s);
  }
  public String countAndSay1(int a) {
    if (a==1)
      return "1";
    if (a==2)
      return "11";
    String str = "21";
    int count = 1;
    for (int i = 3; i < a; i++) {
      str = str + "&";
      String temp = "";
      for (int j = 1; j < str.length(); j++) {
        if (str.toCharArray()[j] != str.toCharArray()[j-1]){
          char c  =(char)( count + '0');

          temp += Character.valueOf((char)( count + '0'));
          temp += str.toCharArray()[j-1];
          count = 1;
        }else {
          count++;
        }

      }
      str = temp;
    }
    return str;

  }
}
