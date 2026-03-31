import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class Confirmation extends JFrame {
    private JPanel pan_dash;
    private JTable coursetable;
    private JButton doneButton;
    private JScrollPane tabs;
    private DefaultTableModel tableModel;

    public Confirmation() {
        setVisible(true);
        setTitle("COURSE OVERVIEW");
        setContentPane(pan_dash);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] columns = {
                "Courses/Program", "Slots", "Registered"
        };

        // ✅ Load data directly from datastorage
        Object[][] data = datastorage.getInstance().Confirmation
                .toArray(new Object[0][]);

        tableModel = new DefaultTableModel(data, columns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        coursetable.setModel(tableModel);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        coursetable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        coursetable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(Confirmation.this,
                        "YOU HAVE BEEN REGISTERED!");
            }
        });
    }
    public static void main(String[] args) {
        new Confirmation();
    }
}
