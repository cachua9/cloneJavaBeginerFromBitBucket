
public class MyDate {

		private int day;
		private int month;
		private int year;
		private String date;
		
		public MyDate() {
			
		}
		public MyDate(int day, int month, int year) {
			if(day<1||day>31) {
				System.out.println("Day wrong!!");
			}
			else {
				this.day=day;
			}
			if(month<1||month>12) {
				System.out.println("Month wrong!!");
			}
			else {
				this.month=month;
			}
			this.year=year;
			this.date=Integer.toString(day)+"-"+Integer.toString(month)+"-"+Integer.toString(year);
		}
		
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			if(day<1||day>31) {
				System.out.println("Set day wrong!!");
			}
			else {
				this.day=day;
				this.date=Integer.toString(day)+"-"+Integer.toString(month)+"-"+Integer.toString(year);
			}
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			if(month<1||month>12) {
				System.out.println("Set month wrong!!");
			}
			else {
				this.month=month;
				this.date=Integer.toString(day)+"-"+Integer.toString(month)+"-"+Integer.toString(year);
			}
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
			this.date=Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
		}
		
		public void accept(String date) {
			String out[] = date.split("-");
			int month=Integer.parseInt(out[1]);
			int day=Integer.parseInt(out[0]);
			if(month>0&&month<13&&day>0&&day<32) {
				this.year=Integer.parseInt(out[2]);
				this.month=month;
				this.day=day;
				this.date=date;
			}
			
			
		}
		public void print() {
			System.out.println(this.date);
		}
}
