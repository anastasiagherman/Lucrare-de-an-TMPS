package DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateApp {
    private Connection connect() {
        String url = "jdbc:sqlite:hotel.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addRoomService(int roomNr){
        String sql = "UPDATE rooms SET room_service = 'Included' WHERE room_id = roomNR";
    }

    public void addMiniBar(int roomNr){
        String sql = "UPDATE rooms SET miniBar = 'Included' WHERE room_id = roomNR";
    }
}
