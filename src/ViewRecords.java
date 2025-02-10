import java.awt.Dimension;
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
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewRecords extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRecords frame = new ViewRecords();
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
	public ViewRecords() {
		// Set window to full screen or maximized
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Get the screen size dynamically
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Define table columns
		String[] columns = { "Donor_ID", "Name", "Age", "Sex", "Register_Date", "Blood_Type", "Blood_Quantity",
				"Phone_Number", "State", "City" };

		DefaultTableModel model = new DefaultTableModel(columns, 0);

		// Database connection and query
		connectDB obj_connectDB = new connectDB();
		Connection con = obj_connectDB.get_db();
		java.sql.Statement st = null;
		String query = "SELECT * FROM Donor";

		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Object[] update2 = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10) };
				model.addRow(update2);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Create table with data from DB
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		// Dynamically set table bounds to take most of the screen size
		scrollPane.setBounds(0, (int) (height * 0.1), (int) (width * 0.98), (int) (height * 0.75));
		contentPane.add(scrollPane);

		// Back button
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds((int) (width * 0.01), (int) (height * 0.02), 100, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin obj = new Admin();
				obj.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
	}
}
