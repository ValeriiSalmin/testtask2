package utils;

import java.sql.*;

public class SQLHelper {

    Connection conn;

    public void setUpConnection() throws Exception {
        conn = DriverManager.
                getConnection("jdbc:h2:~/test", "sa", "");
    }

    public void closeConnection() throws Exception {
        if (conn != null) { conn.close();
        }
    }

    public void insertRecord(Date date, Double price1, Double price2) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("INSERT INTO TESTS(Date, Price1, Price2) VALUES(?, ?, ?)");
        prep.setString(1, String.valueOf(date));
        prep.setString(2, String.valueOf(price1));
        prep.setString(3, String.valueOf(price2));
        prep.executeUpdate();
    }

    public void writePricesToDB(Date date, Double price1, Double price2) throws Exception {
        setUpConnection();
        insertRecord(date, price1,  price2);
        closeConnection();
    }
}
