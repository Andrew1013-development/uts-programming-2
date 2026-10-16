import java.util.Scanner;

public class Calendar {
    static String[] DATES = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
    };

    public static void main(String[] args) {
        String s1, s2, date_s_1, date_s_2;
        long d1, m1, y1, date_1 = 0, t1, d2, m2, y2, date_2, t2;
        Scanner sc = new Scanner(System.in);

        d1 = sc.nextInt();
        m1 = sc.nextInt();
        y1 = sc.nextInt();
        date_s_1 = sc.next();
        d2 = sc.nextInt();
        m2 = sc.nextInt();
        y2 = sc.nextInt();

        for (int i = 0; i < 5; i++)
            if (date_s_1.equals(DATES[i]))
                date_1 = i;

        t1 = y1 * 15 * 30 + m1 * 30 + d1;
        t2 = y2 * 15 * 30 + m2 * 30 + d2;
        date_2 = (date_1 + t2 - t1) % 5;
        if (date_2 < 0)
            date_2 += 5;
        date_2 %= 5;
        //System.out.println(DATES[Math.toIntExact(date_1)]);
        System.out.println(DATES[Math.toIntExact(date_2)]);
    }
}