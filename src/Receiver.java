import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Receiver extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		connectDB obj_connectDB=new connectDB();
		System.out.println(obj_connectDB.get_db());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receiver frame = new Receiver();
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
	public Receiver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Blood_Group:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(77, 32, 92, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(167, 30, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("City:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(290, 32, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(331, 30, 112, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		String[] columns = {"Donor_ID", "Name", "Age", "Sex",
                "Register_Date" , "Blood_Type" , "Blood_Quantity" , "State","City"};

		DefaultTableModel obj=new DefaultTableModel(columns,0);
		
		JTable table = new JTable(obj);
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 62, 964, 367);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obj.setRowCount(0);
				connectDB obj_connectDB=new connectDB();
				Connection con=obj_connectDB.get_db();
				java.sql.Statement st=null;
				String query="Select * from Donor where blood_type='"+textField.getText()+"' and city='"+textField_1.getText()+"'";
				try {
					st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					while(rs.next()!=false) {
						Object[] update2 = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
						obj.addRow(update2);
					}
				}catch(Exception i) {
					System.out.println(i);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(486, 28, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Select obj = new Select();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(885, 32, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
