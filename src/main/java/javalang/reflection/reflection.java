package javalang.reflection;

import graph.KnightWalk;

public class reflection {
  public static void main(String[] args) {
    KnightWalk knightWalk = new KnightWalk();
    knightWalk.getClass().getAnnotatedInterfaces();
  }
}
