package online.abhijeetadarsh.hospital;

import online.abhijeetadarsh.hospital.models.User;
import online.abhijeetadarsh.hospital.models.User.*;
import online.abhijeetadarsh.hospital.models.Patient;
import online.abhijeetadarsh.hospital.services.UserFactory;
import online.abhijeetadarsh.hospital.dao.PatientDAO;
import online.abhijeetadarsh.hospital.services.NotificationSubject;
import online.abhijeetadarsh.hospital.services.PatientObserver;
import online.abhijeetadarsh.hospital.services.DoctorObserver;

public class App {
    public static void main(String[] args) {
        try {
            // Creating Users using Factory Pattern
            User patient = UserFactory.createUser(UserType.PATIENT, 0, "Alice Johnson", 25, "123 Cherry Lane", "Allergy");
            User doctor = UserFactory.createUser(UserType.DOCTOR, 0, "Dr. Emily Clark", 40, "456 Oak Street", "Dermatology");

            // Displaying User Information
            patient.displayInfo();
            System.out.println();
            doctor.displayInfo();
            System.out.println();

            // Database Operations using DAO Pattern
            PatientDAO patientDAO = new PatientDAO();
            patientDAO.addPatient((Patient) patient);

            Patient fetchedPatient = patientDAO.getPatientById(1);
            if (fetchedPatient != null) {
                fetchedPatient.displayInfo();
            }
            System.out.println();

            // Notification System using IObserver Pattern
            NotificationSubject notificationSubject = new NotificationSubject();
            notificationSubject.addObserver(new PatientObserver(patient.getName()));
            notificationSubject.addObserver(new DoctorObserver(doctor.getName()));

            notificationSubject.createNotification("Appointment scheduled on 2024-09-15 at 2:00 PM.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
