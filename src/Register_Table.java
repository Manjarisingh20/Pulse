import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Register_Table extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Table frame = new Register_Table();
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
	public Register_Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		String[] columns = {"username", "full_name", "email", "sex",
                "date_of_birth" , "password" , "phone_no"};

		DefaultTableModel obj=new DefaultTableModel(columns,0);
        
	    connectDB obj_connectDB=new connectDB();
		Connection con=obj_connectDB.get_db();
		java.sql.Statement st=null;
		String query="Select * from register";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()!=false) {
				Object[] update2 = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
				obj.addRow(update2);
			}
		}catch(Exception i) {
			System.out.println(i);
		}
	    contentPane.setLayout(null);
	    
	    JTable table = new JTable(obj);
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(0, 39, 1135, 363);
		contentPane.add(scrollPane);

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(10, 0, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin obj = new Admin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnNewButton);
	}
}
