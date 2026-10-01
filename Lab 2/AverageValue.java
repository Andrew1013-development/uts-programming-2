public class AverageValue {
    public static void main(String[] args) {
        int val = 0, sum = 0, cnt = 0;

        while (true) {
            System.out.print("Value: ");
            val = In.nextInt();
            if (val == -1)
                break;
            sum += val;
            cnt++;
        }
        if (cnt != 0) {
            //System.out.printf("Average = %.15f\n", (double) sum / cnt);
            System.out.println("Average = " + Double.toString((double) sum / cnt));
        }
    }
}
