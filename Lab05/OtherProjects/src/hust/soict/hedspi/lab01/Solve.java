package hust.soict.hedspi.lab01;
// Example 6: 2.2.6
import javax.swing.JOptionPane;
import java.lang.Math;
public class Solve {
    public static void main(String[] args) {
        String strSl;
        strSl = JOptionPane.showInputDialog(null, "1, First-degree equation with one variable\n2, First-degree equation with two variable\n3, Second-degree equation with one variable\nInput function select: ", "Select function", JOptionPane.INFORMATION_MESSAGE);
        
        if (strSl.equals("1")) func1();
        else if (strSl.equals("2")) func2();
        else if (strSl.equals("3")) func3();

        System.exit(0);
    }

    public static void func1()
    {
        String strNum;
        Double a,b,x;

        try {
            strNum = JOptionPane.showInputDialog(null, "Input a, b separated by a comma(,): ", "Input numbers", JOptionPane.INFORMATION_MESSAGE);
           String[] str = strNum.split(",");
           a = Double.parseDouble(str[0]);
           b = Double.parseDouble(str[1]);
           x = -b/a;

           JOptionPane.showMessageDialog(null,"Result x = " + x,"Result",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Can't calculate!","Error",JOptionPane.ERROR_MESSAGE);
        }     

    }

    public static void func2()
    {
        String strNum;
        Double a11,a12,a21,a22,b1,b2,x1,x2,d,d1,d2;

        try {
            strNum = JOptionPane.showInputDialog(null, "Input a11, a12, b1, a21, a22, b2 separated by a comma(,): ", "Input numbers", JOptionPane.INFORMATION_MESSAGE);
           String[] str = strNum.split(",");
           a11 = Double.parseDouble(str[0]);
           a12 = Double.parseDouble(str[1]);
           b1 = Double.parseDouble(str[2]);
           a21 = Double.parseDouble(str[3]);
           a22 = Double.parseDouble(str[4]);
           b2 = Double.parseDouble(str[5]);
           d = a11 * a22 - a21 * a12;
           d1 = b1 * a22 - b2 * a12;
           d2 = a11 * b2 - a21 * b1;
           x1 = d1/d;
           x2 = d2/d;

           JOptionPane.showMessageDialog(null,"Result (x1,x2) =  (" + x1 + "," + x2 + ")","Result",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Can't calculate!","Error",JOptionPane.ERROR_MESSAGE);
        }   
    }

    public static void func3()
    {
        String strNum;
        Double a,b,c,x1,x2,dt;

        try {
            strNum = JOptionPane.showInputDialog(null, "Input a, b, c separated by a comma(,): ", "Input numbers", JOptionPane.INFORMATION_MESSAGE);
           String[] str = strNum.split(",");
           a = Double.parseDouble(str[0]);
           b = Double.parseDouble(str[1]);
           c = Double.parseDouble(str[2]);
           dt = b * b - 4 * a * c;

           if(dt == 0) JOptionPane.showMessageDialog(null,"Result x1 = x2 = " + (-b/(2*a)),"Result",JOptionPane.INFORMATION_MESSAGE);
           else if(dt<0) JOptionPane.showMessageDialog(null,"No solution","Result",JOptionPane.INFORMATION_MESSAGE);
           else {
                x1 = (-b + Math.sqrt(dt))/(2*a);
                x2 = (-b - Math.sqrt(dt))/(2*a);
                JOptionPane.showMessageDialog(null,"Result\nx1 = " + x1 + "\nx2 = " + x2,"Result",JOptionPane.INFORMATION_MESSAGE);
           }

           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Can't calculate!","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
