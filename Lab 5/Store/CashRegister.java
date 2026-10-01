import java.text.*;

/**
 * The cash register stores cash.
 *
 * You can add cash to the cash register.
 */
public class CashRegister {
    private double cash;

    public CashRegister(double cash) {
        this.cash = cash;
    }

    public void accumulate(double revenue) {
        this.cash += revenue;
    }

    @Override
    public String toString() {
        if (this.cash == 0)
            return "Cash register: empty";
        return "Cash register: $%.2f".formatted(this.cash);
    }
}
