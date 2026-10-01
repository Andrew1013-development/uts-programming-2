import java.util.List;
import java.util.ArrayList;

public class MiddleAverage {
    public static void main(String[] args) {
        int val, sum;
        List<Integer> vals = new ArrayList<>();

        while (true) {
            System.out.print("Value: ");
            val = In.nextInt();
            if (val == -1)
                break;
            vals.add(val);
        }
        if (vals.size() >= 3) {
            sum = 0;
            vals.sort(null);
            for (int i = 1; i < vals.size() - 1; i++) {
                sum += vals.get(i);
            }
            System.out.println("Middle average = " + Double.toString((double)sum / (vals.size() - 2)));
        }
    }
}