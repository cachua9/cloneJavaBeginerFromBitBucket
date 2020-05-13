package hust.soict.hedspi.aims.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.order.Order;

public class MainGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Order> orderList = new ArrayList<Order>();
	
	private JButton btnCreateOrder;
	private JButton btnAddItem;
	private JButton btnDelItemByID;
	private JButton btnDisplayOrder;
	private JButton btnExit;
	
	public MainGUI() {		
		init();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Aims Project");
		setSize(480, 360);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void init() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		btnCreateOrder = new JButton("Create new oder");
		cp.add(btnCreateOrder);
		btnAddItem = new JButton("Add item to order");
		cp.add(btnAddItem);
		btnDelItemByID = new JButton("Delete item by ID");
		cp.add(btnDelItemByID);
		btnDisplayOrder = new JButton("Display item in order");
		cp.add(btnDisplayOrder);
		btnExit = new JButton("Exit");
		cp.add(btnExit);
		
		btnCreateOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewOrder();
				
			}
		});
		btnAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addItem();
				
			}
		});
		btnDelItemByID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delItem();
				
			}
		});
		btnDisplayOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayItem();
				
			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}

	public static void main(String[] args) {
		new MainGUI();
	}
	
	private void createNewOrder() {
		Order newOrder = Order.createOrder();
		if(newOrder!=null) orderList.add(newOrder);
	}	
	private void addItem() {
		if(orderList.size()!=0) {
			new AddItemGUI(orderList);
		}
		else {
			JOptionPane.showMessageDialog(null, "Please create order!");
		}
	}	
	private void delItem() {		
		if(orderList.size()!=0) {
			new DelItemGUI(orderList);
		}
		else {
			JOptionPane.showMessageDialog(null, "Please create order!");
		}
	}
	private void displayItem() {
		if(orderList.size()!=0) {
			new ShowItemGUI(orderList);
		}
		else {
			JOptionPane.showMessageDialog(null, "Please create order!");
		}
	}
}
