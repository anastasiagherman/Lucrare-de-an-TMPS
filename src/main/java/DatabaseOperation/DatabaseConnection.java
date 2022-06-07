package DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection connect() {
        String url = "jdbc:sqlite:C:/Users/Anastasia/DataGripProjects/HotelData/identifier.sqlite";
        try {
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Connection failed", e);
        }
    }

    public static void main(String[] args) {
        Connection conn = connect();
    }

}
