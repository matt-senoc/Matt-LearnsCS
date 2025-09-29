package nicker;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
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
				case 1: queueMeth(); break;
				case 2: displayQueueMeth(); break;
				case 3: treatPatientMeth(); break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + decision);
			}
		
		} while (decision > -1 && decision < 3);		
	}
	
	
	
	private static void treatPatientMeth() {
//		treat
		
		
	}



	private static void displayQueueMeth() {
		///display
	}


	public static void queueMeth() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient name:");
		String Pname = sc.next();
	
		System.out.println("Enter patient name:");
		int prio = sc.nextInt();
		
		System.out.println("Enter patient name:");
		String med_condition= sc.next();
		
		System.out.println("Enter patient name:");
		String time = sc.next();
		
	
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(Pname, prio, med_condition, time);
		
	
			
//		adding
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		pq.queueMeth(Pname, prio, med_condition, time);

		System.out.println("PriorityQueue: " + pq); // Output: [5, 10, 20]	
		
//		access
		System.out.println("Head of Queue: " + pq.peek()); // Output: 5
		
//		removing
		System.out.println("Removed: " + pq.poll()); // Output: 5
		System.out.println("PriorityQueue after removal: " + pq); // Output: [10, 20]
//		comparator
		PriorityQueue<Integer> reversedQueue = new PriorityQueue<>(Collections.reverseOrder());
		reversedQueue.add(1);
		reversedQueue.add(3);
		reversedQueue.add(2);

		System.out.println(reversedQueue.poll()); // Output: 3
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
