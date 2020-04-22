/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenbank;

import ch.bbbaden.casino.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author misch
 */
public class Query {
    //Connects jdbc with query
    JDBCConnection jdbc = JDBCConnection.getInstance();
    ArrayList<User> users = new ArrayList<>();
     public void updateUser() throws SQLException, ClassNotFoundException {
        int id = 0;
        String username = "";
        String email = "";
        String password = "";
        String surname = "";
        String forename = "";
        double balance = 0;
        int age = 0;
        String role = "Player";

        Connection conn = jdbc.createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from users");
        
        //User array wir gebildet, dass man nachher mit dem arbeiten kann
        while(rs.next()){
            id = rs.getInt(1);
            username = rs.getString(2);
            forename = rs.getString(3);
            surname = rs.getString(4);
            password = rs.getString(5);
            email = rs.getString(6);
            balance = rs.getDouble(7);
            age = rs.getInt(8);
            role = rs.getString(9);
            
            users.add(new User (id,username,forename,surname,password,balance,email,role,age));
        }
        rs.close();
        stmt.close();
        conn.close();
        jdbc.closeConnection();
    }
   
    public void updateBalance(int id, double konto) throws SQLException, ClassNotFoundException{
        //balance vom spieler wird upgadetet
       String query = "Update users SET balance = " + konto +"WHERE idU = "+ id; 
       Connection conn = jdbc.createConnection();
       Statement stmt = conn.createStatement();
       stmt.execute(query);
       stmt.close();
       conn.close();
       jdbc.closeConnection();
    }
    public void updateStatistics(int uId, int gId,double bet,String result,double changes) throws SQLException, ClassNotFoundException{
        //Statistcs wird upgedated
        String query = "Insert Into statistics (`usersId`,`gameId`,`bet`, `results`,`changes`) values('"+ uId+"','"+gId+"','"+bet+"','"+result+"','"+changes+"')";
        Connection conn = jdbc.createConnection();
        Statement stmt = conn.createStatement();
        stmt.execute(query);
        stmt.close();
        conn.close();
        jdbc.closeConnection();
    }
    
    public void createUser (String username, String forename,String surname,String password,String email,int age) throws SQLException, ClassNotFoundException{
        //User erstellen
        String query = "Insert Into users (`username`,`forename`,`surname`, `password`,`email`,`balance`,`age`, `role`) values (?,?,?,?,?,'0',?,'player')";
        Connection conn = jdbc.createConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, forename);
        ps.setString(3, surname);
        ps.setString(4, password);
        ps.setString(5, email);
        ps.setInt(6, age);
        ps.execute();
        ps.close();
        conn.close();
        jdbc.closeConnection();
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }
    public ArrayList<String> getUsersStats(String user) throws SQLException, ClassNotFoundException{
        //Stats der Spieler für die Adminsicht ausgeben
        ArrayList<String> ausgabe = new ArrayList<>();
        String query = "Select g.gameName, s.bet, s.results, s.changes from statistics s, game g, users u where idG = gameID AND usersID = idU AND username = '"+user+"'";
        Connection conn = jdbc.createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int columns = rs.getMetaData().getColumnCount();
         while(rs.next()){
             String eingabe = "";
            for(int i = 1; i<= columns; i++){
                eingabe += String.format("%-15s", rs.getString(i));
            }
            ausgabe.add(eingabe);
        }
        rs.close();
        stmt.close();
        jdbc.closeConnection();
        return ausgabe;
    }
    public ArrayList<String> getSpielStats(String game) throws SQLException, ClassNotFoundException{
        //Stats des Spiels für die Adminsicht ausgeben
         ArrayList<String> ausgabe = new ArrayList<>();
        String query = "Select u.username, s.bet, s.results, s.changes from statistics s, game g, users u where idG = gameID AND usersID = idU AND gameName = '"+game+"'";
        Connection conn = jdbc.createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int columns = rs.getMetaData().getColumnCount();
         while(rs.next()){
             String eingabe = "";
            for(int i = 1; i<= columns; i++){
                eingabe += String.format("%-15s", rs.getString(i));
            }
            ausgabe.add(eingabe);
        }
        rs.close();
        stmt.close();
        jdbc.closeConnection();
        return ausgabe;
    }
}
