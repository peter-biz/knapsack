// Purpose: Runs each of the algorithms for the knapsack problem
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class KnapsackRunner {
    public static void main(String[] args) throws FileNotFoundException {
        /*
         * Uses the input.txt file to run multiple test cases.
         * File is formatted as follows:
         *   Line 1: weights (separated by commas)
         *   Line 2: values (separated by commas)
         *   Line 3: capacity
         *   Empty line between each test case       
         */ 
        Scanner sc = new Scanner(new File("input.txt"));  // input file
        int count = 1;  // test case count
    
        while (sc.hasNextLine()) {  // for each test case
            String weightsLine = sc.nextLine();
    
            // Check for a blank line (end of test case)
            if (weightsLine.isEmpty()) {
                continue;
            }
    
            String[] weightsString = weightsLine.split(",");
            String[] valuesString = sc.nextLine().split(",");
            int capacity = Integer.parseInt(sc.nextLine());
    
            // Convert inputs to arrays (whole)
            int[] weightsInt = Arrays.stream(weightsString).mapToInt(Integer::parseInt).toArray();
            int[] valuesInt = Arrays.stream(valuesString).mapToInt(Integer::parseInt).toArray();

            // Convert inputs to arrays (fractional)
            double[] weightsDouble = Arrays.stream(weightsString).mapToDouble(Double::parseDouble).toArray();
            double[] valuesDouble = Arrays.stream(valuesString).mapToDouble(Double::parseDouble).toArray();
    
            // Print test case header
            System.out.println("Test case " + count + ":");

            // Print the max value using wholeDynamic (Expected output: 220, 309, 0, 3, 1735)
            System.out.println("Whole(0/1) Dynamic Test case " + count + ": " + WholeDynamic.knapsack01Dynamic(weightsInt, valuesInt, capacity));
            
            // Print the max value using fractionalDynamic
            System.out.println("Fractional Dynamic Test case " + count + ": " + FractionalDynamic.knapsackFractionalDynamic(weightsDouble, valuesDouble, capacity));
    
            // Print the max value using wholeGreedy
            System.out.println("Whole(0/1) Greedy Test case " + count + ": " + WholeGreedy.knapsack01Greedy(weightsInt, valuesInt, capacity));
    
            // Print the max value using fractionalGreedy
            System.out.println("Fractional Greedy Test case " + count + ": " + FractionalGreedy.knapsackFractionalGreedy(weightsDouble, valuesDouble, capacity));
            
            // Print a blank line between each test case
            System.out.println();
            count++;
        }
        sc.close();
    }
}

//TODO: FIXME: prolly remove testinput.txt