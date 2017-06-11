import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Arrays {
    private static String printReverseArray(int[] array) {
        String output = "";
        int i, l = array.length;

        for (i = l - 1; i >= 0; i -= 1) {
            // Perform a check to see if the element is the last element
            output += (i == 0) ? ("" + array[i]) : (array[i] + " ");
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // The number of elements in the array
        int i;

        // Create the array
        int arr[] = new int[n];

        // Fill the array
        for (i = 0; i < n; i += 1) {
            arr[i] = s.nextInt();
        }

        // Print the array in reverse
        String reversedArray = printReverseArray(arr);
        System.out.println(reversedArray);
    }
}