import java.util.Scanner;
public class NumberOfDay {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input the year: ");
		int iYear = keyboard.nextInt();
		System.out.print("Input the month: ");
		String strMonth = keyboard.next();
		strMonth = strMonth.toLowerCase();		
		String[] array = {"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
		int iMounth = 0;
		if (isInt(strMonth)) {
			iMounth = Integer.parseInt(strMonth);
		}
		else {
			for(int i=0; i<12; i++) {
				if (strMonth.contains(array[i])) {
					iMounth = i+1;
				}
			}
		}
		int[] arrMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		if ((iYear%4==0)&&!((iYear%100)==0&&(iYear%400!=0))) {
			arrMonth[1]++;
		}
		
		System.out.println("Number of Month: " + arrMonth[iMounth-1]);
	}
	
	public static boolean isInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
