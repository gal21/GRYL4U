package Model;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_create {

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:C:/sqlite/" + fileName;

       // String url = " C:\\Users\\Yehuda Pashay\\Desktop\\שנה ג'\\project\\databases" + fileName;

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
        String url = "jdbc:sqlite:C://sqlite/SSSIT.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + " name text PRIMARY KEY,\n"
                + " password text  NOT NULL,\n"
                + "first_name text NOT NULL,\n "
                + "secound_name text NOT NULL,\n "
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
        String url = "jdbc:sqlite:C://sqlite/SSSIT.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insert(String user_name,String password, String first_name,String secound_name,String city) {
       // String sql = "INSERT INTO Users(user_name,password, first_name, secound_name, city) VALUES(user_name,password, first_name,secound_name,city)";
        String sql = "INSERT INTO Users(user_name,password, first_name, secound_name, city) VALUES(?,?, ?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_name);
            pstmt.setString(2, password);
            pstmt.setString(3, first_name);
            pstmt.setString(4, secound_name);
            pstmt.setString(5, city);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT user_name,password, first_name, secound_name, city "+"" +
                "FROM Users WHERE user_name =yehudaPash";


        // String sql = "SELECT id, name, capacity "
        //                          + "FROM warehouses WHERE capacity > ?";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("user_name") +  "\t" +
                        rs.getString("password") + "\t" +
                        rs.getDouble("first_name")+  "\t" +
                        rs.getString("secound_name")+  "\t" +
                        rs.getString("city"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String field) {
        String sql = "DELETE FROM Users WHERE user_name = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, field);
            // execute the delete statement
            pstmt.executeUpdate();


        }

            catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update( int updateNumData,String previousData, String updateData) {
        //String sql = "UPDATE users WHERE user_name = ronEl";
        String sql = "UPDATE users WHERE user_name = ronEl";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, updateData);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //update_secound_try(int id, String name, double capacity)
    public void update_secound_try() {
        String sql = "UPDATE Users SET password = ? ,"
        +"WHERE user_name = ? ";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
           // pstmt.setString(1, "ronEl");
            pstmt.setString(2, "newpass");
            //pstmt.setString(3, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        //createNewDatabase("SSSIT.db");
       // createNewTable("Users");
       // createNewTable("Flight");
        //sql_create app = new sql_create();
        //app.selectAll();
        sql_create app = new sql_create();
        // insert three new rows
      //  app.insert("ronEl", "bgu3u","ron", "elharar","ashdod");
      //  app.insert("galLah", "bgu4u","gal", "lahiani","beer-sheva");
      //  app.insert("liorPiz", "bgu5u","lior", "pizman","gan-yavne");
      //  app.insert("yehudaPash", "bgu2u","yehuda", "pashay","ashdod");
       // app.selectAll();
        //app.delete("ronEl");
        //app.update(3, "ronEl","ronAFterChange");
        app.update_secound_try();
    }
}