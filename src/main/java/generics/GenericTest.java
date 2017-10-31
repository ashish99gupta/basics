package generics;

public class GenericTest {
  public static void main(String[] args) {
    GenericClass<String> genericClass = new GenericClass<>();
    String a = genericClass.getInstance();
    System.out.println(a);
  }

}
