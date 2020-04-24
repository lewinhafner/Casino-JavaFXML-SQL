package ch.bbbaden.casino.blackjack;

import ch.bbbaden.casino.MainApp;

/**
 *
 * @author Shenia Scherer
 */
public class BlackjackMenuViewModel {

    private final BlackjackMenuModel model;
    private MainApp mainApp;

    public BlackjackMenuViewModel(BlackjackMenuModel model) {
        this.model = model;

    }

    public void startAction() {
        mainApp.showBlackjackGame();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void gotoMenu(){
        mainApp.showBlackjackMenu();
    }

}
