import java.util.Comparator;
import java.util.TreeSet;

public class SecondMax {
    public static void main(String[] args) {
        long n;
        TreeSet<Long> sorted_set = new TreeSet<>(Comparator.reverseOrder());
        // Read integers until -1.
        // Print the second-largest distinct value.
        // Print: Second max = <value>
        // If there are fewer than two distinct values, print nothing.

        while (true) {
            n = readNumber();
            if (n == -1)
                break;
            sorted_set.add(n);
        }
        if (sorted_set.size() >= 2) {
            System.out.printf("Second max = %d\n", sorted_set.higher(sorted_set.getFirst()));
        }
    }

    private static long readNumber() {
        System.out.print("Number: ");
        return In.nextLong();
    }
}