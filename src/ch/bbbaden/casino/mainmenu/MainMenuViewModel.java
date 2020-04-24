/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.mainmenu;

import ch.bbbaden.casino.MainApp;
import ch.bbbaden.casino.User;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author misch
 */
public class MainMenuViewModel implements PropertyChangeListener{
    
    private MainApp mainApp;
    private User user;
     private StringProperty balance = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();
    
    public MainMenuViewModel( User user) {
        
        this.user = user;
       balance.setValue(Double.toString(user.getBalance()));
       name.setValue(user.getUsername());
    }

    

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void showPoker(){
        mainApp.showVideoPokerMenu();
    }
    public void showBlackjack(){
        mainApp.showBlackjackMenu();
    }
    
    public void showLogin(){
        mainApp.showLogin();
    }
    public void showKasse(){
        mainApp.showKasse();
    }
    public StringProperty getBalance() {
        return balance;
    }
    public String getRole(){
        return user.getRole();
    }
    public void showStats(){
        mainApp.showStatistik();
    }

    public StringProperty getName() {
        return name;
    }
    
   
}
