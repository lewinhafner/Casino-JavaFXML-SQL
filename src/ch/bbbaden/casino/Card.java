/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

/**
 *
 * @author misch
 */
public class Card {
    private Rank rank;
    private Color color;
    private boolean hold = true;

    public Card(Rank rank, Color color) {
        this.rank = rank;
        this.color = color;
    }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }

    public boolean getHold() {
        return hold;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

   
}
