package DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateApp {

    public void addRoomService(int roomNr) {
        String sql = "UPDATE rooms SET room_service = ?,"+" WHERE room_id = roomNR";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(6, "Included");
            pstmt.setInt(1, roomNr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt);
        }

    }


    public void addMiniBar(int roomNr){
        String sql = "UPDATE rooms SET miniBar = ?," +" WHERE room_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(7, "Included");
            pstmt.setInt(1, roomNr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt);
        }
    }

    public void updateRoomStatusEmpty(int roomNr){
        String sql = "UPDATE rooms SET  room_status= ?," +" WHERE room_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(5, "Empty");
            pstmt.setInt(1, roomNr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt);
        }

    }
    public void updateRoomStatusOccupied(int roomNr){
        String sql = "UPDATE rooms SET  room_status= ?," +" WHERE room_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(5, "Occupied");
            pstmt.setInt(1, roomNr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt);
        }

    }

    private void finallyIf(Connection conn, PreparedStatement pstmt) {
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
