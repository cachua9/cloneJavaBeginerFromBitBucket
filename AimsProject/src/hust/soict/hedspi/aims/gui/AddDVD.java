package hust.soict.hedspi.aims.gui;

import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class AddDVD extends AddMedia{
	
	private static final long serialVersionUID = 1L;
	
	private String director;
	private int length;
	private JTextField tfDirector;
	private JTextField tfLength;
	
	public AddDVD(Order order) {
		super(order);
		// TODO Auto-generated constructor stub
	}

	@Override
	void init() {
		Container cp = getContentPane();
		cp.setLayout(null);
		
		JLabel lbDirector = new JLabel("Director:");
		lbDirector.setBounds(10, 100, 110, 25);
		cp.add(lbDirector);
		tfDirector = new JTextField();
		tfDirector.setBounds(130, 100, 100, 25);
		cp.add(tfDirector);
		
		JLabel lbLength = new JLabel("Length:");
		lbLength.setBounds(10, 130, 110, 25);
		cp.add(lbLength);
		tfLength = new JTextField();
		tfLength.setBounds(130, 130, 100, 25);
		cp.add(tfLength);
	}

	@Override
	void confirm() {
		director = tfDirector.getText().toString();
		length = Integer.valueOf(tfLength.getText().toString());
		DigitalVideoDisc newDVD =  new DigitalVideoDisc(title,category,director,length,cost);
		order.addMedia(newDVD);
		int indexSelect = JOptionPane.showOptionDialog(null, "Do you want play DVD?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, new String[] {"Yes", "No"}, null);
		if (indexSelect == 0) {
			newDVD.play();
		}		
	}

}
