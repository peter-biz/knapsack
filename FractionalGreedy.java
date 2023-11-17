import java.util.Arrays;

public class FractionalGreedy {

    public static double knapsackFractionalGreedy(double[] weights, double[] values, double capacity) {
        int n = weights.length;
        double[] ratio = new double[n];

        // Calculate the ratio of value to weight for each item
        for (int i = 0; i < n; i++) {
            ratio[i] = values[i] / weights[i];
        }

        // Create an array to store the indices of items
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort the items based on the ratio in descending order
        Arrays.sort(indices, (a, b) -> Double.compare(ratio[b], ratio[a]));

        double result = 0.0;

        // Iterate through the sorted items and add them to the knapsack
        for (int i = 0; i < n; i++) {
            int index = indices[i];
            if (weights[index] <= capacity) {
                result += values[index];
                capacity -= weights[index];
            } else {
                result += ratio[index] * capacity;
                break;
            }
        }

        return result;
    }
}