import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	public JPanel contentPane;
	public JTextField txtEnterUsername;
	public JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Blood Bank Management");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(64, 0, 0));
		lblNewLabel.setBounds(225, 0, 307, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 356, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEnterUsername = new JTextField();
		txtEnterUsername.setBounds(116, 354, 129, 20);
		contentPane.add(txtEnterUsername);
		txtEnterUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setBounds(10, 383, 113, 14);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField(10);
		passwordField.setBounds(116, 381, 129, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] input1 = passwordField.getPassword();
				String input2 = txtEnterUsername.getText();
				if(input1.length!=0 && input2.length()!=0) {
					String query  = "SELECT * from register WHERE username='"+txtEnterUsername.getText()+"' AND Password='"+passwordField.getText()+"'";
					connectDB obj_connectDB=new connectDB();
					Connection con=obj_connectDB.get_db();
					java.sql.Statement st=null;
					try {
						st = con.createStatement();
						ResultSet rs = st.executeQuery(query);
						if(rs.next()!=false) {
							Select obj = new Select();
							obj.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "You are not a registered user.");
						}
					}catch(Exception i) {
						System.out.println(i);
				}}
				else if(input1.length==0 && input2.length()!=0) {
					JOptionPane.showMessageDialog(null, "Enter Password");
				}
				else if(input1.length!=0 && input2.length()==0) {
					JOptionPane.showMessageDialog(null, "Enter Username");
				}
				else {
					JOptionPane.showMessageDialog(null, "Enter Credentials");
				}
				
			}
		});
		btnNewButton.setBounds(381, 356, 104, 32);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				REGISTER obj = new REGISTER();
				obj.setVisible(true);
				dispose();
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnRegister.setBounds(495, 356, 104, 32);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\CHAITANYA RAJU\\eclipse-workspace\\BloodBank\\img\\blood-bank.jpg"));
		lblNewLabel_3.setBounds(0, 0, 984, 440);
		contentPane.add(lblNewLabel_3);
	}
}
