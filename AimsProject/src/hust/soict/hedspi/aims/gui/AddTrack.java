package hust.soict.hedspi.aims.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

public class AddTrack extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private CompactDisc cd;
	
	public AddTrack(CompactDisc cd) {
		this.cd = cd;
		thisinit();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Add Track");
		setSize(360, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void thisinit() {
		Container cp = getContentPane();
		cp.setLayout(null);
		
		JButton btnConfirm = new JButton("Ok");
		btnConfirm.setBounds(290, 80, 50, 25);
		cp.add(btnConfirm);
		
		JLabel lbTile = new JLabel("Title:");
		lbTile.setBounds(10, 10, 110, 25);
		cp.add(lbTile);
		JTextField tfTitle = new JTextField();
		tfTitle.setBounds(130, 10, 100, 25);
		cp.add(tfTitle);
		
		JLabel lbLength = new JLabel("Length:");
		lbLength.setBounds(10, 40, 110, 25);
		cp.add(lbLength);
		JTextField tfLength = new JTextField();
		tfLength.setBounds(130, 40, 100, 25);
		cp.add(tfLength);
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Track newTrack = new Track(tfTitle.getText().toString(), Integer.valueOf(tfLength.getText().toString()));
					cd.addTrack(newTrack);
					int indexSelect = JOptionPane.showOptionDialog(null, "Continue add track?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, new String[] {"Yes", "No"}, null);
					if (indexSelect == 0) {
						tfLength.setText("");
						tfTitle.setText("");
					}
					else {
						setVisible(false);
						indexSelect = JOptionPane.showOptionDialog(null, "Do you want play CD?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, new String[] {"Yes", "No"}, null);
						if (indexSelect == 0) {
							cd.play();
						}	
					}		
				}		
				catch (Exception x) {
					JOptionPane.showMessageDialog(null, "Input error!");
				}
			}
		});
		
	}

}
