package DatabaseOperation;

import java.sql.*;

public class SelectInfo {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:hotel.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the warehouses table
     */
    public void selectRooms(){
        String sql = "SELECT * FROM rooms";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("room_id") +  "\t" +
                        rs.getString("room_type") + "\t" +
                        rs.getDouble("room_price") + "\t" +
                        rs.getString("room_guest") + "\t" +
                        rs.getString("room_status") + "\t" +
                        rs.getString("room_service") + "\t" +
                        rs.getString("miniBar"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectSpecificRoom(int roomNr){
        String sql = "SELECT * FROM rooms WHERE room_id = roomNr";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("room_id") +  "\t" +
                        rs.getString("room_type") + "\t" +
                        rs.getDouble("room_price") + "\t" +
                        rs.getString("room_guest") + "\t" +
                        rs.getString("room_status") + "\t" +
                        rs.getString("room_service") + "\t" +
                        rs.getString("miniBar"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * @param args the command line arguments
     */
}
