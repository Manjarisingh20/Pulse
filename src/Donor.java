import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Donor extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_3;
    private JTextField textField_9;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Donor frame = new Donor();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Donor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window to full screen or maximized
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Dynamically get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Labels and text fields adjusted based on screen size
        JLabel lblNewLabel_11 = new JLabel("PHONE NUMBER:");
        lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_11.setBounds((int) (width * 0.25), (int) (height * 0.52), 116, 14);
        contentPane.add(lblNewLabel_11);

        textField_9 = new JTextField();
        textField_9.setBounds((int) (width * 0.35), (int) (height * 0.52), 167, 20);
        contentPane.add(textField_9);
        textField_9.setColumns(10);

        JLabel lblNewLabel = new JLabel("DONOR_ID:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel.setBounds((int) (width * 0.25), (int) (height * 0.2), 101, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds((int) (width * 0.35), (int) (height * 0.2), 167, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("NAME:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1.setBounds((int) (width * 0.25), (int) (height * 0.25), 60, 14);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds((int) (width * 0.35), (int) (height * 0.25), 167, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("AGE:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_2.setBounds((int) (width * 0.25), (int) (height * 0.3), 33, 14);
        contentPane.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds((int) (width * 0.35), (int) (height * 0.3), 167, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("SEX:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_3.setBounds((int) (width * 0.25), (int) (height * 0.35), 33, 14);
        contentPane.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setBounds((int) (width * 0.35), (int) (height * 0.35), 168, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("REGISTER_DATE:");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_4.setBounds((int) (width * 0.25), (int) (height * 0.4), 116, 14);
        contentPane.add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setBounds((int) (width * 0.35), (int) (height * 0.4), 167, 20);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("BLOOD_TYPE:");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5.setBounds((int) (width * 0.25), (int) (height * 0.45), 101, 14);
        contentPane.add(lblNewLabel_5);

        textField_5 = new JTextField();
        textField_5.setBounds((int) (width * 0.35), (int) (height * 0.45), 167, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("BLOOD QUANTITY:");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_6.setBounds((int) (width * 0.25), (int) (height * 0.5), 130, 14);
        contentPane.add(lblNewLabel_6);

        textField_6 = new JTextField();
        textField_6.setBounds((int) (width * 0.35), (int) (height * 0.5), 167, 20);
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("STATE:");
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_7.setBounds((int) (width * 0.25), (int) (height * 0.55), 47, 14);
        contentPane.add(lblNewLabel_7);

        textField_7 = new JTextField();
        textField_7.setBounds((int) (width * 0.35), (int) (height * 0.55), 167, 20);
        contentPane.add(textField_7);
        textField_7.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("CITY:");
        lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_9.setBounds((int) (width * 0.25), (int) (height * 0.6), 46, 14);
        contentPane.add(lblNewLabel_9);

        textField_8 = new JTextField();
        textField_8.setBounds((int) (width * 0.35), (int) (height * 0.6), 167, 20);
        contentPane.add(textField_8);
        textField_8.setColumns(10);

        JButton btnNewButton = new JButton("SUBMIT");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().length() != 0 && textField_1.getText().length() != 0 && textField_2.getText().length() != 0 && textField_3.getText().length() != 0 &&
                    textField_4.getText().length() != 0 && textField_5.getText().length() != 0 && textField_6.getText().length() != 0 && textField_9.getText().length() != 0 && textField_7.getText().length() != 0 &&
                    textField_8.getText().length() != 0) {
                    Donor1 obj = new Donor1();
                    obj.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Enter all Credentials!!");
                }

                connectDB obj_connectDB = new connectDB();
                Connection con = obj_connectDB.get_db();
                java.sql.Statement st = null;
                String query = "INSERT INTO Donor values('" + textField.getText() + "','" + textField_1.getText() + "'," + textField_2.getText() + ",'" + textField_3.getText() + "','" + textField_4.getText()
                        + "','" + textField_5.getText() + "'," + textField_6.getText() + "," + textField_9.getText() + ",'" + textField_7.getText() + "','" + textField_8.getText() + "')";
                try {
                    st = con.createStatement();
                    System.out.println(st.executeQuery(query));
                } catch (Exception i) {
                    System.out.println(i);
                }
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.setBounds((int) (width * 0.35), (int) (height * 0.7), 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("BACK");
        
        btnNewButton_1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                Select obj = new Select();
                obj.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setBounds(1800, 45, 89, 45);
        contentPane.add(btnNewButton_1);

        // Load the background image and scale it to fit the screen size
        ImageIcon originalIcon = new ImageIcon("C:\\G\\APP project\\BloodbankFinal\\BloodBank\\img\\donordetails.jpg");
        Image img = originalIcon.getImage();
        Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lblNewLabel_10 = new JLabel("");
        lblNewLabel_10.setIcon(scaledIcon);
        lblNewLabel_10.setBounds(0, 0, width, height);
        contentPane.add(lblNewLabel_10);

        // Move the background image to the back
        contentPane.setComponentZOrder(lblNewLabel_10, contentPane.getComponentCount() - 1);
    }
}
