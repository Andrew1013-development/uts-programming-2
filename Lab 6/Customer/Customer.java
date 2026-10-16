/**
 * A customer has a savings account and a loan account.
 *
 * You can deposit into and withdraw from the savings account,
 * and you can transfer money from the savings to the loan account.
 * You can also view the balance of all accounts.
 */
public class Customer {
    public static void main(String[] args) {
        new Customer().use();
    }
    private Account savingsAccount;
    private Account loanAccount;

    public Customer() {
        savingsAccount = new Account("Savings");
        loanAccount = new Account("Loan");
    }

    public void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
                case 'd': deposit(); break;
                case 'w': withdraw(); break;
                case 't': transfer(); break;
                case 's': show(); break;
                case 'v': view(); break;
                default: help(); break;
            }
        }
        System.out.println("Done");
    }

    private char readChoice() {
        System.out.print("Customer menu (d/w/t/s/x): ");
        return In.nextChar();
    }

    private void deposit() {
        double amount;
        String account_name;

        System.out.print("Account type: ");
        account_name = In.nextLine();
        switch (account_name) {
            case "Savings":
                amount = readAmount("deposit");
                savingsAccount.deposit(amount);
                break;
            case "Loan":
                amount = readAmount("deposit");
                loanAccount.deposit(amount);
                break;
            default:
                System.out.println("No such account");
                break;
        }
    }

    private void withdraw() {
        double amount = readAmount("withdraw");
        if (savingsAccount.has(amount))
            savingsAccount.withdraw(amount);
        else
            System.out.println("Insufficient funds");
    }

    private void transfer() {
        double amount = readAmount("transfer");
        if (savingsAccount.has(amount))
            savingsAccount.transferTo(amount, loanAccount);
        else
            System.out.println("Insufficient funds");
    }

    private double readAmount(String action) {
        System.out.print("Amount to " + action + ": $");
        return In.nextDouble();
    }

    private void show() {
        // View all accounts:
        //
        // for (Account account : accounts)
        //     System.out.println(account);
        //
        // View selected account:
        System.out.println(savingsAccount);
        System.out.println(loanAccount);
    }

    private void view() {
        String account_name;

        System.out.print("Account type: ");
        account_name = In.nextLine();
        switch (account_name) {
            case "Savings":
                System.out.println(savingsAccount);
                break;
            case "Loan":
                System.out.println(loanAccount);
                break;
            default:
                System.out.println("No such account");
        }
    }

    private void help() {
        System.out.println("Menu options");
        System.out.println("d = deposit");
        System.out.println("w = withdraw");
        System.out.println("t = transfer");
        System.out.println("s = show");
        System.out.println("x = exit");
    }
}