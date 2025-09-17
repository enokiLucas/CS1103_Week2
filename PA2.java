import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class PA2 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int numbProducts = 0;
        int numbCustomer = 0;
        Product.displayTest();

        // Create a test client
        Customer Lucas = new Customer("Lucas Enoki");

        // Create some test products
        Product iPhone16 = new Product(1, "iPhone 16", 999.99, 48);
        Product iPhone17 = new Product(2, "iPhone 17", 1599.99, 32);
        Product iPhoneAir = new Product(3, "IPhone Air", 2199.99, 55);
        Product S24 = new Product(4, "Samsung S24", 999.99, 12);
        Product S25 = new Product(5, "Samsung S25", 1199.99, 61);

        System.out.println(S24.getPrice());
    }
}
