package DatabaseOperation;

import composite.Apartment;
import entity.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectApartmentInfo {


    public List<Apartment> selectApartments() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Apartment> apartments = new ArrayList<>();


        String sql = "SELECT * FROM apartments";

        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Apartment apartment = new Apartment();
                apartment.setApartmentId((rs.getInt("apartment_id")));
                apartment.setApartmentPrice(rs.getDouble("apartment_price"));
                apartment.setApartmentGuest(rs.getString("apartment_guest"));
                apartment.setRoomService(rs.getString("room_service"));
                apartment.setMiniBar(rs.getString("mini_bar"));
                apartment.setAptStatus(rs.getString("apt_status"));
                apartments.add(apartment);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            finallyIf(conn, pstmt, rs);
        }
        return apartments;
    }
    public Apartment selectApartmentByName(String gstName) {
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM rooms WHERE apartment_guest = ?";
        PreparedStatement pstmt = null;
        Apartment apartment = new Apartment();

        try {
            conn = DatabaseConnection.connect();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, gstName);
            rs = pstmt.executeQuery();

            // loop through the result set
            apartment.setApartmentId(rs.getInt("apartment_id"));
            apartment.setApartmentPrice(rs.getDouble("apartment_price"));
            apartment.setApartmentGuest(rs.getString("apartment_guest"));
            apartment.setRoomService(rs.getString("room_service"));
            apartment.setMiniBar(rs.getString("miniBar"));
            apartment.setAptStatus(rs.getString("apt_status"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt, rs);
        }
        return apartment;
    }


    public void selectSpecificRoom(int roomNr) {
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM rooms WHERE room_id = ?";
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.connect();

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomNr);
            rs = pstmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("room_id") + "\t" +
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
            finallyIf(conn, pstmt, rs);
        }
    }

    private void finallyIf(Connection conn, Statement stmt, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
