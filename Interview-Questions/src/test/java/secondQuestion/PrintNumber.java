package secondQuestion;

import java.util.Arrays;
import java.util.Random;

public class PrintNumber {

	public static void main(String[] args) {
		Random random = new Random();
		int count;
		int[] numbers = new int[500];
		numbers[0] = random.nextInt(1000);
		int largestNumber = numbers[0];
		int smallestNumber = numbers[0];
		for (count = 1; count < 500; count++) {
			numbers[count] = random.nextInt(1000);
			largestNumber = Math.max(largestNumber, numbers[count]);
			smallestNumber = Math.min(smallestNumber, numbers[count]);
		}

		System.out.println("The random 500 numbers are: " + Arrays.toString(numbers));
		System.out.println("Largest numbers is : " + largestNumber);
		System.out.println("Smallest number is : " + smallestNumber);
	}

}
