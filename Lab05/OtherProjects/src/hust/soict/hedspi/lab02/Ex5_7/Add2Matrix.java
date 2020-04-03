package hust.soict.hedspi.lab02.Ex5_7;

import java.util.*;
public class Add2Matrix {
	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(6) + 5, m = rand.nextInt(6) + 5;
		int[][] array1 = new int[n][m], array2 = new int[n][m];
		for (int i = 0; i < array1.length; i++)
			for (int j = 0; j < array1[i].length; j++) {
				array1[i][j] = rand.nextInt(10000) + 1;
			}			
		for (int i = 0; i < array2.length; i++)
			for (int j = 0; j < array2[i].length; j++) {
				array2[i][j] = rand.nextInt(10000) + 1;
			}			
		System.out.println("New random matrix 1:");
		for (int i = 0; i < array1.length; i++) {
			System.out.println(Arrays.toString(array1[i]));
		}	
		System.out.println("New random matrix 2:");
		for (int i = 0; i < array2.length; i++) {
			System.out.println(Arrays.toString(array2[i]));
		}
		int[][] array3 = new int[n][m];
		for (int i = 0; i < array1.length; i++)
			for (int j = 0; j < array1[i].length; j++) {
				array3[i][j] = array1[i][j] + array2[i][j];
			}
		System.out.println("Result matrix:");
		for (int i = 0; i < array3.length; i++) {
			System.out.println(Arrays.toString(array3[i]));
		}
	}
}
