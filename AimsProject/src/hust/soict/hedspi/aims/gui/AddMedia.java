package hust.soict.hedspi.aims.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.order.Order;

public abstract class AddMedia extends JFrame {

	private static final long serialVersionUID = 1L;
	
	protected Order order;
	
	protected String title;
	protected String category;
	protected float cost;
	
	public AddMedia(Order order) {
		this.order = order;
		thisinit();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Add Item");
		setSize(360, 240);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void thisinit() {
		Container cp = getContentPane();
		cp.setLayout(null);
		
		JButton btnConfirm = new JButton("Ok");
		btnConfirm.setBounds(290, 170, 50, 25);
		cp.add(btnConfirm);
		
		JLabel lbTile = new JLabel("Title:");
		lbTile.setBounds(10, 10, 110, 25);
		cp.add(lbTile);
		JTextField tfTitle = new JTextField();
		tfTitle.setBounds(130, 10, 100, 25);
		cp.add(tfTitle);
		
		JLabel lbCategory = new JLabel("Category:");
		lbCategory.setBounds(10, 40, 110, 25);
		cp.add(lbCategory);
		JTextField tfCategory = new JTextField();
		tfCategory.setBounds(130, 40, 100, 25);
		cp.add(tfCategory);
		
		JLabel lbCost = new JLabel("Cost:");
		lbCost.setBounds(10, 70, 110, 25);
		cp.add(lbCost);
		JTextField tfCost = new JTextField();
		tfCost.setBounds(130, 70, 100, 25);
		cp.add(tfCost);
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					title = tfTitle.getText().toString();
					category = tfCategory.getText().toString();
					cost = Float.valueOf(tfCost.getText().toString());
					setVisible(false);
					confirm();					
				}
				catch (Exception x) {
					JOptionPane.showMessageDialog(null, "Input error!");
				}
			}
		});
		
		init();		
	}
	
	abstract void init();
	abstract void confirm();
	
}
