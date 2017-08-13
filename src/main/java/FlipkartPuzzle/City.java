package FlipkartPuzzle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class City {
  public static List<City> cityList = new ArrayList<>();
  private String name;
  private Set<Cab> registeredCabs = new HashSet<>();

  @Override
  public String toString() {
    return "name='" + name ;
  }

  public City(String name) {
    this.name = name;
  }

  public void addToCityMap(City city){
    cityList.add(city);
  }

  public boolean isCabRegistered(Cab cab) {
    return registeredCabs.contains(cab);
  }

  public void registerCab(Cab cab) {
    registeredCabs.add(cab);
  }
}
