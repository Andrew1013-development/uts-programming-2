/**
 * A customer has a savings account and a loan account.
 *
 * You can deposit into and withdraw from the savings account,
 * and you can transfer money from the savings to the loan account.
 * You can also view the balance of all accounts.
 */
public class Customer {
    public static void main(String[] args) {
        double savings_balance, loan_balance;
        char choice = '/';
        Customer customer;

        System.out.print("Initial Savings balance: $");
        savings_balance = In.nextDouble();
        System.out.print("Initial Loan balance: $");
        loan_balance = In.nextDouble();
        customer = new Customer(savings_balance, loan_balance);


        while (choice != 'x') {
            System.out.print("Customer menu (d/w/t/s/x): ");
            choice = In.nextChar();
            switch (choice) {
                case 'd':
                    customer.deposit();
                    break;
                case 'w':
                    customer.withdraw();
                    break;
                case 't':
                    customer.transfer();
                    break;
                case 's':
                    customer.show();
                    break;
                case 'x':
                    System.out.println("Done");
                    break;
                case '?':
                    help();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private final Account savings;
    private final Account loan;

    public Customer(double savings_funds, double loan_funds) {
        this.savings = new Account(savings_funds);
        this.loan = new Account(loan_funds);
    }

    private void deposit() {
        double amt;

        System.out.print("Amount to deposit: $");
        amt = In.nextDouble();
        savings.deposit(amt);
    }

    private void withdraw() {
        double amt;

        System.out.print("Amount to withdraw: $");
        amt = In.nextDouble();
        if (this.savings.has(amt))
            savings.withdraw(amt);
    }

    private void transfer() {
        double amt;

        System.out.print("Amount to transfer: $");
        amt = In.nextDouble();
        if (this.savings.has(amt))
            this.savings.transferTo(amt, this.loan);
    }

    private void show() {
        System.out.printf("Savings account has $%,.2f\n", this.savings.funds());
        System.out.printf("Loan account has $%,.2f\n", this.loan.funds());
    }

    private static void help() {
        System.out.println("Menu options");
        System.out.println("d = deposit");
        System.out.println("w = withdraw");
        System.out.println("t = transfer");
        System.out.println("s = show");
        System.out.println("x = exit");
    }
}