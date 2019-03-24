package utils;

import java.sql.*;

public class SQLHelper {

    static Connection conn;

    public SQLHelper(){
        try {
            setUpConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUpConnection() throws Exception {
        conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }

    public static void closeConnection(){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertRecord(Double price1, Double price2) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("INSERT INTO TESTS(Date, PRICE_Iphone7, PRICE_Iphone7Plus) VALUES(GETDATE(), ?, ?)");
        //prep.setString(1, String.valueOf(date));
        prep.setString(1, String.valueOf(price1));
        prep.setString(2, String.valueOf(price2));
        prep.executeUpdate();
    }

    public static void writePricesToDB(Double price1, Double price2) throws Exception {
        setUpConnection();
        insertRecord(price1,  price2);
        closeConnection();
    }
}
