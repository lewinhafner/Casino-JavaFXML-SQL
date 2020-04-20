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
    private MainMenuModel model;
    private MainApp mainApp;
    private User user;
     private StringProperty balance = new SimpleStringProperty();
    
    public MainMenuViewModel(MainMenuModel model, User user) {
        this.model = model;
        this.user = user;
       balance.setValue(Double.toString(user.getBalance()));
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

    public StringProperty getBalance() {
        return balance;
    }
    
   
}
