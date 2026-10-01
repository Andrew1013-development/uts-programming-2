public class LongestDrySpell {
    public static void main(String[] args) {
        double val;
        int max_consecutive = 0, consecutive = 0;

        while (true) {
            System.out.print("Rainfall: ");
            val = In.nextDouble();
            if (val == -1.0) break;
            if (val == 0.0)
                consecutive++;
            else {
                max_consecutive = Math.max(consecutive, max_consecutive);
                consecutive = 0;
            }
        }
        max_consecutive = Math.max(consecutive, max_consecutive);
        System.out.printf("Longest dry spell = %d\n", max_consecutive);
    }
}