import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ENROLL extends JFrame {
    private JPanel pan_enr;
    private JTextField fn;
    private JTextField mn;
    private JTextField ln;
    private JComboBox m;
    private JComboBox g;
    private JComboBox yr;
    private JTextField sa;
    private JTextField sal;
    private JTextField sp;
    private JTextField pz;
    private JTextField sea;
    private JTextField cn;
    private JComboBox pc;
    private JButton submitApplicationButton;
    private JComboBox d;
    private JTextField c;

    public ENROLL() {
        setVisible(true);
        setTitle("FILL OUT FORM");
        setContentPane(pan_enr);
        setSize(740, 840);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        if (datastorage.getInstance().Confirmation.isEmpty()) {
            Object[][] data = {
                    {"BACHELOR OF SCIENCE IN INFORMATION OF TECHNOLOGY", 100, ""},
                    {"BACHELOR OF SCIENCE IN CIVIL ENGINEERING", 100, ""},
                    {"BACHELOR OF SCIENCE IN HOSPITALITY AND MANAGEMENT", 100, ""},
                    {"BACHELOR OF SCIENCE IN BIOLOGY", 100, ""},
                    {"BACHELOR OF SCIENCE IN BUSINESS ADMINISTRATION", 100, ""},
                    {"BACHELOR OF SCIENCE IN COMPUTER ENGINEERING", 100, ""},
                    {"BACHELOR OF SCIENCE IN ELECTRICAL ENGINEERING", 100, ""},
                    {"BACHELOR OF SCIENCE IN MECHANICAL ENGINEERING", 100, ""},
                    {"BACHELOR OF SCIENCE IN MARINE ENGINEERING", 100, ""},
                    {"BACHELOR OF ARTS IN POLITICAL SCIENCE", 100, ""},
                    {"BACHELOR OF ARTS IN ENGLISH LANGUAGE", 100, ""},
            };
            for (Object[] row : data) {
                datastorage.getInstance().Confirmation.add(row);
            }
        }

        submitApplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String FN = fn.getText();
                String MN = mn.getText();
                String LN = ln.getText();
                String M  = (String) m.getSelectedItem();
                String G  = (String) g.getSelectedItem();
                String YR = (String) yr.getSelectedItem();
                String SA = sa.getText();
                String SAL = sal.getText();
                String SP = sp.getText();
                String PZ = pz.getText();
                String SEA = sea.getText();
                String CN = cn.getText();
                String PC = (String) pc.getSelectedItem();
                String D  = (String) d.getSelectedItem();
                String C  = c.getText();


                if (M.contentEquals("MONTH:") || G.contentEquals("SELECT GENDER:") ||
                        FN.isEmpty() || MN.isEmpty() || LN.isEmpty() ||
                        YR.contentEquals("YEAR:") || SA.isEmpty() || SAL.isEmpty() ||
                        SP.isEmpty() || PZ.isEmpty() || SEA.isEmpty() ||
                        CN.isEmpty() || PC.contentEquals("SELECT PROGRAM:") ||
                        D.contentEquals("DAY:") || C.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please fill out all fields!",
                            "Incomplete Form",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }


                int OK = JOptionPane.showConfirmDialog(ENROLL.this,
                        "First Name: " + FN +
                                "\nMiddle Name: " + MN +
                                "\nLast Name: " + LN +
                                "\nBirth Date: " + M +
                                " " + D +
                                ", " + YR +
                                "\nGender: " + G +
                                "\nStreet Address: " + SA +
                                "\nStreet Address Line 2: " + SAL +
                                "\nCity: " + C +
                                "\nState/Province: " + SP +
                                "\nPostal/Zip Code: " + PZ +
                                "\nStudent E-mail Address: " + SEA +
                                "\nContact Number: " + CN +
                                "\nProgram/Courses: " + PC,
                        "", JOptionPane.YES_NO_OPTION);


                if (OK != JOptionPane.YES_OPTION) return;

                boolean slotFound = false;
                for (Object[] Certified : datastorage.getInstance().Confirmation) {

                    if (PC.equalsIgnoreCase((String) Certified[0])) {
                        int slot = (int) Certified[1];
                        if (slot > 0) {
                            Certified[1] = slot - 1;
                            Certified[2] = "✓";
                            slotFound = true;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "No slots available!",
                                    "Slots Full",
                                    JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        break;
                    }
                }

                if (slotFound) {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Done Enrolling!");
                    new Confirmation();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Program not found!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new ENROLL();
    }
}