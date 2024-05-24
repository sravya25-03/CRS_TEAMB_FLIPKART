/**
 * This class represents the main application for the Course Registration System (CRS).
 * It provides functionality for user login, student registration, and password updates.
 */

package com.flipkart.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.flipkart.business.NotificationInterface;
import com.flipkart.business.NotificationOperation;
import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;
import com.flipkart.business.UserInterface;
import com.flipkart.business.UserOperation;
import com.flipkart.constant.GenderConstant;
import com.flipkart.constant.NotificationTypeConstant;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserNotFoundException;

public class CRSMainApplicationClient {

    // Flag to indicate if a user is logged in
    static boolean loggedin = false;

    // Interfaces for business operations
    StudentInterface studentInterface = StudentOperation.getInstance();
    UserInterface userInterface = UserOperation.getInstance();
    NotificationInterface notificationInterface = NotificationOperation.getInstance();

    /**
     * Main method to start the application
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CRSMainApplicationClient crsApplication = new CRSMainApplicationClient();
        int userInput;

        // Display the main menu
        createMainMenu();
        userInput = sc.nextInt();

        try {
            // Until user chooses to exit the application
            while (userInput != 4) {
                switch (userInput) {
                    case 1:
                        // Login
                        crsApplication.loginUser();
                        break;
                    case 2:
                        // Student registration
                        crsApplication.registerStudent();
                        break;
                    case 3:
                        // Update password
                        crsApplication.updatePassword();
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
                // Display the main menu again
                createMainMenu();
                userInput = sc.nextInt();
            }
        } catch (Exception ex) {
            System.out.println("Error occurred: " + ex);
        } finally {
            // Close the scanner
            sc.close();
        }
    }

    /**
     * Method to create the main menu
     */
    public static void createMainMenu() {
        System.out.println("------------------------------------------------------");
        System.out.println("|        Welcome to Course Registration System        |");
        System.out.println("|                                                     |");
        System.out.println("------------------------------------------------------");
        System.out.println("|   1. Login                                          |");
        System.out.println("|   2. Student Registration                           |");
        System.out.println("|   3. Update Password                                |");
        System.out.println("|   4. Exit                                           |");
        System.out.println("------------------------------------------------------");
        System.out.println("Enter your choice: ");
    }

    /**
     * Method to handle user login
     */
    public void loginUser() {
        Scanner in = new Scanner(System.in);
        String userId, password;
        try {
            System.out.println("+-----------------+");
            System.out.println("|      Login      |");
            System.out.println("+-----------------+");
            System.out.println("| User ID:        |");
            System.out.print("| ");
            userId = in.next();
            System.out.println("+-----------------+");
            System.out.println("| Password:       |");
            System.out.print("| ");
            password = in.next();
            System.out.println("+-----------------+");

            // Verify user credentials
            loggedin = userInterface.verifyCredentials(userId, password);

            if (loggedin) {
                // Get current date and time
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                LocalDateTime myDateObj = LocalDateTime.now();
                String formattedDate = myDateObj.format(myFormatObj);

                // Get user role
                String role = userInterface.getRole(userId);

                switch (role) {
                    case "ADMIN":
                        // Admin login
                        System.out.println("+----------------------------+");
                        System.out.println("|   " + formattedDate + "      |");
                        System.out.println("|   Admin Login Successful   |");
                        System.out.println("+----------------------------+");
                        System.out.println("       Welcome " + userInterface.getName(userId));
                        CRSAdminMenu adminMenu = new CRSAdminMenu();
                        adminMenu.createMenu();
                        break;
                    case "PROFESSOR":
                        // Professor login
                        System.out.println("+-----------------------------+");
                        System.out.println("|     " + formattedDate + "     |");
                        System.out.println("| Professor Login Successful  |");
                        System.out.println("+-----------------------------+");
                        System.out.println("        Welcome " + userInterface.getName(userId));
                        CRSProfessorMenu professorMenu = new CRSProfessorMenu();
                        professorMenu.createMenu(userId);
                        break;
                    case "STUDENT":
                        // Student login
                        String studentId = userId;
                        boolean isApproved = studentInterface.isApproved(studentId);
                        if (isApproved) {
                            System.out.println("+-----------------------------+");
                            System.out.println("|     " + formattedDate + "     |");
                            System.out.println("|  Student Login Successful   |");
                            System.out.println("+----------------------------+");
                            System.out.println("     Welcome " + userInterface.getName(userId));
                            CRSStudentMenu studentMenu = new CRSStudentMenu();
                            studentMenu.create_menu(studentId);
                        } else {
                            System.out.println("\u001B[31m+---------------------------------------------------------------------+");
                            System.out.println("|   \u001B[31mFailed to login, you have not been approved by the administration!   \u001B[31m|");
                            System.out.println("+---------------------------------------------------------------------+\u001B[0m");
                            loggedin = false;
                        }
                        break;
                }
            } else {
                // Invalid credentials
                System.out.println("\u001B[31m+------------------------+");
                System.out.println("|   Invalid Credentials! |");
                System.out.println("+------------------------+\u001B[0m");
            }
        } catch (UserNotFoundException ex) {
            // User not found exception
            System.out.println("\u001B[31m" + "+------------------------------------+" + "\u001B[0m");
            System.out.println("\u001B[31m" + "|                                    |" + "\u001B[0m");
            System.out.println("\u001B[31m" + "|     " + ex.getMessage() + "" + "\u001B[0m");
            System.out.println("\u001B[31m" + "|                                    |" + "\u001B[0m");
            System.out.println("\u001B[31m" + "+------------------------------------+" + "\u001B[0m");
        }
    }

    /**
     * Method to register a new student
     */
    public void registerStudent() {
        Scanner sc = new Scanner(System.in);
        String userId, name, password, address, branchName;
        GenderConstant gender;
        int genderV, batch;
        try {
            System.out.println("+---------------------------+");
            System.out.println("|  Student Registration     |");
            System.out.println("+---------------------------+");
            System.out.println("| Name:                     |");
            System.out.println("+---------------------------+");
            System.out.print("| ");
            name = sc.nextLine();
            System.out.println("+---------------------------+");
            System.out.println("| User ID:                  |");
            System.out.println("+---------------------------+");
            System.out.print("| ");
            userId = sc.next();
            System.out.println("+---------------------------+");
            System.out.println("| Password:                 |");
            System.out.println("+---------------------------+");
            System.out.print("| ");
            password = sc.next();
            System.out.println("+---------------------------+");
            System.out.println("| Gender:                   |");
            System.out.println("| 1: Male                   |");
            System.out.println("| 2: Female                 |");
            System.out.println("| 3: Other                  |");
            System.out.println("+---------------------------+");
            System.out.print("| ");
            genderV = sc.nextInt();
            sc.nextLine();
            switch (genderV) {
                case 1:
                    gender = GenderConstant.MALE;
                    break;
                case 2:
                    gender = GenderConstant.FEMALE;
                    break;
                case 3:
                    gender = GenderConstant.OTHER;
                    break;
                default:
                    gender = GenderConstant.OTHER;
            }
            System.out.println("+---------------------------+");
            System.out.println("| Branch:                   |");
            System.out.println("+---------------------------+");
            System.out.print("| ");
            branchName = sc.nextLine();
            System.out.println("+---------------------------+");
            System.out.println("| Batch:                    |");
            System.out.println("+---------------------------+");
            System.out.print("| ");
            batch = sc.nextInt();
            sc.nextLine();
            System.out.println("+---------------------------+");
            System.out.println("| Address:                  |");
            System.out.println("+---------------------------+");
            System.out.print("| ");
            address = sc.nextLine();
            System.out.println("+---------------------------+");

            // Register the student
            String newStudentId = studentInterface.register(name, userId, password, gender, batch, branchName,
                    address);

            // Send notification for registration
            // notificationInterface.sendNotification(NotificationTypeConstant.REGISTRATION, newStudentId, null, 0);

        } catch (StudentNotRegisteredException ex) {
            // Student registration exception
            System.out.println("\u001B[31m+---------------------------------------------------------------------------------------------------+\u001B[0m");
            System.out.println("\u001B[31m|  Something went wrong! " + ex.getStudentName()
                    + " not registered. Please try again  |\u001B[0m");
            System.out.println("\u001B[31m+--------------------------------------------------+------------------------------------------------+\u001B[0m");
        }
    }

    /**
     * Method to update user password
     */
    public void updatePassword() {
        Scanner in = new Scanner(System.in);
        String userId, newPassword;
        try {
            System.out.println("+--------------------------------+");
            System.out.println("|     Update Password            |");
            System.out.println("+--------------------------------+");

            System.out.println("| User ID:                         |");
            userId = in.next();
            System.out.println("+--------------------------------+");
            System.out.println("| New Password:                  |");
            newPassword = in.next();
            System.out.println("+--------------------------------+");

            // Update password
            boolean isUpdated = userInterface.updatePassword(userId, newPassword);
            if (isUpdated) {
                System.out.println("| \u001B[32mPassword updated successfully!\u001B[0m |");
            } else {
                System.out.println("| \u001B[31mSomething went wrong, please try again!\u001B[0m |");
            }
        } catch (Exception ex) {
            // Password update exception
            System.out.println("| \u001B[31mError Occurred: " + ex.getMessage() + "\u001B[0m |");
        }

        System.out.println("+--------------------------------+");

    }

}
