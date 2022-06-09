package DatabaseOperation;

import entity.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectInfo {


    public List<Room> selectRooms(String sql) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Room> rooms = new ArrayList<Room>();

        try {
            conn = DatabaseConnection.connect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setRoomId((rs.getInt("room_id")));
                room.setRoomType(rs.getString("room_type"));
                room.setRoomPrice(rs.getDouble("room_price"));
                room.setRoomGuest(rs.getString("room_guest"));
                room.setRoomStatus(rs.getString("room_status"));
                room.setRoomService(rs.getString("room_service"));
                room.setMiniBar(rs.getString("mini_bar"));
                room.setSqm(rs.getInt("sqm"));
                rooms.add(room);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            finallyIf(conn, pstmt, rs);
        }
        return rooms;
    }


    public Room selectSpecificRoom(int roomNr) {
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM rooms WHERE room_id = ?";
        PreparedStatement pstmt = null;
        Room room = new Room();

        try {
            conn = DatabaseConnection.connect();

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomNr);
            rs = pstmt.executeQuery();

            // loop through the result set
            room.setRoomId(rs.getInt("room_id"));
            room.setRoomType(rs.getString("room_type"));
            room.setRoomPrice(rs.getDouble("room_price"));
            room.setRoomGuest(rs.getString("room_guest"));room.setRoomStatus(rs.getString("room_status"));
            room.setRoomService(rs.getString("room_service"));
            room.setMiniBar(rs.getString("miniBar"));
            room.setSqm(rs.getInt("sqm"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt, rs);
        }
        return room;
    }

    public Room selectRoomByName(String gstName) {
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM rooms WHERE room_guest = ?";
        PreparedStatement pstmt = null;
        Room room = new Room();

        try {
            conn = DatabaseConnection.connect();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, gstName);
            rs = pstmt.executeQuery();

            // loop through the result set
            room.setRoomId(rs.getInt("room_id"));
            room.setRoomType(rs.getString("room_type"));
            room.setRoomPrice(rs.getDouble("room_price"));
            room.setRoomGuest(rs.getString("room_guest"));
            room.setRoomStatus(rs.getString("room_status"));
            room.setRoomService(rs.getString("room_service"));
            room.setMiniBar(rs.getString("miniBar"));
            room.setSqm(rs.getInt("sqm"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            finallyIf(conn, pstmt, rs);
        }
        return room;
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
