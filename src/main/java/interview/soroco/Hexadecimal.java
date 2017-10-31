package interview.soroco;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Hexadecimal {

  public static void main(String[] args) {
    //String s = phoneNumber();
    int s = reverserPolish();
    System.out.println(s);
  }

  private static String toHexa() {
    int n = 0;
    int temp;
    char c;
    String s = "0x";
    Stack<String> stack = new Stack<>();
    while (n != 0) {
      temp = n % 16;
      if (temp < 10) {
        c = (char) (temp + 48);
      } else {
        c = (char) (temp + 55);
      }
      stack.push(String.valueOf(c).toLowerCase());

      n = n / 16;
    }
    int size = stack.size();
    for (int i = 0; i < size; i++) {
      s = s+ stack.pop();
    }
    return s;
  }


  private static String phoneNumber() {
    String s = "(000) 000-0000011";
    List<String> list = Arrays.asList(s.split("-"));
    if (s.length()<10 || list.size() == 0){
      return "NONE";
    }
    int openingIndex,closingIndex,hipenindex,secondHipenIndex;
    String number;
    String substring1,substring2,substring3,substring4;
    for (int i = 0; i < list.size() && list.size()>=i+1; i++) {
      String str = list.get(i);
      openingIndex = str.lastIndexOf("(");
      if (openingIndex!=-1 && str.length()>= openingIndex+4
          && String.valueOf(str.toCharArray()[openingIndex+4]).equalsIgnoreCase(")")){
        closingIndex = openingIndex+4;
        substring1 = str.substring(openingIndex+1,closingIndex);
        if (str.length() == closingIndex+4 || (str.length() == closingIndex+5
            &&String.valueOf(str.toCharArray()[closingIndex+1]).equalsIgnoreCase(" "))){
          if (str.length() == closingIndex+4){
            substring2 = str.substring(closingIndex+1,closingIndex+4);
          }else {
            substring2 = str.substring(closingIndex+2,closingIndex+5);
          }

          if (checkForNumbers(substring1) && checkForNumbers(substring2)){
            String str2 = list.get(i+1);
            if (str2 != null && str2.length()>=4){
              substring3 = str2.substring(0,4);
              if (checkForNumbers(substring3)){
                if (str.length() == closingIndex+5){
                  substring2 = str.substring(closingIndex+1,closingIndex+5);
                }
                number = "(" + substring1+")"+substring2+"-"+substring3;
                return number;
              }
            }
          }
        }

      }else if (list.size()>=i+2){
        String str2 = list.get(i+1);
        String str3 = list.get(i+2);
        if (str2 != null && str3 != null && str2.length() == 3 && str3.length() >=4){
          substring1 = str.substring(str.length()-3);
          substring3 = str3.substring(0,4);
          if (checkForNumbers(substring1) && checkForNumbers(str2) && checkForNumbers(substring3)){
            number = substring1+"-"+str2+"-"+substring3;
            return number;
          }

        }
      }
    }

    return "NONE";
  }

  private static boolean checkForNumbers(String substring1) {
    for (char c : substring1.toCharArray()) {
      if (c<48 || c>57)
        return false;
    }
    return true;
  }


  private static int reverserPolish() {
    String expression = "5 1 2 + 4 * + 13 -";
    Stack<Integer> stack = new Stack<>();
    char[] arr = expression.toCharArray();
    int temp;
    String s=new String();
    for (int i = 0; i < arr.length ; i=i+1) {
      char c1 = arr[i];
      if (c1 == ' ')
        continue;
      StringBuilder sb = new StringBuilder().append(c1);
      while (arr.length>i+1 && checkForNumbers(arr[i+1])){
       char c2 = arr[i+1];
        s = sb.append(c2).toString();
        i++;
      }
      if (s.length()>1){
        stack.push(Integer.valueOf(s));
        s = "";
        continue;
      }
      if (checkForNumbers(c1)){
         s = new StringBuilder().append(c1).toString();
        stack.push(Integer.valueOf(s));
        s = "";
      }else {
        int x = stack.pop();
        int y = stack.pop();
        if (c1 == '+'){
          temp = x+y;
          stack.push(temp);
        }else if (c1 == '-'){
          temp = y-x;
          stack.push(temp);
        }else if (c1 == '*'){
          temp = x*y;
          stack.push(temp);
        }else if (c1 == '/'){
          temp = y/x;
          stack.push(temp);
        }
      }

    }
    return stack.pop();
  }

  private static boolean checkForNumbers(char c) {
    if (c<48 || c>57)
      return false;
    return true;
  }

}
