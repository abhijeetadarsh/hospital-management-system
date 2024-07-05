package online.abhijeetadarsh.hospital.services;

import java.util.ArrayList;
import java.util.List;

public class NotificationSubject {
  private List<IObserver> observers = new ArrayList<>();
  private String message;

  public void addObserver(IObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(IObserver observer) {
    observers.remove(observer);
  }

  public void notifyAllObservers() {
    for (IObserver observer : observers) {
      observer.update(message);
    }
  }

  public void createNotification(String message) {
    this.message = message;
    notifyAllObservers();
  }
}
