import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static double calcPrice(double itemPrice, double itemQuantity){
        return itemPrice * itemQuantity;
    }

    public static double calcTotalCartCost(double[] prices, int[] quantities) {
        double totalCost = 0;
        for (int i = 0; i < prices.length; i++) {
            totalCost += calcPrice(prices[i], quantities[i]);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a language: ");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        int language = scanner.nextInt();
        Locale locale;
        switch (language){
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
                break;
        }

        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("MessagesBundle", locale);
        } catch(Exception e) {
            System.out.println("Invalid language selected");
            rb = ResourceBundle.getBundle("MessagesBundle", new Locale("en", "US"));
        }

        System.out.print(rb.getString("numberOfItems"));
        int itemCount = scanner.nextInt();

        double[] prices = new double[itemCount];
        int[] quantities = new int[itemCount];

        for (int i = 0; i < itemCount; i++) {
            System.out.print(rb.getString("itemPrice"));
            prices[i] = scanner.nextDouble();

            System.out.print(rb.getString("itemQuantity"));
            quantities[i] = scanner.nextInt();
        }

        double totalCost = calcTotalCartCost(prices, quantities);
        String totalMessage = MessageFormat.format(rb.getString("totalPrice"), String.format("%.2f", totalCost));
        System.out.println(totalMessage);
        scanner.close();
    }
}
