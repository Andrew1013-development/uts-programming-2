public class CountIncreases {
    public static void main(String[] args) {
        long ans = 0, last_num, num;
        // Read integers until -1.
        // Count how many are strictly greater than the previous integer.
        // Print: Increases = <count>
        last_num = readNumber();
        if (last_num != -1) {
            while (true) {
                num = readNumber();
                if (num == -1)
                    break;
                if (num > last_num)
                    ans++;
                last_num = num;
            }
        }
        System.out.printf("Increases = %d\n", ans);
    }

    private static long readNumber() {
        System.out.print("Number: ");
        return In.nextLong();
    }
}
