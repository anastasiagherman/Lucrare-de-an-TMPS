package DatabaseOperation;

import entity.GuestInfo;
import entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {


    public void insert(GuestInfo guest) {
        String sql = "INSERT INTO guests(guest_id, guest_name, phone_nr, checkin_date, nr_days, checkout_date, room_nr ) VALUES(?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guest.getGuestId());
            pstmt.setString(2, guest.getName());
            pstmt.setString(3, guest.getPhone_nr());
            pstmt.setString(4, guest.getCheckinDate());
            pstmt.setInt(5, guest.getNrDays());
            pstmt.setString(6, guest.getCheckoutDate());
            pstmt.setInt(7, guest.getRoomNr());
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


    public void roomsInsert(Room room) {
        String sql = "INSERT INTO rooms(room_id, room_type, room_price, room_guest, room_status, room_Service, mini_bar) VALUES(?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try  {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, room.getRoomId());
            pstmt.setString(2, room.getRoomType());
            pstmt.setDouble(3, room.getRoomPrice());
            pstmt.setString(4, room.getRoomGuest());
            pstmt.setString(5, room.getRoomStatus());
            pstmt.setString(6, room.getRoomService());
            pstmt.setString(7, room.getMiniBar());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt);
        }
    }


}
