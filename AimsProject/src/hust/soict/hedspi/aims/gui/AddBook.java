package hust.soict.hedspi.aims.gui;

import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.order.Order;

public class AddBook extends AddMedia{

	private static final long serialVersionUID = 1L;
	private String[] authors;
	private JTextField tfAuthors;
	
	public AddBook(Order order) {
		super(order);
		// TODO Auto-generated constructor stub
	}	

	@Override
	void init() {
		Container cp = getContentPane();
		cp.setLayout(null);
		
		JLabel lbAuthors = new JLabel("Authors:");
		lbAuthors.setBounds(10, 100, 110, 25);
		cp.add(lbAuthors);
		tfAuthors = new JTextField();
		tfAuthors.setBounds(130, 100, 100, 25);
		cp.add(tfAuthors);
		
	}

	@Override
	void confirm() {
		String text = tfAuthors.getText().toString();
		Book newBook =  new Book(title,category,cost);
		authors = text.split(",");
		for (String string : authors) {
			newBook.addAuthor(string);
		}
		order.addMedia(newBook);
	}

}
