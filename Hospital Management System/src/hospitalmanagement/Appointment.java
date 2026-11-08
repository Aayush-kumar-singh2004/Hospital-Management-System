
package hospitalmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Appointment {

    private Connection connection;
    private Scanner scanner;

    public Appointment(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    // Book Appointment
    public void bookAppointment(Patient patient, Doctor doctor) {

        System.out.print("Enter Appointment ID: ");
        String appointmentId = scanner.next();

        System.out.print("Enter Patient ID: ");
        String patientId = scanner.next();

        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.next();

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.next();

        if (patient.getPatientById(patientId)
                && doctor.getDoctorById(doctorId)) {

            if (checkDoctorAvailability(doctorId, appointmentDate)) {

                String query = "INSERT INTO appointments "
                        + "(id, patient_id, doctor_id, appointment_date) "
                        + "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))";

                try {
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(query);

                    preparedStatement.setString(1, appointmentId);
                    preparedStatement.setString(2, patientId);
                    preparedStatement.setString(3, doctorId);
                    preparedStatement.setString(4, appointmentDate);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        connection.commit();
                        System.out.println("Appointment Booked!");
                    } else {
                        System.out.println("Failed to Book Appointment!");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Doctor not available on this date!");
            }

        } else {
            System.out.println("Either doctor or patient doesn't exist!");
        }
    }

    // Check Doctor Availability
    public boolean checkDoctorAvailability(
            String doctorId, String appointmentDate) {

        String query = "SELECT COUNT(*) FROM appointments "
                + "WHERE doctor_id = ? "
                + "AND TRUNC(appointment_date) = TO_DATE(?, 'YYYY-MM-DD')";

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1, doctorId);
            preparedStatement.setString(2, appointmentDate);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);

                return count == 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
