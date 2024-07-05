package online.abhijeetadarsh.hospital.models;

public class Patient extends User {
    private String diagnosis;

    public Patient(int id, String name, int age, String address, String diagnosis) {
        super(id, name, age, address);
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Diagnosis: " + diagnosis);
    }
}
