package online.abhijeetadarsh.hospital.models;

public abstract class User {
    public enum UserType {
        PATIENT, DOCTOR
    };

    protected int id;
    protected String name;
    protected int age;
    protected String address;

    public User(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public abstract void displayInfo();
}
