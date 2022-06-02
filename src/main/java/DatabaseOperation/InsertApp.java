package DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {
    private Connection connect() {
        String url = "jdbc:sqlite:identifier.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the guests table
     *
     * @param guest_id
     * @param guest_name
     * @param phone_nr
     * @param checkin_date
     * @param nr_days
     * @param checkout_date
     * @param room_nr
     */
    public void insert(int guest_id,String guest_name, String phone_nr, String checkin_date, int nr_days, String checkout_date, int room_nr) {
        String sql = "INSERT INTO guests(guest_id, guest_name, phone_nr, checkin_date, nr_days, checkout_date, room_nr) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,guest_id);
            pstmt.setString(2, guest_name);
            pstmt.setString(3, phone_nr);
            pstmt.setString(4, checkin_date);
            pstmt.setInt(5, nr_days);
            pstmt.setString(6, checkout_date);
            pstmt.setInt(7, room_nr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */

    /**
     * Insert a new row into the rooms table
     *
     * @param room_id
     * @param room_type
     * @param phone_nr
     * @param checkin_date
     * @param nr_days
     * @param checkout_date
     * @param room_nr
     */
    public void roomsInsert(int room_id,String room_type, String phone_nr, String checkin_date, int nr_days, String checkout_date, int room_nr) {
        String sql = "INSERT INTO rooms(room_nr, room_type, phone_nr, checkin_date, nr_days, checkout_date, room_nr) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,room_id);
            pstmt.setString(2, room_type);
            pstmt.setString(3, phone_nr);
            pstmt.setString(4, checkin_date);
            pstmt.setInt(5, nr_days);
            pstmt.setString(6, checkout_date);
            pstmt.setInt(7, room_nr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */

}
