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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

public class ShowItemGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Order> orderList;
	
	public ShowItemGUI(ArrayList<Order> orderList) {
		this.orderList = orderList;
		init();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Display Item");
		setSize(360, 240);
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
		JLabel lbSelectOrder = new JLabel("Show item in order:");
		lbSelectOrder.setBounds(10, 10, 150, 25);
		cp.add(lbSelectOrder);
		JComboBox cbOrder = new JComboBox();
		cbOrder.setModel(new DefaultComboBoxModel(itemCbOrder));
		cbOrder.setBounds(170, 10, 50, 25);
		cp.add(cbOrder);
		
		JTable table = new JTable();
		DefaultTableModel tbModel = new DefaultTableModel();
		tbModel.addColumn("ID");
		tbModel.addColumn("Type");
		tbModel.addColumn("Title");
		tbModel.addColumn("Cost");
		table.setModel(tbModel);
		//table.setBounds(10, 45, 240, 150);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 45, 240, 150);
		cp.add(sp);
		
		JButton btnConfirm = new JButton("Show");
		btnConfirm.setBounds(260, 10, 70, 25);
		cp.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(260, 170, 80, 25);
		cp.add(btnCancel);
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tbModel.setRowCount(0);
				ArrayList<Media> itemOrdered = orderList.get(cbOrder.getSelectedIndex()).getItemOrdered();
				for (Media media : itemOrdered) {
					if(media instanceof DigitalVideoDisc) {
						tbModel.addRow(new Object[] {media.getID(), "DVD", media.getTitle(), media.getCost()});
					}
					else if(media instanceof Book) {
						tbModel.addRow(new Object[] {media.getID(), "Book", media.getTitle(), media.getCost()});
					}
					else if(media instanceof CompactDisc) {
						tbModel.addRow(new Object[] {media.getID(), "CD", media.getTitle(), media.getCost()});
					}
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
