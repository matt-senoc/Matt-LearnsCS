# Port Container Management System

This console-based Java application simulates a **Port Container Management System**. It manages the flow of containers and ships using **stack** and **queue** data structures, which are implemented with `ArrayDeque`. The system allows a port authority to store containers, register arriving ships, view current inventory, and load containers onto ships.

---

### Features
* **Store Container**: Adds a new container to a stack (**LIFO**).
* **Register Ship**: Adds a new ship to a queue (**FIFO**).
* **View Containers**: Displays all containers in the stack, from top to bottom.
* **View Ships**: Displays all ships in the queue, from front to back.
* **Load Ship**: Loads the top container from the stack onto the ship at the front of the queue.

---

### The Importance of Stacks, Queues, and Linked Lists in Programming

**Stacks** and **Queues** are fundamental data structures that help organize information in a specific, logical order. They are essential for solving real-world programming problems.

* **Stacks (LIFO)**: A stack operates on a **Last-In, First-Out** principle, much like a stack of plates. The last plate you put on is the first one you take off. In programming, stacks are used for things like a web browser's history or the "undo" function in a text editor.
* **Queues (FIFO)**: A queue follows a **First-In, First-Out** principle, just like a line at the grocery store. The first person in line is the first one to be served. Queues are used in applications like print job scheduling or managing network requests.
* **Linked Lists**: A linked list stores elements as a series of connected nodes. Because nodes can be easily added or removed from any position, a `LinkedList` can efficiently implement both a stack and a queue. It's a building block for more complex data structures.

---

### Why Use `ArrayDeque` and Not `LinkedList`?

While a `LinkedList` is a perfectly valid way to build a stack and a queue, `ArrayDeque` is often the superior choice for this task in Java due to its performance benefits.

* **Speed**: `ArrayDeque` uses a resizable array, which offers better **cache locality** than a `LinkedList`. This means that elements are stored next to each other in memory, allowing the processor to access them much faster.
* **Efficiency**: `ArrayDeque` is specifically optimized to act as a double-ended queue, making it highly efficient for both stack (`push`, `pop`) and queue (`offer`, `poll`) operations. This makes it a purpose-built tool for this project, offering performance advantages over the more general-purpose `LinkedList`.

---

### How to Run

1.  **Clone the repository**: `git clone [your_repo_link]`
2.  **Compile the Java files**: Ensure you have `Container.java`, `Ship.java`, and `PortManagementSystem.java`. Compile them using a Java compiler.
3.  **Run the main class**: Execute the `PortManagementSystem` class from your terminal or IDE.
4.  **Follow the on-screen menu**: Use the provided menu options to interact with the system.

---

### Sample Console Interaction

Here's an example of the kind of output you'll see when interacting with the system.

```console
=== Port Container Management System ===
[1] Store container (push)
[2] View port containers
[3] Register arriving ship (enqueue)
[4] View waiting ships
[5] Load next ship (pop container + poll ship)
[0] Exit
Enter your choice: 1
Enter container ID (e.g., CT001): CT001
Enter description: Electronics
Enter weight (kg): 500
Stored: CT001 | Electronics | 500kg

=== Port Container Management System ===
...
Enter your choice: 3
Enter ship name (e.g., MV OceanStar): MV OceanStar
Enter captain's name: Capt. Reyes
Registered: MV OceanStar | Capt. Reyes

=== Port Container Management System ===
...
Enter your choice: 5
Loaded: CT001 | Electronics | 500kg -> MV OceanStar | Capt. Reyes 🎉
Remaining containers: 0
Remaining ships waiting: 0
