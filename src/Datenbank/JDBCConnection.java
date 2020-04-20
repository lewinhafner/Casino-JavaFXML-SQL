/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author misch
 */
public class JDBCConnection {
    private static JDBCConnection instance= null;
    private final String USERNAME= "root";
    private final String PASSWORD= "";
    private final String DB_CONNECTION_STRING="jdbc:mysql://localhost/Casino_Millenaire";
    private final String DRIVER= "com.mysql.jdbc.Driver";
    private Connection cn= null;
    private JDBCConnection(){
       
    }
   
    public static JDBCConnection getInstance(){
        if(instance==null){
            instance= new JDBCConnection();
        }
        return instance;
    }
   
    public Connection createConnection() throws SQLException, ClassNotFoundException{
        if(cn==null){
            Class.forName(DRIVER);
            cn= (Connection) DriverManager.getConnection(DB_CONNECTION_STRING,USERNAME,PASSWORD);           
        }
        return cn;
    }
    public void closeConnection() throws SQLException{
        cn.close();
        cn= null;
    }
}
