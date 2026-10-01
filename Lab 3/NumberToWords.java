public class NumberToWords {
    static String[] NAME_TEEN = {
            "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen",
    };
    static String[] NAME_10 = {
            "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety",
    };
    static String[] NAME_1 = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
    };

    private static String analyze(int val) {
        int val_100, val_10, rem_10;
        String res = "";

        val_100 = val / 100;
        val %= 100;
        val_10 = val / 10;
        rem_10 = val % 10;
        //System.out.printf("%d hundred %d-ty %d\n", val_100, val_10, rem_10);
        // < 10^3
        if (val_100 > 0) {
            res += String.format("%s hundred", NAME_1[val_100]);
            if (val_10 > 0 || rem_10 > 0)
                res += " and ";
        }

        // < 10^2
        if (val_10 > 0) {
            if (val_10 == 1) {
                if (rem_10 > 0)
                    res += NAME_TEEN[rem_10 - 1];
                else
                    res += NAME_10[0];
                rem_10 = 0;
            } else
                res += NAME_10[val_10 - 1];
            if (rem_10 > 0)
                res += " ";
        }

        // < 10^1
        if (rem_10 > 0 || (val_100 == 0 && val_10 == 0))
            res += NAME_1[rem_10];
        //System.out.println(res);
        return res;
    }
    private static void test_sample() {
        // exhaustive test cases
        assert analyze(0).equals("zero");
        assert analyze(1).equals("one");
        assert analyze(10).equals("ten");
        assert analyze(15).equals("fifteen");
        assert analyze(30).equals("thirty");
        assert analyze(33).equals("thirty three");
        assert analyze(100).equals("one hundred");
        assert analyze(106).equals("one hundred and six");
        assert analyze(210).equals("two hundred and ten");
        assert analyze(325).equals("three hundred and twenty five");

        // sample test cases
        assert analyze(17).equals("seventeen");
        assert analyze(103).equals("one hundred and three");
        assert analyze(800).equals("eight hundred");
        assert analyze(42).equals("forty two");
    }
    public static void main(String[] args) {
        test_sample();
        int val;

        while (true) {
            System.out.print("Number: ");
            val = In.nextInt();
            if (val == -1) {
                System.out.println("Done");
                break;
            }
            System.out.println(analyze(val));
        }
    }
}