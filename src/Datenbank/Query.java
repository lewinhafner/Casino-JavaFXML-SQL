/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author misch
 */
public class Query {
    //Connects jdbc with query
    JDBCConnection jdbc = JDBCConnection.getInstance();
    
    public void ausgabe() throws SQLException, ClassNotFoundException{
        String query = "Select * from users";
        Connection conn = jdbc.createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int columns = rs.getMetaData().getColumnCount();
        for(int i = 1; i<= columns; i++){
            System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));
        }
        System.out.println("");
        System.out.println("------------------------------------------");
        while(rs.next()){
            for(int i = 1; i<= columns; i++){
                System.out.print(String.format("%-15s", rs.getString(i)));
            }
            System.out.println("");
        }
        rs.close();
        stmt.close();
        jdbc.closeConnection();
    }
    public void updateBalance(int id, double konto) throws SQLException, ClassNotFoundException{
       String query = "Update users SET balance = " + konto +"WHERE idU = "+ id; 
       Connection conn = jdbc.createConnection();
       Statement stmt = conn.createStatement();
       stmt.execute(query);
       stmt.close();
       conn.close();
       jdbc.closeConnection();
       ausgabe();
    }
}
