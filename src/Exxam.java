package nicker;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class exam {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int decision;
	
		do {
			System.out.println("Enter option: "
					+ "\n1. Queue a patient."
					+ "\n2. Display patient queue."
					+ "\n3. Treat a patient."
					+ "\n4. Exit.");
			decision = sc.nextInt();
		switch (decision) {
				case 1: break;
				case 2: break;
				case 3: break;
				case 4: break;
				
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + decision);
			}
		
		} while (decision > -1);
		
		
		
	}
	
	class queueMeth(){

		System.out.println("Enter patient name:");
		String Pname = sc.next();
	
		System.out.println("Enter patient name:");
		int prio = sc.nextInt();
		
		System.out.println("Enter patient name:");
		String med_condition= sc.next();
		
		System.out.println("Enter patient name:");
		String time = sc.next();
		
		ERQueue er = new ERQueue();
		er.arrive(Pname, prio, med_condition, time);
	}
}
/*

fields: 
	name, medical condition, priority level, arrival time
	same priority level are determined by arrival time
	
IMPLEMENTED USING PRIORITY QUEUE DS

classes:
	string name
	int prio
	string med condition
	string arrivalTime
	
void arrive(String name, int priority, String condition, String time)	
void treatNext() → removes and displays the next patient to be treated
void displayQueue() → prints the current queue in the format below	
*/
