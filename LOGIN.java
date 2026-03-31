import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGIN extends JFrame {
    private JPanel pan_log;
    private JTextField gm;
    private JPasswordField pass;
    private JTextField fn;
    private JTextField ln;
    private JButton confirmButton;
    private JPanel pan_prog;
    private JButton button1;


    public LOGIN() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("LOG-IN");
        setLocationRelativeTo(null);
        setContentPane(pan_log);
        setSize(480, 270);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String GM = gm.getText();
                String PS = new String(pass.getPassword());
                String FN = fn.getText();
                String LN = ln.getText();


                    if (FN.isEmpty() || LN.isEmpty() || GM.isEmpty() || GM.contentEquals("@gmail.com") || PS.isEmpty()) {
                        JOptionPane.showMessageDialog(LOGIN.this, "Please fill all the information needed!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                JOptionPane.showMessageDialog(LOGIN.this, "Welcome! " + FN + " " + LN);

                int OK = JOptionPane.showConfirmDialog(LOGIN.this, "Click YES to proceed to the Dashboard ", "Procedure",JOptionPane.YES_NO_OPTION);
                if (OK == JOptionPane.YES_OPTION){

                dispose();
                new Dashboard();

                } else if (OK == JOptionPane.NO_OPTION) {

                    dispose();
                JOptionPane.showMessageDialog(LOGIN.this,"Log-in cancelled!");
                new LOGIN().setVisible(true);
                }
            }
        });
    }

        public static void main(String[] args) {
            new LOGIN();
    }
}



