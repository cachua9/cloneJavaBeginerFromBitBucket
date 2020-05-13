package hust.soict.hedspi.gui.awt;

import java.awt.*;  
import java.awt.event.*; 
 
public class WindowEventDemo extends Frame implements ActionListener, WindowListener {
 
   private TextField tfCount;
   private Button btnCount;
   private int count = 0;
 
   public WindowEventDemo() {
      setLayout(new FlowLayout());
 
      add(new Label("Counter")); 
 
      tfCount = new TextField("0", 10); 
      tfCount.setEditable(false);    
      add(tfCount);                 
 
      btnCount = new Button("Count");  
      add(btnCount);               
 
      btnCount.addActionListener(this);
 
      addWindowListener(this);
 
      setTitle("WindowEvent Demo"); 
      setSize(250, 100);         
      setVisible(true);           
   }
   
   public static void main(String[] args) {
      new WindowEventDemo(); 
   }
   
   @Override
   public void actionPerformed(ActionEvent evt) {
      ++count;
      tfCount.setText(count + "");
   }
 
   @Override
   public void windowClosing(WindowEvent evt) {
      System.exit(0);  
   }

   @Override 
   public void windowOpened(WindowEvent evt) { 
	   
   }
   @Override 
   public void windowClosed(WindowEvent evt) {
	   
   }
   @Override 
   public void windowIconified(WindowEvent evt) { 
	   System.out.println("Window Iconified");
   }
   @Override 
   public void windowDeiconified(WindowEvent evt) { 
	   System.out.println("Window Deiconified"); 
   }
   @Override 
   public void windowActivated(WindowEvent evt) { 
	   System.out.println("Window Activated");
   }
   @Override
   public void windowDeactivated(WindowEvent evt) { 
	   System.out.println("Window Deactivated"); 
   }
}