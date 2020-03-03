import java.util.Scanner;
public class DrawTriangle {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("n= ");
		int n = keyboard.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n+i; j++) {
				if(j<n-i-1) System.out.print(" ");
					else System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
