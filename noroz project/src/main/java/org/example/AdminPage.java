package org.example;

import java.util.Scanner;

public class AdminPage implements Page {
    private Admin admin;
    private EditRequestManager manager;

    // Constructor to initialize Admin and EditRequestManager
    public AdminPage(Admin admin, EditRequestManager manager) {
        this.admin = admin;
        this.manager = manager;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Loop for displaying the Admin Panel menu
        while (running) {
            System.out.println("===== Admin Panel =====");
            manager.displayRequests();  // Display the requests (using the instance method of manager)

            System.out.println("Options:");
            System.out.println("A: Approve a request");
            System.out.println("R: Reject a request");
            System.out.println("B: Back");

            // Get user input
            char choice = scanner.next().toUpperCase().charAt(0);

            // Handle user input for different options
            switch (choice) {
                case 'A': {
                    System.out.print("Enter request number to approve: ");
                    int index = scanner.nextInt() - 1; // Adjusting for zero-based indexing
                    manager.approveRequest(index);  // Using the instance method to approve
                    break;
                }
                case 'R': {
                    System.out.print("Enter request number to reject: ");
                    int index = scanner.nextInt() - 1; // Adjusting for zero-based indexing
                    manager.rejectRequest(index);  // Using the instance method to reject
                    break;
                }
                case 'B': {
                    running = false; // Exit the loop
                    Handlemenu m = new Handlemenu(); // Assuming Handlemenu is a valid class
                    m.show(); // Show the previous menu
                    break;
                }
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
