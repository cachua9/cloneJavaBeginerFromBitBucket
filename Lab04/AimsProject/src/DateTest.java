
public class DateTest {
	public static void main(String[] args) {
		MyDate yesterday = new MyDate(19,3,2020);
		yesterday.print();
		
		MyDate today = new MyDate();
		today.accept("20-3-2020");
		today.print();
		
		today.setDay(21);
		today.print();
		
		today.setMonth(13);
		
		today.printform("dd-MMM-yyyy");
		today.printform("mm-dd-yyyy");
		
		System.out.println(MyDate.dateUtils(today, today));
		System.out.println(MyDate.dateUtils(yesterday, today));
		System.out.println(MyDate.dateUtils(today, yesterday));
	}
}
