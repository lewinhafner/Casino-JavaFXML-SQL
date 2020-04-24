package ch.bbbaden.casino.blackjack;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

/**
 *
 * @author Shenia Scherer
 */
public class BlackjackGameModel {

    //--DECLARING AND INITIALIZING VARIABLE--//
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    Random rand = new Random();
    private int newcard = 0;
    private double amountsum = 0;

    //When Play button is clicked, 4 cards will be shown randomly
    public void play() {
        int oldcard = newcard;
        newcard = rand.nextInt(52);
        changes.firePropertyChange("cardP1", oldcard, newcard);
        newcard = rand.nextInt(52);
        changes.firePropertyChange("cardD1", oldcard, newcard);
        newcard = rand.nextInt(52);
        changes.firePropertyChange("cardP2", oldcard, newcard);
        newcard = rand.nextInt(52);
        changes.firePropertyChange("cardD2", oldcard, newcard);

    }

    public void AddPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    //When hit button is clicked, Player cards (3,4 & 5) will be shown
    public void hitAction(int cardstakenP) {
        int oldcard = newcard;
        switch (cardstakenP) {
            case 2:
                newcard = rand.nextInt(52);
                changes.firePropertyChange("cardP3", oldcard, newcard);
                break;
            case 3:
                newcard = rand.nextInt(52);
                changes.firePropertyChange("cardP4", oldcard, newcard);
                break;
            case 4:
                newcard = rand.nextInt(52);
                changes.firePropertyChange("cardP5", oldcard, newcard);
                break;
        }
    }

    //When stand button is clicked, Dealer draws until 16 stands on 17
    public void standAction(int dealersum, int idcard) {
        int oldcard = newcard;

        if (dealersum < 17) {
            newcard = rand.nextInt(52);
            changes.firePropertyChange("cardD" + idcard, oldcard, newcard);
        }
    }

    //When double is shown, a new card will be drawn horizontally 
    public void cardDouble() {
        int oldcard = newcard;
        newcard = rand.nextInt(52);
        changes.firePropertyChange("cardDouble", oldcard, newcard);
    }

    public void setAmountsum(double amountsum) {
        this.amountsum = amountsum;
    }

}
