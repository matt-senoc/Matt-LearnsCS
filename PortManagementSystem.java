import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PortManagementSystem {

    private ArrayDeque<Container> containerStack;
    private ArrayDeque<Ship> shipQueue;
    private Scanner scanner;

    public PortManagementSystem() {
        containerStack = new ArrayDeque<>();
        shipQueue = new ArrayDeque<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        PortManagementSystem system = new PortManagementSystem();
        system.run();
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.nextLine(); // Clear the invalid input from the scanner
                choice = -1; // Set choice to an invalid value to re-loop
            }

            switch (choice) {
                case 1:
                    storeContainer();
                    break;
                case 2:
                    viewPortContainers();
                    break;
                case 3:
                    registerArrivingShip();
                    break;
                case 4:
                    viewWaitingShips();
                    break;
                case 5:
                    loadNextShip();
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye! 👋");
                    break;
                default:
                    if (choice != -1) {
                        System.out.println("Invalid choice. Please enter a number from 0-5.");
                    }
            }
            System.out.println();
        } while (choice != 0);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("=== Port Container Management System ===");
        System.out.println("[1] Store container (push)");
        System.out.println("[2] View port containers");
        System.out.println("[3] Register arriving ship (enqueue)");
        System.out.println("[4] View waiting ships");
        System.out.println("[5] Load next ship (pop container + poll ship)");
        System.out.println("[0] Exit");
    }

    private void storeContainer() {
        String id = null, description = null;
        double weight = -1;

        // Loop to get and validate container ID
        while (id == null) {
            System.out.print("Enter container ID (e.g., CT001): ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                id = input;
            } else {
                System.out.println("ID cannot be empty. Please try again.");
            }
        }

        // Loop to get and validate description
        while (description == null) {
            System.out.print("Enter description: ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                description = input;
            } else {
                System.out.println("Description cannot be empty. Please try again.");
            }
        }

        // Loop to get and validate weight
        while (weight == -1) {
            System.out.print("Enter weight (kg): ");
            try {
                weight = scanner.nextDouble();
                if (weight < 0) {
                    System.out.println("Weight must be a positive number. Please try again.");
                    weight = -1; // Reset to loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number for weight.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Consume final newline

        Container newContainer = new Container(id, description, weight);
        containerStack.push(newContainer);
        System.out.println("Stored: " + newContainer);
    }

    private void viewPortContainers() {
        if (containerStack.isEmpty()) {
            System.out.println("No containers at the port. 📦");
            return;
        }

        System.out.println("TOP ->");
        containerStack.forEach(System.out::println);
        System.out.println("<- BOTTOM");
    }

    private void registerArrivingShip() {
        String name = null, captain = null;

        // Loop to get and validate ship name
        while (name == null) {
            System.out.print("Enter ship name (e.g., MV OceanStar): ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                name = input;
            } else {
                System.out.println("Ship name cannot be empty. Please try again.");
            }
        }

        // Loop to get and validate captain's name
        while (captain == null) {
            System.out.print("Enter captain's name: ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                captain = input;
            } else {
                System.out.println("Captain's name cannot be empty. Please try again.");
            }
        }

        Ship newShip = new Ship(name, captain);
        shipQueue.offer(newShip);
        System.out.println("Registered: " + newShip);
    }

    private void viewWaitingShips() {
        if (shipQueue.isEmpty()) {
            System.out.println("No ships waiting at the dock. 🚢");
            return;
        }

        System.out.println("FRONT ->");
        shipQueue.forEach(System.out::println);
        System.out.println("<- REAR");
    }

    private void loadNextShip() {
        if (containerStack.isEmpty()) {
            System.out.println("No containers available to load. 😟");
            return;
        }
        if (shipQueue.isEmpty()) {
            System.out.println("No ships waiting to be loaded. 😟");
            return;
        }

        Container containerToLoad = containerStack.pop();
        Ship shipToLoad = shipQueue.poll();
        System.out.println("Loaded: " + containerToLoad + " -> " + shipToLoad + " 🎉");
        System.out.println("Remaining containers: " + containerStack.size());
        System.out.println("Remaining ships waiting: " + shipQueue.size());
    }
}