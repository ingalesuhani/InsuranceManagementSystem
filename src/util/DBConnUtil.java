package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String connStr = DBPropertyUtil.getPropertyString("db.properties");
            conn = DriverManager.getConnection(connStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
