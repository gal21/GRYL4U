package Model;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_create {

    public static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:C:\\Program Files\\sqlite" + fileName;
        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable(String tableName) {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\Lior\\Desktop\\current semester\\Information resources management\\Exercises\\ex1\\Vacation4U\\SSSIT.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + " name text PRIMARY KEY,\n"
                + " password text  NOT NULL,\n"
                + "first_name text NOT NULL,\n "
                + "last_name text NOT NULL,\n "
                + "city text NOT NULL,\n "
                + ");";
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\Lior\\Desktop\\current semester\\Information resources management\\Exercises\\ex1\\Vacation4U\\SSSIT.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insert(String user_name,String password, String first_name,String last_name,String city,String date) {
        String sql = "INSERT INTO Users(user_name,password, first_name, last_name, city,date) VALUES(?,?, ?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_name);
            pstmt.setString(2, password);
            pstmt.setString(3, first_name);
            pstmt.setString(4, last_name);
            pstmt.setString(5, city);
            pstmt.setString(6, date);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String userToDelete) {
        String sql = "DELETE FROM Users WHERE user_name = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, userToDelete);
            // execute the delete statement
            pstmt.executeUpdate();
        }
            catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(String user_name, String field, String newData){
        String sql = "UPDATE Users SET "+ field +" = ? WHERE user_name = ? ";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param [ instead of question marks (?) ]
            pstmt.setString(2, user_name);
            pstmt.setString(1, newData);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void find_specific_record(String userName) {
        String sql = "SELECT user_name, password, first_name, last_name, city,date "
                + "FROM Users WHERE user_name = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, userName);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("user_name") + "\t" +
                        rs.getString("password") + "\t" +
                        rs.getString("first_name") + "\t" +
                        rs.getString("last_name") + "\t" +
                        rs.getString("city")+ "\t" +
                        rs.getString("date")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public User find_User_Exists(String userName) {
        String sql = "SELECT user_name, password, first_name, last_name, city,date "
                + "FROM Users WHERE user_name = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, userName);
            //
            ResultSet rs = pstmt.executeQuery();
            // loop through the result set

            while (rs.next()) {
                return new User(rs.getString("user_name"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("city"),
                        rs.getString("date")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }


    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        //createNewDatabase("SSSIT.db");
        //createNewTable("Users");
        //createNewTable("Flight");
        //sql_create app = new sql_create();
        //app.selectAll();
        sql_create app = new sql_create();
        //insert three new rows
        //app.insert("moshiko", "bgu7u","mor", "dani","tel-aviv","01/01/2004");
        //app.insert("galLah", "bgu4u","gal", "lahiani","beer-sheva");
        //app.insert("liorPiz", "bgu5u","lior", "pizman","gan-yavne");
        //app.insert("yehudaPash", "bgu2u","yehuda", "pashay","ashdod");
        //app.selectAll();
        //app.delete("ronEl");
        //app.update("moshiko","first_name","yoniB");//,"bo");
        //app.update_second_try();
        //app.find_specific_record("moshiko");
    }
}