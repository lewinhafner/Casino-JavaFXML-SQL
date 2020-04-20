/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import Datenbank.Query;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author misch
 */
public class User {
    private final int id;
    private String username;
    private String forename;
    private String surname;
    private String password;
    private double balance;
    private String email;
    private String role;
    private int age;
    Query q = new Query();

    public User(int id, String username, String forename, String surname, String password, double balance, String email, String role, int age) {
        this.id = id;
        this.username = username;
        this.forename = forename;
        this.surname = surname;
        this.password = password;
        this.balance = balance;
        this.email = email;
        this.role = role;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    

   
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        try {
            q.updateBalance(id, balance);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateStatistics(int gId,double bet,String result,double changes){
        try {
            q.updateStatistics(id, gId, bet, result, changes);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
