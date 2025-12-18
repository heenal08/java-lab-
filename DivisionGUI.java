import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DivisionGUI extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton divideBtn;

    DivisionGUI() {

        // Set layout
        setLayout(new GridLayout(4, 2, 10, 10));

        // Labels
        add(new JLabel("Num1:"));
        t1 = new JTextField();
        add(t1);

        add(new JLabel("Num2:"));
        t2 = new JTextField();
        add(t2);

        add(new JLabel("Result:"));
        t3 = new JTextField();
        t3.setEditable(false);
        add(t3);

        divideBtn = new JButton("Divide");
        add(divideBtn);

        divideBtn.addActionListener(this);

        setTitle("Integer Division");
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int result = num1 / num2;
            t3.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid integers!",
                    "Number Format Exception",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Cannot divide by zero!",
                    "Arithmetic Exception",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new DivisionGUI();
    }
}
