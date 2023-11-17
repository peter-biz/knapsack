public class WholeDynamic {   //aka 0/1 Dynamic
    public static int knapsack01Dynamic(int[] weights, int[] values, int capacity) {
        int n = weights.length;  //number of items
        int[][] dp = new int[n + 1][capacity + 1];   //dp[i][w] = max value for i items and w capacity

        for (int i = 0; i <= n; i++) {  //for each item
            for (int w = 0; w <= capacity; w++) {  //for each capacity
                if (i == 0 || w == 0) {   //base case
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {  //if item can fit in knapsack
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);  //take the max of the item's value + the max value for the remaining capacity and the max value for the previous item
                } else {  //if item cannot fit in knapsack
                    dp[i][w] = dp[i - 1][w]; //take the previous item's value
                }
            }
        }

        return dp[n][capacity]; //return the max value for n items and capacity
    }
}