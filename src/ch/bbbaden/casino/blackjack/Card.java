package ch.bbbaden.casino.blackjack;

/**
 *
 * @author Shenia Scherer
 */
public class Card {

    private int value;
    private int id;

    public Card(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

}
