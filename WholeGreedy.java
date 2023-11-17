public class WholeGreedy { //aka 0/1 greedy

    public static int knapsack01Greedy(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int value = 0;

        for (int i = 0; i < n; i++) {
            if (weights[i] <= capacity) {
                capacity -= weights[i];
                value += values[i];
            }
        }

        return value;
    }
}