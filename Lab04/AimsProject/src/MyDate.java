
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
		public String getStringDate(){
			return(this.date);
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
		public String strDate(String formsString) {
			String[] array = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			String c = "-";
			if (formsString.indexOf("-")!=-1) c="-";
			if (formsString.indexOf("/")!=-1) c="/";
			if (formsString.indexOf(" ")!=-1) c=" ";
			String[] output = formsString.split(c);
			for(int i=0; i<output.length; i++) {
				if(output[i].compareTo("d")==0) {
					output[i]=this.day+"";
				}
				if(output[i].compareTo("dd")==0) {
					output[i]=this.day+"";
					if(this.day<10) output[i]="0"+output[i];
				}
				if(output[i].compareTo("yyyy")==0) {
					output[i]=this.year+"";
				}
				if(output[i].compareTo("M")==0) {
					output[i]=this.month+"";
				}
				if(output[i].compareTo("MM")==0) {
					output[i]=this.month+"";
					if(this.month<10) output[i]="0"+output[i];
				}
				if(output[i].compareTo("MMM")==0) {
					output[i]=array[this.month];
				}
			}
			String strDate = output[0]+c+output[1]+c+output[2];
			return strDate;
		}
		public void print() {
			String dateString = strDate("MMM dd yyyy");
			String[] output = dateString.split(" ");
			String afterDay="th";
			if(this.day == 1 || this.day == 21) {
				afterDay="st";
			}
			if(this.day == 2 || this.day == 22) {
				afterDay="nd";
			}
			if(this.day == 3 || this.day == 23) {
				afterDay="rd";
			}
			System.out.println(output[0]+" "+output[1]+afterDay+" "+output[2]);
		}
		public void printform(String formString) {
			System.out.println(strDate(formString));
		}
		public static int dateUtils(MyDate x, MyDate y) {
			if(x.getYear()<y.getYear()) return -1;
			else if(x.getYear()>y.getYear()) return 1;
			else {
				if(x.getMonth()<y.getMonth()) return -1;
				else if(x.getMonth()>y.getMonth()) return 1;
				else {
					if(x.getDay()<y.getDay()) return -1;
					else if(x.getDay()>y.getDay()) return 1;
				}
			}
			return 0;
		}
}
