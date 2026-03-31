import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;


public class Dashboard extends JFrame{

    private JPanel pan_dash;
    private JTable coursetable;
    private JButton enrollButton;
    private JButton logOutButton;
    private DefaultTableModel tableModel;

    public Dashboard() {
    setContentPane(pan_dash);
    setTitle("COURSE OVERVIEW");
    setSize(400,500);
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

      String[] columns = {
          "Courses/Program", "Slots"
      };

      Object[][] data = {
              {"BACHELOR OF SCIENCE IN INFORMATION OF TECHNOLOGY", 100},
              {"BACHELOR OF SCIENCE IN CIVIL ENGINEERING", 100},
              {"BACHELOR OF SCIENCE IN HOSPITALITY AND MANAGEMENT", 100},
              {"BACHELOR OF SCIENCE IN BIOLOGY", 100},
              {"BACHELOR OF SCIENCE IN BUSINESS ADMINISTRATION" ,100},
              {"BACHELOR OF SCIENCE IN COMPUTER ENGINEERING", 100},
              {"BACHELOR OF SCIENCE IN ELECTRICAL ENGINEERING", 100},
              {"BACHELOR OF SCIENCE IN MECHANICAL ENGINEERING", 100},
              {"BACHELOR OF SCIENCE IN MARINE ENGINEERING", 100},
              {"BACHELOR OF ARTS IN POLITICAL SCIENCE", 100},
              {"BACHELOR OF ARTS IN ENGLISH LANGUAGE", 100},

      };
      tableModel = new DefaultTableModel(data, columns);
      coursetable.setModel(tableModel);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        coursetable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);




        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new ENROLL().setVisible(true);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int out = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure to log-out?",
                        "Log-out",
                        JOptionPane.YES_NO_OPTION
                );
                if (out == JOptionPane.YES_NO_OPTION){
                    new LOGIN().setVisible(true);
                    dispose();
                }

            }
        });

    }



public static void main (String[] args){
        new Dashboard();
}
}
