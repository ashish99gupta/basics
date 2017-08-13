package FlipkartPuzzle;

public class CabManagementPortal {

  public static void main(String[] args) {
    City c1 = new City("C1");
    City.cityList.add(c1);
    City c2 = new City("C2");
    City.cityList.add(c1);
    City c3 = new City("C3");
    City.cityList.add(c1);
    City c4 = new City("C4");
    City.cityList.add(c1);
    addCabs(c1,c2,c3,c4);

    for (int i = 0; i < 4; i++) {
      Cab cab = Cab.requestCab(c1,c2,"idleTime");
      if (cab == null)
        continue;
      Cab.endTrip(cab,c2);
    }

    for (int i = 0; i < 3; i++) {
      Cab cab = Cab.requestCab(c2,c3,"idleTime");
      Cab.endTrip(cab,c2);
    }

    //cab.changeLocation(c3);
  }


  private static void addCabs(City c1, City c2, City c3, City c4) {
    Cab.cabList.add(new Cab("Cab1",c1));
    Cab.cabList.add(new Cab("Cab2",c1));
    Cab.cabList.add(new Cab("Cab3",c2));
    Cab.cabList.add(new Cab("Cab4",c2));
    Cab.cabList.add(new Cab("Cab5",c3));
    Cab.cabList.add(new Cab("Cab6",c3));
    Cab.cabList.add(new Cab("Cab7",c4));
    Cab.cabList.add(new Cab("Cab8",c4));
    Cab.cabList.add(new Cab("Cab9",c2));
    Cab.cabList.add(new Cab("Cab10",c1));

  }
}
