package ch.bbbaden.casino.blackjack;

import ch.bbbaden.casino.MainApp;
import ch.bbbaden.casino.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Shenia Scherer
 */
public class BlackjackMenuViewModel {

    private MainApp mainApp;
    private User user;
    private StringProperty balance = new SimpleStringProperty();
    public BlackjackMenuViewModel(User user) {
       this.user = user;
       balance.setValue(Double.toString(user.getBalance()));
    }

    public void startAction() {
        mainApp.showBlackjackGame();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void gotoMenu(){
        mainApp.showMainMenu();
    }

    public StringProperty getBalance() {
        return balance;
    }
    
}
