
package hospitalmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {

    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

 
 // Add Patient method
 public void addPatients() {

     System.out.print("Enter Patient ID: ");
     String id = scanner.next();

     System.out.print("Enter Patient Name: ");
     String name = scanner.next();

     System.out.print("Enter Patient Age: ");
     int age = scanner.nextInt();

     System.out.print("Enter Patient Gender: ");
     String gender = scanner.next();

     System.out.print("Enter Patient Phone: ");
     String phone = scanner.next();

     scanner.nextLine(); // Consume the leftover newline

     System.out.print("Enter Patient Address: ");
     String address = scanner.next();

     String query = "INSERT INTO patients (id, name, age, gender, phone, address) "
                  + "VALUES (?, ?, ?, ?, ?, ?)";

     try {
         PreparedStatement preparedStatement = connection.prepareStatement(query);

         preparedStatement.setString(1, id);
         preparedStatement.setString(2, name);
         preparedStatement.setInt(3, age);
         preparedStatement.setString(4, gender);
         preparedStatement.setString(5, phone);
         preparedStatement.setString(6, address);

         int affectedRows = preparedStatement.executeUpdate();

         if (affectedRows > 0) {
             System.out.println("Patient Added Successfully!");
         } else {
             System.out.println("Failed to Add Patient!");
         }

     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

    // View Patients method
    public void viewPatients() {

        String query = "SELECT * FROM patients";

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Patients:");
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-15s %-20s %-8s %-12s %-15s %-20s%n",
                    "Patient ID", "Name", "Age", "Gender", "Phone", "Address");
            System.out.println("--------------------------------------------------------------------------");

            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");

                System.out.printf("%-15s %-20s %-8d %-12s %-15s %-20s%n",
                        id, name, age, gender, phone, address);
            }

            System.out.println("--------------------------------------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Check whether patient exists in database
    public boolean getPatientById(String id) {

        String query = "SELECT * FROM patients WHERE id = ?";

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
