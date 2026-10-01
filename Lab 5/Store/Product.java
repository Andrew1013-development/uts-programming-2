import java.text.*;

/**
 * Each product has a name, stock and price.
 *
 * You can sell and restock a product.
 */
public class Product {
    private final String name;
    private final double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public double sell(int n) {
        if (this.stock < n) {
            System.out.println("Not enough stock.");
            return -1.0;
        }
        this.stock -= n;
        return this.price * n;
    }

    public void restock(int n) {
        this.stock += n;
    }

    @Override
    public String toString() {
        return "%d %s at $%.2f".formatted(this.stock, this.name, this.price);
    }
}
