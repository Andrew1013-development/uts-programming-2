public class LongestEqualRun {
    private static final long INF = -1;
    public static void main(String[] args) {
        long n, last_n, max_streak = 0, curr_streak = 0;
        // Read integers until -1.
        // Find the longest run of equal consecutive values.
        // Print: Longest = <length>
        // Check the last run after the loop.
        last_n = readNumber();
        if (last_n != INF) {
            curr_streak = 1;
            while (true) {
                n = readNumber();
                if (n == INF)
                    break;
                if (n == last_n) {
                    curr_streak++;
                } else {
                    max_streak = Math.max(max_streak, curr_streak);
                    last_n = n;
                    curr_streak = 1;
                }
            }
        }
        max_streak = Math.max(max_streak, curr_streak);
        System.out.printf("Longest = %d\n", max_streak);
    }
    private static long readNumber() {
        System.out.print("Number: ");
        return In.nextLong();
    }
}