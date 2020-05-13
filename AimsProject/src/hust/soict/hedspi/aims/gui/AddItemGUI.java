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

import hust.soict.hedspi.aims.order.Order;

public class AddItemGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Order> orderList;
	
	private JButton btnConfirm;
	
	public AddItemGUI(ArrayList<Order> orderList) {
		this.orderList = orderList;
		init();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Add Item");
		setSize(360, 240);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void init() {
		Container cp = getContentPane();
		cp.setLayout(null);
		
		btnConfirm = new JButton("Ok");
		btnConfirm.setBounds(290, 170, 50, 25);
		cp.add(btnConfirm);
		
		String[] itemCbOrder = new String[orderList.size()];
		for (int i = 0; i < orderList.size(); i++) {
			itemCbOrder[i] = ""+i;
		}
		JLabel lbSelectOrder = new JLabel("Add item to order:");
		lbSelectOrder.setBounds(10, 10, 150, 25);
		cp.add(lbSelectOrder);
		JComboBox cbOrder = new JComboBox();
		cbOrder.setModel(new DefaultComboBoxModel(itemCbOrder));
		cbOrder.setBounds(170, 10, 50, 25);
		cp.add(cbOrder);
		
		JLabel lbSelectType = new JLabel("Type:");
		lbSelectType.setBounds(10, 50, 150, 25);
		cp.add(lbSelectType);
		JComboBox cbType = new JComboBox();
		cbType.setModel(new DefaultComboBoxModel(new String[] {"DVD", "CD", "Book"}));
		cbType.setBounds(170, 50, 70, 25);
		cp.add(cbType);
		
		
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int indexType = cbType.getSelectedIndex();
				switch (indexType) {
				case 0:
					new AddDVD(orderList.get(cbOrder.getSelectedIndex())).setVisible(true);
					break;
				case 1:
					new AddCD(orderList.get(cbOrder.getSelectedIndex())).setVisible(true);
					break;
				case 2:
					new AddBook(orderList.get(cbOrder.getSelectedIndex())).setVisible(true);
					break;					
				default:
					
					break;
				}
				setVisible(false);				
			}
		});
	}

}
