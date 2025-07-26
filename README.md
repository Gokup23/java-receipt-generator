# Simple Receipt Generator 🧾

A simple command-line application written in Java that generates a sales receipt. This project was created as a practice exercise to strengthen fundamental Java programming skills. It takes user input for an item's name, quantity, and price, then calculates the subtotal, tax, and final total, presenting it all in a nicely formatted receipt.

## Features
* Accepts user input for item details (name, quantity, price).
* Accurately calculates subtotal, a fixed tax amount, and the final total.
* Uses the `BigDecimal` class to handle monetary values, avoiding floating-point inaccuracies.
* Displays a clean, aligned, and easy-to-read receipt in the console.

## Technologies Used
* **Java**: Core programming language.
* **Java Development Kit (JDK)**: To compile and run the application.

## How to Run

To run this project locally, you will need to have the Java Development Kit (JDK) installed on your machine.

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/YOUR_USERNAME/java-receipt-generator.git](https://github.com/YOUR_USERNAME/java-receipt-generator.git)
    ```
2.  **Navigate to the project directory:**
    ```sh
    cd java-receipt-generator
    ```
3.  **Compile the Java code:**
    ```sh
    javac Main.java
    ```
4.  **Run the application:**
    ```sh
    java Main
    ```
    The program will then prompt you for input.

## Sample Usage
Here is an example of the program in action:

```
Enter item name: Espresso Machine
Enter quantity: 1
Enter price per item: 199.99

--- YOUR RECEIPT ---
Item:           Espresso Machine
Quantity:       1
Price:          $199.99

Subtotal:       $199.99
Tax (18%):      $36.00
---------------------------
TOTAL:          $235.99
```
