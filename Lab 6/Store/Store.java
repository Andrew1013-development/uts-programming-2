import java.util.*;

public class Store {
    private CashRegister cashRegister;
    private LinkedList<Product> products = new LinkedList<>();

    public Store() {
        this.cashRegister = new CashRegister();
        this.products.addAll(List.of(new Product[]{
                new Product("Whiteboard Marker", 85, 1.50),
                new Product("Whiteboard Eraser", 45, 5.00),
                new Product("Black Pen", 100, 1.50),
                new Product("Red Pen", 100, 1.50),
                new Product("Blue Pen", 100, 1.50),
        }));
    }

    public void main(String[] args) {
        char choice;
        boolean runtime = true;

        while (runtime) {
            choice = readChoice();
            switch (choice) {
                case '?':
                case 'h': // this isn't even in the specification, one test case said "help me!"
                    help(); break;
                case 's': sell(); break;
                case 'r': restock(); break;
                case 'v': viewStock(); break;
                case 'c': viewCash(); break;
                case 'p': pruneProducts(); break;
                case 'x':
                    runtime = false;
                    System.out.println("Done");
                default:
                    break;
            }
        }
    }

    private char readChoice() {
        System.out.print("Choice (s/r/v/c/p/x): ");
        return In.nextChar();
    }

    private void sell() {
        String name;
        ArrayList<Integer> idx_list;
        int sell_num;

        name = readName();
        idx_list = searchProduct(name.toLowerCase());
        if (idx_list.isEmpty()) {
            System.out.println("No such product");
            return;
        }
        if (idx_list.size() > 1) {
            System.out.println("Multiple products match:");
            for (Integer idx : idx_list)
                System.out.println(products.get(idx));
            return;
        }
        for (Integer idx : idx_list) {
            System.out.printf("Selling %s\n", products.get(idx).getName());
            sell_num = readNumber();
            if (!products.get(idx).has(sell_num)) {
                System.out.println("Not enough stock");
                return;
            }
            cashRegister.add(products.get(idx).sell(sell_num));
        }
    }

    private void restock() {
        String name;
        ArrayList<Integer> idx_list;
        int restock_num, num;
        double price;

        name = readName();
        idx_list = searchProduct(name.toLowerCase());
        if (idx_list.isEmpty()) {
            System.out.println("Adding new product");
            num = readNumber();
            price = readPrice();
            this.products.add(new Product(name, num, price));
        } else {
            for (Integer idx : idx_list) {
                System.out.printf("Restocking %s\n", products.get(idx).getName());
                restock_num = readNumber();
                products.get(idx).restock(restock_num);
            }
        }
    }

    private void viewStock() {
        for (Product p : this.products)
            System.out.println(p);
    }

    private void viewCash() {
        System.out.println(this.cashRegister);
    }

    private void pruneProducts() {
        this.products.removeIf(Product::isEmpty);
    }

    private static String readName() {
        System.out.print("Name: ");
        return In.nextLine();
    }

    private static double readPrice() {
        System.out.print("Price: $");
        return In.nextDouble();
    }

    private static int readNumber() {
        System.out.print("Number: ");
        return In.nextInt();
    }

    private static void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("p = prune products");
        System.out.println("x = exit");
    }

    private ArrayList<Integer> searchProduct(String product_search_name) {
        ArrayList<Integer> idx_list = new ArrayList<>();

        for (int i = 0; i < products.size(); i++)
            if (products.get(i).getSearchName().contains(product_search_name))
                idx_list.add(i);
        return idx_list;
    }
}
