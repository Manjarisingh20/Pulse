import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
    public static void main(String[] args) {
        connectDB obj_connectDB = new connectDB();
        Connection connection = obj_connectDB.get_db();
        // You can perform operations using the connection here
        // Don't forget to close the connection after you're done
        if (connection != null) {
            try {
                connection.close(); // Close the connection when done
                System.out.println("Connection closed.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public Connection get_db() {
        Connection db = null;
        try {
            db = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "@Mdtasfin786");
            if (db != null) {
                System.out.println("Connected!");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for better debugging
        }
        return db; // Return the connection
    }
}

