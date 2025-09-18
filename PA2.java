import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;

import java.util.Scanner;

public class PA2 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // Create a test client
        Customer Lucas = new Customer("Lucas Enoki");

        // Create some test products
        Product iPhone16 = new Product("iPhone 16", 999.99, 48);
        Product iPhone17 = new Product("iPhone 17", 1599.99, 32);
        Product iPhoneAir = new Product("IPhone Air", 2199.99, 55);
        Product S24 = new Product("Samsung S24", 999.99, 12);
        Product S25 = new Product("Samsung S25", 1199.99, 61);

        Product.showCatalog();

        boolean end = false;
        do{
            System.out.println("Please choose an option:");
            System.out.println("1: add product to cart");
            System.out.println("2: remove product from cart");
            System.out.println("3: make order");

            int userNumb = getInput(stdin);

            if (userNumb == 1){
                System.out.println("Please type the product ID from the catalog: ");
                int userProdID = stdin.nextInt();
                System.out.println("Please type the number of items you wish: ");
                int userNumbItems = stdin.nextInt();

                Lucas.addToCart(userProdID, userNumbItems);
                System.out.println("Total: " + Lucas.getTotal());
            }
            else if (userNumb == 2){
                System.out.println("Please type the product ID from the catalog: ");
                int userProdID = stdin.nextInt();
                System.out.println("Please type the number of items you wish to remove: ");
                int userNumbItems = stdin.nextInt();

                Lucas.removeFromCart(userProdID, userNumbItems);
                System.out.println("Total: " + Lucas.getTotal());
            }
            else if (userNumb == 3) {
                Order newOrder = Lucas.makeOrder();
                newOrder.makeSummary();
                end = true;
            }
            else if (userNumb == 0) {
                System.out.println("Please try again");
            }
        }
        while (end == false);
    }

    public static int getInput(Scanner stdin) {
        try {
            int userNumb = stdin.nextInt();
            return userNumb;
        }
        catch (Exception e) {
            System.out.println("Please choose one of the available options");
            stdin.nextLine();
            return 0;
        }
    }
}
