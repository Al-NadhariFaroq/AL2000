package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Session {
    private String url = " jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag ";
    private String user = "isaacchs";
    private String passwd = "33cd69c166";
    private static Connection connect;
    
    public void open(){
        try { 
            connect = DriverManager.getConnection(url, user, passwd); 
        }
        catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }
    
    public static Connection getConnection(){ 
        return connect; 
    }
    
    public void commit() {

    }
    
    public void rollback() {

    }
    
    public void close() {
        try {connect.close(); }
        catch (SQLException e) { e.printStackTrace(); }
    }
}
