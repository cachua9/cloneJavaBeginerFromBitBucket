package hust.soict.hedspi.aims.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

public class DelItemGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Order> orderList;

	public DelItemGUI(ArrayList<Order> orderList) {
		this.orderList = orderList;
		init();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Delete Item");
		setSize(360, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void init() {
		Container cp = getContentPane();
		cp.setLayout(null);
		
		String[] itemCbOrder = new String[orderList.size()];
		for (int i = 0; i < orderList.size(); i++) {
			itemCbOrder[i] = ""+i;
		}
		JLabel lbSelectOrder = new JLabel("Del item in order:");
		lbSelectOrder.setBounds(10, 10, 150, 25);
		cp.add(lbSelectOrder);
		JComboBox cbOrder = new JComboBox();
		cbOrder.setModel(new DefaultComboBoxModel(itemCbOrder));
		cbOrder.setBounds(170, 10, 50, 25);
		cp.add(cbOrder);
		
		JLabel lbID = new JLabel("ID:");
		lbID.setBounds(10, 40, 150, 25);
		cp.add(lbID);
		JTextField tfID = new JTextField();
		tfID.setBounds(170, 40, 50, 25);
		cp.add(tfID);
		
		
		JButton btnConfirm = new JButton("Delete");
		btnConfirm.setBounds(260, 10, 70, 25);
		cp.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(260, 80, 80, 25);
		cp.add(btnCancel);
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					orderList.get(cbOrder.getSelectedIndex()).removeMediaByID(Integer.valueOf(tfID.getText().toString()));
				}
				catch (Exception x) {
					JOptionPane.showMessageDialog(null, "Input error!");
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
			}
		});
		
	}
}
