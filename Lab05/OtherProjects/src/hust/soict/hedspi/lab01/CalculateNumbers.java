package hust.soict.hedspi.lab01;
// Example 5: 2.2.5
import javax.swing.JOptionPane;
public class CalculateNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        Double num1,num2;
        
        try {
            strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
            num1 = Double.parseDouble(strNum1);

            strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
            num2 = Double.parseDouble(strNum2);

            JOptionPane.showMessageDialog(null, "Sum: " + (num1 + num2) + "\nDifference: " + (num1 - num2) + "\nProduct: " + (num1 * num2) + "\nQuotient: " + (num1 / num2) , "Show Calculate numbers", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Please input number", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
}   