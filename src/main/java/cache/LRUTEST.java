package cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUTEST {
  /*LinkedList<Integer> cache = new LinkedList<>();
  int size = 5;
  HashMap<Integer,Node<Integer>>  map = new HashMap<>();

  public static void main(String[] args) {


  }

  Get ( Key k){
    Node<Integer> node = map.get(k);
    Integer value = null;
    if (node != null){
       value = cache.poll(node);
      map.put(k, node);
    }
    return value;

  }


  Put ( Key K, Integer v){
    if(cache.size()<n){
      if(map.get(k) == null){
        cache.add(v);
        map.put(K,cache.peek());

      }else {
        Node<Integer> node  = map.get(K);
        cache.poll(node);
        cache.add(node);

      }
    }else{
      if(map.get(k) == null){
        Node<Integer> node = cache.poll();
        cache.add(v);
        map.remove(node.getKey());
        map.put(K,cache.peek());

      }else {
        Node<Integer> node  = map.get(K);
        cache.poll(node);
        cache.add(node);
      }
    }

  }*/

}
