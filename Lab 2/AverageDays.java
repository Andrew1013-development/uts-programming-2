public class AverageDays {
    public static void main(String[] args) {
        int total = 0;
        int[] MONTH_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};

        for (int i = 0; i < 12; i++) {
            total += MONTH_DAYS[i];
        }
        System.out.printf("Average days per month = %.15f", (double)total / 12);
    }
}