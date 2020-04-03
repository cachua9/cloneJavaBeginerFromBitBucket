package hust.soict.hedspi.garbage;

public class GarbageCreator {
	public static void main(String[] args) {
		String line = "String nay dai 7749 ky tu";
		String str = "";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2000000; i++) {
			str +=line;
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}
