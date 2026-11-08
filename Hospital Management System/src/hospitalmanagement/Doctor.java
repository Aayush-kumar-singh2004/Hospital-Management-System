
package hospitalmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {

    private Connection connection;

    public Doctor(Connection connection) {
        this.connection = connection;
    }

    // View all doctors
    public void viewDoctors() {

        String query = "SELECT * FROM doctors";

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Doctors:");
            System.out.println("---------------------------------------------------------------");
            System.out.printf("%-15s %-25s %-20s %-12s%n",
                    "Doctor ID", "Name", "Specialization", "Phone");
            System.out.println("---------------------------------------------------------------");

            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                String phone = resultSet.getString("phone");

                System.out.printf("%-15s %-25s %-20s %-12s%n",
                        id, name, specialization, phone);
            }

            System.out.println("---------------------------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Check whether doctor exists in database
    public boolean getDoctorById(String id) {

        String query = "SELECT * FROM doctors WHERE id = ?";

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
