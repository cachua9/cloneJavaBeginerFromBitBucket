package hust.soict.hedspi.lab02.Ex5_6;

import java.util.*;
import java.util.stream.IntStream;
public class SortArray {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[rand.nextInt(16) + 5];
		for (int i = 0; i < array.length; i++)
		    array[i] = rand.nextInt(10000) + 1;		
		System.out.println("New random array:\n" + Arrays.toString(array));
		System.out.println("Length of array:\n" + array.length);
		Arrays.sort(array);		
		System.out.println("Sorted array:\n" + Arrays.toString(array));
		System.out.println("Sum of array: " + IntStream.of(array).sum());
		System.out.println("Average value of array: " + IntStream.of(array).sum()/array.length);
	}
}
