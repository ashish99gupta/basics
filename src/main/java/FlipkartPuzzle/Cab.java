package FlipkartPuzzle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import lombok.Getter;
import lombok.Setter;

enum Status {
  IDLE("idle"),
  ON_TRIP("on_trip");

  String value;

  Status(String status) {
    this.value = status;
  }
}

@Getter
@Setter
public class Cab {
  public static List<Cab> cabList = new ArrayList<>();
  public static PriorityQueue<Cab> minQueue = new PriorityQueue<>(new Comparator<Cab>() {
    @Override
    public int compare(Cab o1, Cab o2) {
      return o1.nooftrips < o2.nooftrips ? -1 : (o1.nooftrips == o2.nooftrips ? 0 : 1);
    }
  });

  public static PriorityQueue<Cab> maxQueue = new PriorityQueue<>(new Comparator<Cab>() {
    @Override
    public int compare(Cab o1, Cab o2) {
      return o1.idleTime.isBefore(o2.idleTime) ? -1 : (o1.idleTime.isEqual(o2.idleTime) ? 0 : 1);
    }
  });

  private String name;
  private City sourceCity;
  private City destinationCity;
  private LocalDateTime idleTime = LocalDateTime.now();
  private LocalDateTime startTripTime;
  private LocalDateTime endTripTime;
  private Status status;
  private City cabLocation;
  private int nooftrips = 0;

  public Cab(String name, City city) {
    this.name = name;
    this.status = Status.IDLE;
    this.cabLocation = city;
  }

  public static Cab requestCab(City c1, City c2, String sortScheme) {
    List<Cab> cabLocationList = getCabLocationList(c1);
    if (cabLocationList.size() < 1) {
      System.out.println("no cab is free");
      return null;
    }

    Cab cab;
    if (sortScheme.equalsIgnoreCase("idleTime")) {
     /* cabLocationList.sort(new Comparator<Cab>() {
        @Override
        public int compare(Cab o1, Cab o2) {
          return o1.idleTime.isBefore(o2.idleTime) ? -1 : (o1.idleTime.isEqual(o2.idleTime) ? 0 : 1);
        }
      });*/
     cab = maxQueue.peek();
    } else {
      /*cabLocationList.sort(new Comparator<Cab>() {
        @Override
        public int compare(Cab o1, Cab o2) {
          return o1.nooftrips < o2.nooftrips ? -1 : (o1.nooftrips == o2.nooftrips ? 0 : 1);
        }
      });*/
      cab = minQueue.peek();
    }

    //Cab cab = cabLocationList.get(0);
    cab.setIdleTime(LocalDateTime.MAX);
    cab.setStartTripTime(LocalDateTime.now());
    cab.setNooftrips(cab.getNooftrips() + 1);
    cab.setCabLocation(c1);
    cab.setStatus(Status.ON_TRIP);
    cab.setSourceCity(c1);
    cab.setDestinationCity(c2);
    printStatus();
    return cab;
  }

  private static void printStatus() {
    System.out.println();
    System.out.println();
    for (Cab cab:cabList){
      System.out.println(cab);
    }
  }

  private static List<Cab> getCabLocationList(City city) {
    List<Cab> cabs = new ArrayList<>();
    minQueue.removeAll(minQueue);
    maxQueue.removeAll(maxQueue);
    for (Cab cab : cabList) {
      if (cab.getCabLocation().getName().equals(city.getName()) && cab.getStatus().equals(Status.IDLE)) {
        cabs.add(cab);
        minQueue.add(cab);
        maxQueue.add(cab);
      }
    }

    /*if (cabs.size() == 0) {
      for (Cab cab : cabList) {
        if (cab.getStatus().equals(Status.IDLE)) {
          cabs.add(cab);
        }
      }
    }*/
    return cabs;
  }

  public static void endTrip(Cab cab, City city) {
    cab.setEndTripTime(LocalDateTime.now());
    cab.setStatus(Status.IDLE);
    cab.setCabLocation(city);
    cab.setIdleTime(LocalDateTime.now());
    cab.setDestinationCity(null);
    cab.setSourceCity(null);
    printStatus();
  }

  public void changeLocation(City city) {
    cabLocation = city;
    printStatus();
  }

  @Override
  public String toString() {
    return "Cab{" +
        "name='" + name + '\'' +
        ", sourceCity=" + sourceCity +
        ", destinationCity=" + destinationCity +
        ", idleTime=" + idleTime +
        ", startTripTime=" + startTripTime +
        ", endTripTime=" + endTripTime +
        ", status=" + status +
        ", cabLocation=" + cabLocation +
        ", nooftrips=" + nooftrips +
        '}';
  }
}
