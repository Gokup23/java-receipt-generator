import java.math.BigDecimal;
import java.util.Scanner;

public class RecieptGen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // user input section

        System.out.print("Enter item name: ");
        String item = scanner.nextLine();

        System.out.print("Enter quantity: ");
        BigDecimal quantity = scanner.nextBigDecimal();

        System.out.print("Enter price per item: ");
        BigDecimal price = scanner.nextBigDecimal();

        BigDecimal subtotal = price.multiply(quantity); // Calculation part
        BigDecimal taxRate = new BigDecimal("0.18");
        BigDecimal tax = subtotal.multiply(taxRate);
        BigDecimal total = subtotal.add(tax);

        System.out.println("\n\n");
        System.out.println("   --- YOUR RECEIPT ---   ");
        System.out.println("Item:               " + item);
        System.out.println("Quantity:           " + quantity);
        System.out.println("Price: $            " + price);
        System.out.println();
        System.out.println("Subtotal:           $ " + subtotal);
        System.out.println("Tax (18%):          $ " + tax);
        System.out.println("---------------------------");
        System.out.println("TOTAL:              $ " + total);
        System.out.println(" Have a nice day :D");
    }
}
