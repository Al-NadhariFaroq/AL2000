package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Session {
    private String url = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
    private String user = "alnadhaf";
    private String passwd = "e3d46ebeca";
    private static Connection connect;
    
    public void open(){
        try {
            System.out.print("Connecting to the database with session... ");
            connect = DriverManager.getConnection(url,user,passwd);
            System.out.println("connected");

            connect.setAutoCommit(false);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection(){ 
        return connect; 
    }
    
    public void commit() {
        try {
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void rollback() {
        try {
            connect.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
        try {connect.close(); }
        catch (SQLException e) { e.printStackTrace(); }
    }
}
