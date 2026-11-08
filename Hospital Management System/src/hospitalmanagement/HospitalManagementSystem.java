//
//package hospitalmanagement;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class HospitalManagementSystem {
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            Connection connection = DBConnection.getConnection();
//
//            Patient patient = new Patient(connection, scanner);
//            Doctor doctor = new Doctor(connection);
//            Appointment appointment = new Appointment(connection, scanner);
//
//            while (true) {
//
//                System.out.println("\nHOSPITAL MANAGEMENT SYSTEM");
//                System.out.println("1. Add Patient");
//                System.out.println("2. View Patients");
//                System.out.println("3. View Doctors");
//                System.out.println("4. Book Appointment");
//                System.out.println("5. Exit");
//
//                System.out.print("Enter your choice: ");
//
//                int choice = scanner.nextInt();
//
//                switch (choice) {
//
//                    case 1:
//                        patient.addPatients();
//                        break;
//
//                    case 2:
//                        patient.viewPatients();
//                        break;
//
//                    case 3:
//                        doctor.viewDoctors();
//                        break;
//
//                    case 4:
//                        appointment.bookAppointment(patient, doctor);
//                        break;
//
//                    case 5:
//                        System.out.println(
//                            "THANK YOU FOR USING HOSPITAL MANAGEMENT SYSTEM!"
//                        );
//
//                        connection.close();
//                        scanner.close();
//                        return;
//
//                    default:
//                        System.out.println("Enter a valid choice!");
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}



package hospitalmanagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection = DBConnection.getConnection();

            Patient patient = new Patient(connection, scanner);
            Doctor doctor = new Doctor(connection);
            Appointment appointment = new Appointment(connection, scanner);

            while (true) {

                System.out.println("\nHOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");

                String input = scanner.next();

                int choice;

                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                    continue;
                }

                switch (choice) {

                    case 1:
                        patient.addPatients();
                        break;

                    case 2:
                        patient.viewPatients();
                        break;

                    case 3:
                        doctor.viewDoctors();
                        break;

                    case 4:
                        appointment.bookAppointment(patient, doctor);
                        break;

                    case 5:
                        System.out.println(
                            "THANK YOU FOR USING HOSPITAL MANAGEMENT SYSTEM!"
                        );

                        connection.close();
                        scanner.close();
                        return;

                    default:
                        System.out.println("Enter a valid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

