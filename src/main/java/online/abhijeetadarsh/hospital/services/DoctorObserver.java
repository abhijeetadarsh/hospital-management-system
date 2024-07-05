package online.abhijeetadarsh.hospital.services;

public class DoctorObserver implements IObserver {
  private String name;

  public DoctorObserver(String name) {
    this.name = name;
  }

  @Override
  public void update(String message) {
    System.out.println("Notification to Doctor " + name + ": " + message);
  }
}