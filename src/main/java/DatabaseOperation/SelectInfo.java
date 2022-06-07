package DatabaseOperation;

import java.sql.*;

public class SelectInfo {


    public void selectRooms(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM rooms";

        try {
             conn = DatabaseConnection.connect();
             stmt = conn.createStatement();
             rs = stmt.executeQuery(sql);


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
        } finally{
            finallyIf(conn,stmt,rs);
        }
    }

    public void selectSpecificRoom(int roomNr){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM rooms WHERE room_id = roomNr";

        try {
            conn = DatabaseConnection.connect();
            stmt  = conn.createStatement();
            rs    = stmt.executeQuery(sql);

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
        } finally {
            finallyIf(conn, stmt, rs);
        }
    }

    private void finallyIf(Connection conn, Statement stmt, ResultSet rs) {
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
