# Java Multi-Threaded Number Processing

A simple Java application demonstrating multi-threading and thread synchronization using a producer-consumer pattern. This project showcases how multiple threads can securely share and process data concurrently.

## Features

- **Producer Thread (`NumberGenerator`)**: Generates a random integer between 0 and 99 every second and updates the shared data state.
- **Consumer Thread 1 (`SquareThread`)**: Continuously monitors the shared data, checks if the generated number is **even**, and calculates its square.
- **Consumer Thread 2 (`CubeThread`)**: Continuously monitors the shared data, checks if the generated number is **odd**, and calculates its cube.
- **Thread Synchronization (`SharedData`)**: Uses synchronized methods and thread notification mechanisms to safely coordinate state updates across threads.

---

## Code Structure

The project consists of the following classes:

1. **`NumberGenerator`**: Extends `Thread` to produce random numbers at regular intervals.
2. **`SquareThread`**: Extends `Thread` to consume and square even numbers.
3. **`CubeThread`**: Extends `Thread` to consume and cube odd numbers.
4. **`SharedData`**: Manages the critical section with `synchronized` methods to protect shared state access.
5. **`MultiThreadedNumber`**: The main driver class that initializes the shared object and starts all three threads.

---

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)** installed on your machine (Java 8 or higher recommended).

### Compiling and Running

1. Save the code into a file named `MultiThreadedNumber.java`.
2. Open your terminal or command prompt in the directory containing the file.
3. Compile the Java program using:
   ```bash
   javac MultiThreadedNumber.java


   java MultiThreadedNumber

   Generated Number: 42
Square of 42 = 1764
Generated Number: 17
Cube of 17 = 4913
Generated Number: 85
Cube of 85 = 614125
...
