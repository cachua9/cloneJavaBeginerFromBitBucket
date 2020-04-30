package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
	public static void main(String[] args) {
		Book book = new Book("Cach lam giau", "Hoc tap", 799f);
		book.addAuthor("Huan Rose");
		book.setContent("Sau nay chi co lam chiu kho can cu bu sieng nang. Chi co lam thi moi co an.   Khong lam thi an ? an ?");
		System.out.println(book.toString());
	}

}
