package online.abhijeetadarsh.hospital.dao;

import online.abhijeetadarsh.hospital.models.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    private Connection connection;

    public DoctorDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctors";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("address"),
                        resultSet.getString("specialization"));
                doctors.add(doctor);
            }
        }
        return doctors;
    }

    public void addDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialization());
            statement.executeUpdate();
        }
    }

    public void updateDoctor(Doctor doctor) throws SQLException {
        String query = "UPDATE doctors SET name = ?, specialization = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialization());
            statement.setInt(3, doctor.getId());
            statement.executeUpdate();
        }
    }

    public void deleteDoctor(int id) throws SQLException {
        String query = "DELETE FROM doctors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
