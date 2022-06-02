package DatabaseOperation;

import Entity.GuestInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GuestDB {
    Connection conn = DatabaseConnection.connect();
    PreparedStatement statement = null;
    ResultSet result = null;

    public void insertCustomer(GuestInfo user) {
        try {
            String insertQuery = "insert into userInfo('name','phone') values('" + user.getName() + "','"  + "','" + user.getPhone_nr() + "','" + "')";
            this.statement = this.conn.prepareStatement(insertQuery);
            this.statement.execute();
        } catch (SQLException var) {
            System.out.println(var.getMessage());
        }

    }


    public void checkOutGuest(){

    }

    public void checkInGuest(){

    }
}
