package online.abhijeetadarsh.hospital.services;

import online.abhijeetadarsh.hospital.models.User;
import online.abhijeetadarsh.hospital.models.User.*;
import online.abhijeetadarsh.hospital.models.Patient;
import online.abhijeetadarsh.hospital.models.Doctor;

public class UserFactory {
    public static User createUser(UserType userType, int id, String name, int age, String address, String extraInfo) {
        return switch (userType) {
            case PATIENT -> new Patient(id, name, age, address, extraInfo);
            case DOCTOR -> new Doctor(id, name, age, address, extraInfo);
        };
    }
}
