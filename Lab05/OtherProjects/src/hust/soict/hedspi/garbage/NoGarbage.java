package hust.soict.hedspi.garbage;

public class NoGarbage {
	public static void main(String[] args) {
		String line = "String nay dai 7749 ky tu";
		StringBuffer str = new StringBuffer();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2000000; i++) {
			str.append(line);
		}
		System.out.println(System.currentTimeMillis() - start);
	}
}
