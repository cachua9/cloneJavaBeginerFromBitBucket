package hust.soict.hedspi.aims.gui;

import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

public class AddCD extends AddMedia {

	private static final long serialVersionUID = 1L;
	
	private String director;
	private JTextField tfDirector;
	
	public AddCD(Order order) {
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
		
	}

	@Override
	void confirm() {
		director = tfDirector.getText().toString();
		CompactDisc newCD = new CompactDisc(title, category, director, cost);
		order.addMedia(newCD);	
		int indexSelect = JOptionPane.showOptionDialog(null, "Add track to CD?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, new String[] {"Yes", "No"}, null);
		if (indexSelect == 0) {
			new AddTrack(newCD);
		}
		else {
			indexSelect = JOptionPane.showOptionDialog(null, "Do you want play CD?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, new String[] {"Yes", "No"}, null);
			if (indexSelect == 0) {
				newCD.play();
			}	
		}
	}

}
