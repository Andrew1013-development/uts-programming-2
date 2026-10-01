/**
 * The store has and sells one product: Sticky tape.
 *
 * You can sell and restock a product, view stock and view cash.
 */
public class Store {
    public static void main(String[] args) {
        Store store = new Store();
        char choice = '/';

        while (choice != 'x') {
            System.out.print("Choice (s/r/v/c/x): ");
            choice = In.nextChar();
            switch (choice) {
                case 's':
                    store.sell();
                    break;
                case 'r':
                    store.restock();
                    break;
                case 'v':
                    store.viewStock();
                    break;
                case 'c':
                    store.viewCash();
                    break;
                case 'x':
                    break;
                case '?':
                    help();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private final CashRegister cash_register;
    private final Product product;

    public Store() {
        this.cash_register = new CashRegister(0.0);
        this.product = new Product("Sticky tape", 2.99, 200);
    }

    private void sell() {
        int cnt;
        double rev;

        System.out.print("Number: ");
        cnt = In.nextInt();
        rev = product.sell(cnt);
        if (rev == -1.0)
            return;
        cash_register.accumulate(rev);
    }

    private void restock() {
        int cnt;
        double rev;

        System.out.print("Number: ");
        cnt = In.nextInt();
        product.restock(cnt);
    }

    private void viewStock() {
        System.out.println(product);
    }

    private void viewCash() {
        System.out.println(cash_register);
    }

    private static void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("x = exit");
    }
}
