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

    public void delete(String guest_name) {
        String sql = "DELETE FROM guests WHERE guest_name = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try  {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guest_name);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            finallyIf(conn, pstmt);
        }
    }
}
