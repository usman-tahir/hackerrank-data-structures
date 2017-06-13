import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Hourglass {

	static int[] generateHourglass(int row, int start, int[][] grid) {
		int[] hourglassValues = new int[7];

		// Create the hourglass based on the starting index

		// Top left
		hourglassValues[0] = grid[row][start];

		// Top middle
		hourglassValues[1] = grid[row][start + 1];

		// Top right
		hourglassValues[2] = grid[row][start + 2];

		// Middle
		hourglassValues[3] = grid[row + 1][start + 1];

		// Bottom left
		hourglassValues[4] = grid[row + 2][start];

		// Bottom middle
		hourglassValues[5] = grid[row + 2][start + 1];

		// Bottom right
		hourglassValues[6] = grid[row + 2][start + 2];

		return hourglassValues;

	}

	static int[][] generateAllHourglasses(int[][] grid) {
		int[][] hourglasses = new int[16][7];
		int row, current;
		int index = 0;

		for (row = 0; row < 4; row += 1) {
			for (current = 0; current < 4; current += 1) {
				int[] generatedHourglass = generateHourglass(row, current, grid);
				// System.out.println(Arrays.toString(generatedHourglass));
				hourglasses[index++] = generatedHourglass;
			}
		}

		return hourglasses;
	}

	static int maximum(int[] elements) {
		int max = elements[0];
		int index;

		for (index = 0; index < elements.length; index += 1) {
			if (elements[index] >= max) {
				max = elements[index];
			}
		}
		return max;
	}

	static int sum(int[] elements) {
		int sum = 0;
		int index;

		for (index = 0; index < elements.length; index += 1) {
			sum += elements[index];
		}
		return sum;
	}

	static int generateMaxHourglassSum(int[][] hourglasses) {
		int[] sums = new int[hourglasses.length];
		int index;

		for (index = 0; index < sums.length; index += 1) {
			sums[index] = sum(hourglasses[index]);
		}
		return maximum(sums);
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		// Construct the 6x6 multidimensional array
		int[][] grid = new int[6][6];
		int a, b;

		for (a = 0; a < 6; a += 1) {
			for (b = 0; b < 6; b += 1) {
				System.out.print("Enter a value for index [" + a + "][" + b + "]: ");
				grid[a][b] = s.nextInt();
			}
		}
		int[][] hourglasses = generateAllHourglasses(grid);
		System.out.println(generateMaxHourglassSum(hourglasses));

	}

}