package generics;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class GenericMap<k,v> implements Map<k,v> {

  private GenericMap() {
  }



  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean containsKey(Object key) {
    return false;
  }

  @Override
  public boolean containsValue(Object value) {
    return false;
  }

  @Override
  public v get(Object key) {
    return null;
  }

  @Override
  public v put(k key, v value) {
    return null;
  }

  @Override
  public v remove(Object key) {
    return null;
  }

  @Override
  public void putAll(Map<? extends k, ? extends v> m) {

  }

  @Override
  public void clear() {

  }

  @Override
  public Set<k> keySet() {
    return null;
  }

  @Override
  public Collection<v> values() {
    return null;
  }

  @Override
  public Set<Entry<k, v>> entrySet() {
    return null;
  }
}
