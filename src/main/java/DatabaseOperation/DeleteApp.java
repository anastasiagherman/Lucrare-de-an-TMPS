package DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteApp {

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

    public void delete(String guestName, int roomNr ) {
        String sql = "DELETE FROM guests WHERE guest_name = ? AND room_nr = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        try  {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guestName);
            pstmt.setInt(7, roomNr);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            finallyIf(conn, pstmt);
        }
    }
}
