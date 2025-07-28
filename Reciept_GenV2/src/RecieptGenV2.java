import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class RecieptGenV2 {
    public static void main(String[] args) {

        // Data storage for the cart
        ArrayList<String> itemNames = new ArrayList<>();
        ArrayList<BigDecimal> itemPrices = new ArrayList<>();
        ArrayList<Integer> itemQuantities = new ArrayList<>();

        // Tools for the application
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        // Main application loop
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                // Case 1: Add a new item to the cart
                case 1: {
                    scanner.nextLine(); // Consume newline left-over

                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    itemNames.add(name);

                    System.out.print("Enter item price: ");
                    BigDecimal price = scanner.nextBigDecimal();
                    itemPrices.add(price);

                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    itemQuantities.add(quantity);

                    System.out.println("'" + name + "' added to cart.");
                    break;
                }
                // Case 2: Display current items and running total
                case 2: {
                    System.out.println("\n--- Current Cart ---");
                    BigDecimal currentTotal = BigDecimal.ZERO;

                    for (int i = 0; i < itemNames.size(); i++) {
                        BigDecimal price = itemPrices.get(i);
                        int quantity = itemQuantities.get(i);
                        BigDecimal lineTotal = price.multiply(new BigDecimal(quantity));
                        currentTotal = currentTotal.add(lineTotal);

                        System.out.printf("%s (%d x $%.2f) = $%.2f%n", itemNames.get(i), quantity, price, lineTotal);
                    }
                    System.out.printf("--------------------\n");
                    System.out.printf("Current Running Total: $%.2f%n", currentTotal);
                    break;
                }
                // Case 3: Exit the loop and proceed to checkout
                case 3: {
                    System.out.println("Proceeding to checkout...");
                    isRunning = false;
                    break;
                }
                // Handle invalid menu options
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (isRunning);

        // This block runs after the user exits the main loop
        System.out.println("\n--- FINAL RECEIPT ---");
        BigDecimal subtotal = BigDecimal.ZERO;

        for (int i = 0; i < itemNames.size(); i++) {
            BigDecimal price = itemPrices.get(i);
            int quantity = itemQuantities.get(i);
            BigDecimal lineTotal = price.multiply(new BigDecimal(quantity));
            subtotal = subtotal.add(lineTotal);
            System.out.printf("%s (%d x $%.2f) = $%.2f%n", itemNames.get(i), quantity, price, lineTotal);
        }

        // Final calculations and display
        if (subtotal.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Your cart is empty.");
        } else {
            BigDecimal taxRate = new BigDecimal("0.18");
            BigDecimal tax = subtotal.multiply(taxRate);
            BigDecimal total = subtotal.add(tax);

            System.out.println("---------------------------");
            // Set scale to 2 decimal places for currency display
            System.out.printf("%-15s $%.2f%n", "Subtotal:", subtotal);
            System.out.printf("%-15s $%.2f%n", "Tax (18%):", tax.setScale(2, RoundingMode.HALF_UP));
            System.out.printf("%-15s $%.2f%n", "TOTAL:", total.setScale(2, RoundingMode.HALF_UP));
        }

        System.out.println("\nExiting application. Thank you!");
        scanner.close();
    }
}