package online.abhijeetadarsh.hospital.dao;

import online.abhijeetadarsh.hospital.models.Patient;
import online.abhijeetadarsh.hospital.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {
    private Connection connection;

    public PatientDAO() throws SQLException {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patients (name, age, address, diagnosis) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, patient.getName());
        stmt.setInt(2, patient.getAge());
        stmt.setString(3, patient.getAddress());
        stmt.setString(4, patient.getDiagnosis());
        stmt.executeUpdate();
        System.out.println("Patient added successfully.");
    }

    public Patient getPatientById(int id) throws SQLException {
        String query = "SELECT * FROM patients WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Patient(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("address"),
                rs.getString("diagnosis")
            );
        }
        return null;
    }

    public void updatePatient(Patient patient) throws SQLException {
        String query = "UPDATE patients SET name = ?, age = ?, address = ?, diagnosis = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, patient.getName());
        stmt.setInt(2, patient.getAge());
        stmt.setString(3, patient.getAddress());
        stmt.setString(4, patient.getDiagnosis());
        stmt.setInt(5, patient.getId());
        stmt.executeUpdate();
        System.out.println("Patient updated successfully.");
    }

    public void deletePatient(int id) throws SQLException {
        String query = "DELETE FROM patients WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Patient deleted successfully.");
    }
}
