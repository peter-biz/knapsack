public class FractionalDynamic {
    public static double knapsackFractionalDynamic(double[] weights, double[] values, int capacity) {
        int n = weights.length;
        double[][] dp = new double[n + 1][(int) (capacity) + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][(int) (w - weights[i - 1])], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][(int) capacity];
    }
}

//FIXME: TODO: AHHHHHH sTINKY: FIXME; 