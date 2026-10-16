public class CountRisingPlaces {
    public static void main(String[] args) {
        int n, ans = 0;

        // Read integers 0–999 until -1.
        // Count how many have hundreds < tens < ones.
        // Print: Rising = <count>
        while (true) {
            n = readNumber();
            if (n == -1)
                break;
            if (rising(n))
                ans++;
        }
        System.out.printf("Rising = %d\n", ans);
    }

    public static boolean rising(int n) {
        int hundred, ten, one;
        // Extract xyz with / and %. Return true iff hundreds < tens < ones.
        hundred = n / 100;
        n %= 100;
        ten = n / 10;
        one = n % 10;
        return (hundred < ten && ten < one);
    }

    private static int readNumber() {
        System.out.print("Number: ");
        return In.nextInt();
    }
}