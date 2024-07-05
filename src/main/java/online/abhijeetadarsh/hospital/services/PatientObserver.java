package online.abhijeetadarsh.hospital.services;

public class PatientObserver implements IObserver {
  private String name;

  public PatientObserver(String name) {
    this.name = name;
  }

  @Override
  public void update(String message) {
    System.out.println("Notification to Patient " + name + ": " + message);
  }
}