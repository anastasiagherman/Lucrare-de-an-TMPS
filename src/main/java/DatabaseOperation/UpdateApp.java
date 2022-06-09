package DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateApp {

    public void addRoomService(int roomNr, String rsStatus) {
        String sql = "UPDATE rooms SET room_service = ?  WHERE room_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(2, rsStatus);
            pstmt.setInt(1, roomNr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt);
        }

    }


    public void addMiniBar(String mbStatus, int roomNr){
        String sql = "UPDATE rooms SET mini_bar = ? WHERE room_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mbStatus);
            pstmt.setInt(2, roomNr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt);
        }
    }

    public void updateRoomStatusEmpty(String status, int roomNr){
        String sql = "UPDATE rooms SET  room_status= ? WHERE room_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(2, status);
            pstmt.setInt(1, roomNr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt);
        }

    }
    public void updateRoomStatusOccupied(String roomSt, int roomNr, String gstName){
        String sql = "UPDATE rooms SET  room_status= ?, room_guest = ? WHERE room_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, roomSt);
            pstmt.setInt(2, roomNr);
            pstmt.setString(3, gstName);
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
