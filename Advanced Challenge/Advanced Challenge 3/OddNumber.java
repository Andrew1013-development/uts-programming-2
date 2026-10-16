import java.util.*;

public class OddNumber {
    private static final long[][] dp = new long[105][1005];
    private static long solve(long n, long s) {
        for (int i = 0; i < 105; i++)
            for (int j = 0; j < 1005; j++)
                dp[i][j] = 0;
        if (n % 2 != s % 2)
            return 0;
        dp[0][0] = 1;
        for (int val = 1; val <= s; val += 2) {
            for (int i = 1; i <= n; i++) {
                for (int j = val; j <= s; j++) {
                    dp[i][j] += dp[i-1][j-val];
                }
            }
        }
        return dp[Math.toIntExact(n)][Math.toIntExact(s)];
    }
    public static void main(String[] args) {
        int n,s;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();
        System.out.println(solve(n,s));
    }
}