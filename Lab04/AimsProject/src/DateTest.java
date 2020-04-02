
public class DateTest {
	public static void main(String[] args) {
		MyDate yesterday = new MyDate(18,3,2020);
		yesterday.print();
		
		MyDate today = new MyDate();
		today.accept("19-3-2020");
		today.print();
		
		today.setDay(20);
		today.print();
		
		today.setMonth(13);
	}
}
