/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.videopoker;

import ch.bbbaden.casino.MainApp;
import ch.bbbaden.casino.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.JOptionPane;

/**
 *
 * @author misch
 */
public class VideoPokerMenuViewModel {
    private MainApp mainApp;
    private User user;
     private StringProperty balance = new SimpleStringProperty();
    public VideoPokerMenuViewModel( User user) {
        
        this.user = user;
        balance.setValue(Double.toString(user.getBalance()));
    }
    
    public void startAction(){
       if(Double.parseDouble(balance.getValue()) < 0.25){
           JOptionPane.showMessageDialog(null,
                    "Sie haben zu wenig Geld um zu spielen!",
                    "Fehler Meldung",
                    JOptionPane.WARNING_MESSAGE);
       }else{
           mainApp.showVideoPokerGame();
       }
        
        
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public void goToMenu(){
        mainApp.showMainMenu();
    }

    public StringProperty getBalance() {
        return balance;
    }
    
}
