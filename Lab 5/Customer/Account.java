import java.text.*;
/**
 * Each account has a type (Savings/Loan) and a balance.
 * The initial balance is read in from the user.
 *
 * You can deposit into and withdraw from an account, and
 * transfer money to another account.
 * In all of these, the amount is read in.
 */
public class Account {
    private double amount;

    public Account(double amount) {
        this.amount = amount;
    }

    public boolean has(double amount) {
        return (this.amount >= amount);
    }

    public void deposit(double amount) {
        this.amount += amount;
    }

    public void withdraw(double amount) {
        this.amount -= amount;
    }

    public void transferTo(double amount, Account target) {
        this.withdraw(amount);
        target.deposit(amount);
    }
    public double funds() {
        return this.amount;
    }
}