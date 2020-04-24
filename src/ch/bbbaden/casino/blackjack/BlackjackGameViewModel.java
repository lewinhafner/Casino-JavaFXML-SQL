package ch.bbbaden.casino.blackjack;

import ch.bbbaden.casino.MainApp;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Shenia Scherer
 */
public class BlackjackGameViewModel implements PropertyChangeListener {

    private final BlackjackGameModel model;

    private MainApp mainApp;
    private int property;

    //--DEFINE CARDS--//
    IntegerProperty cardP1 = new SimpleIntegerProperty();
    IntegerProperty cardD1 = new SimpleIntegerProperty();
    IntegerProperty cardP2 = new SimpleIntegerProperty();
    IntegerProperty cardD2 = new SimpleIntegerProperty();
    IntegerProperty cardP3 = new SimpleIntegerProperty();
    IntegerProperty cardD3 = new SimpleIntegerProperty();
    IntegerProperty cardP4 = new SimpleIntegerProperty();
    IntegerProperty cardD4 = new SimpleIntegerProperty();
    IntegerProperty cardP5 = new SimpleIntegerProperty();
    IntegerProperty cardD5 = new SimpleIntegerProperty();
    IntegerProperty cardDouble = new SimpleIntegerProperty();

    public BlackjackGameViewModel(BlackjackGameModel model) {
        this.model = model;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    //--GETTERS UND SETTERS--//
    public IntegerProperty getCardP1() {
        return cardP1;
    }

    public IntegerProperty getCardP2() {
        return cardP2;
    }

    public IntegerProperty getCardD1() {
        return cardD1;
    }

    public IntegerProperty getCardD2() {
        return cardD2;
    }

    public IntegerProperty getCardP3() {
        return cardP3;
    }

    public IntegerProperty getCardD3() {
        return cardD3;
    }

    public IntegerProperty getCardP4() {
        return cardP4;
    }

    public IntegerProperty getCardD4() {
        return cardD4;
    }

    public IntegerProperty getCardP5() {
        return cardP5;
    }

    public IntegerProperty getCardD5() {
        return cardD5;
    }

    public IntegerProperty getCardDouble() {
        return cardDouble;
    }

    //-----//
    public void play() {
        model.play();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "cardP1":
                cardP1.set((int) evt.getNewValue());
                break;
            case "cardD1":
                cardD1.set((int) evt.getNewValue());
                break;
            case "cardP2":
                cardP2.set((int) evt.getNewValue());
                break;
            case "cardD2":
                cardD2.set((int) evt.getNewValue());
                break;
            case "cardP3":
                cardP3.set((int) evt.getNewValue());
                break;
            case "cardD3":
                cardD3.set((int) evt.getNewValue());
                break;
            case "cardP4":
                cardP4.set((int) evt.getNewValue());
                break;
            case "cardD4":
                cardD4.set((int) evt.getNewValue());
                break;
            case "cardP5":
                cardP5.set((int) evt.getNewValue());
                break;
            case "cardD5":
                cardD5.set((int) evt.getNewValue());
                break;
            case "cardDouble":
                cardDouble.set((int) evt.getNewValue());
                break;
        }
    }

    /*public void goToMenu() {
        mainApp.showMainMenu();
    }
     */
    public void hitAction(int cardstaken) {
        model.hitAction(cardstaken);
    }

    public void standAction(int dealersum, int idcard) {
        model.standAction(dealersum, idcard);
    }

    public void setAmount(double wert) {
        model.setAmountsum(wert);
    }

    public void cardDouble() {
        model.cardDouble();
    }

    public void goToMenu() {
        mainApp.showBlackjackMenu();
    }

}
