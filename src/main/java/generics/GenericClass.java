package generics;

public class GenericClass<E> {
  private E instance;

  public E getInstance(){
  /*  if (instance == null){
      try {
        instance = (E) .getClass().newInstance();
      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }*/
    return instance;
  }
}
