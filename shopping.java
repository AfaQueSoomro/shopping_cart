import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " - Qty: " + quantity;
    }
}

public class ShoppingSystem {
    private ArrayList<Product> productList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ShoppingSystem system = new ShoppingSystem();
        system.run();
    }

    public void run() {
        while (true) {
            System.out.println("\nShopping System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Set Product Price and Quantity");
            System.out.println("3. Purchase Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    setProductPriceAndQuantity();
                    break;
                case 3:
                    purchaseProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        productList.add(new Product(name, price, quantity));
        System.out.println("Product added successfully!");
    }

    private void setProductPriceAndQuantity() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter new quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                productList.remove(product);
                productList.add(new Product(name, price, quantity));
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private void purchaseProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity to purchase: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                if (product.getQuantity() >= quantity) {
                    product.setQuantity(product.getQuantity() - quantity);
                    System.out.println("Product purchased successfully!");
                } else {
                    System.out.println("Insufficient quantity available.");
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private void deleteProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                productList.remove(product);
                System.out.println("Product deleted successfully!");
                return;
            }
        }
        System.out.println("Product not found.");
    }
}
