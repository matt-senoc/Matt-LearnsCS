

import java.util.PriorityQueue;
import java.util.Scanner;

public class exam {

    // A single, shared patient queue for the whole application.
    // It stores 'Patient' objects, not just integers.
    private static PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
    
    // A single scanner to be used throughout the program.
    private static Scanner sc = new Scanner(System.in);

    /**
     * The Patient class holds all data for a single patient.
     */
    static class Patient implements Comparable<Patient> {
        String name;
        int priorityLevel; // Lower number = higher priority
        String medicalCondition;
        String arrivalTime;

        public Patient(String name, int priorityLevel, String medicalCondition, String arrivalTime) {
            this.name = name;
            this.priorityLevel = priorityLevel;
            this.medicalCondition = medicalCondition;
            this.arrivalTime = arrivalTime;
        }
        
        @Override
        public String toString() {
            return String.format(" -> %s (Priority: %d, Condition: %s, Arrived: %s)",
                this.name, this.priorityLevel, this.medicalCondition, this.arrivalTime);
        }

        /**
         *how to order the queue
         */
        @Override
        public int compareTo(Patient other) {
            // First, compare by priority level.
            if (this.priorityLevel != other.priorityLevel) {
                return Integer.compare(this.priorityLevel, other.priorityLevel);
            }
            // If priorities are the same, compare by arrival time.
            return this.arrivalTime.compareTo(other.arrivalTime);
        }
    }

    public static void main(String[] args) {
        int decision;
        do {
            System.out.println("\n===== Hospital Triage System =====");
            System.out.println("1. Add a patient to the queue.");
            System.out.println("2. Display patient queue.");
            System.out.println("3. Treat the next patient.");
            System.out.println("4. Exit.");
            System.out.print("Enter option: ");
            
            decision = sc.nextInt();
            sc.nextLine(); 

            switch (decision) {
                case 1: addPatient(); break;
                case 2: displayQueue(); break;
                case 3: treatNextPatient(); break;
                case 4: System.out.println("Exiting the system. Goodbye!"); break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
            }

        } while (decision != 4);
        
        sc.close();
    }

    /**
     * Removes and displays the next patient to be treated from the queue.
     */
    private static void treatNextPatient() {
        if (patientQueue.isEmpty()) {
            System.out.println("\nNo patients in the queue to treat.");
        } else {
            Patient patientToTreat = patientQueue.poll(); //removes the highest priority element
            System.out.println("\nNOW TREATING:");
            System.out.println(patientToTreat);
        }
    }

    /**
     * Prints the current queue of patients in priority order.
     */
    private static void displayQueue() {
        if (patientQueue.isEmpty()) {
            System.out.println("\nThe patient queue is currently empty.");
        } else {
            System.out.println("\n--- Current Patient Queue (Highest priority first) ---");
            
            PriorityQueue<Patient> tempQueue = new PriorityQueue<>(patientQueue);
            int position = 1;
            while(!tempQueue.isEmpty()){
                System.out.println(position + "." + tempQueue.poll());
                position++;
            }
            System.out.println("-----------------------------------------------------");
        }
    }

    //Queueing Fields
    public static void addPatient() {
        System.out.println("\n--- Add New Patient ---");
        System.out.print("Enter patient name: ");
        String pName = sc.nextLine();

        System.out.print("Enter priority level (e.g., 1 for critical, 5 for stable): ");
        int prio = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter medical condition: ");
        String medCondition = sc.nextLine();

        System.out.print("Enter arrival time (e.g., 09:30): ");
        String time = sc.nextLine();

        Patient newPatient = new Patient(pName, prio, medCondition, time);
        patientQueue.add(newPatient);

        System.out.println("\nSUCCESS: " + pName + " has been added to the queue.");
    }
}
        
    
