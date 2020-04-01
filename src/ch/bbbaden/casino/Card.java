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
    private String rank;
    private String color;
    private boolean hold = true;

    public Card(String rank, String color) {
        this.rank = rank;
        this.color = color;
    }

    public String getRank() {
        return rank;
    }

    public String getColor() {
        return color;
    }

    public boolean isHold() {
        return hold;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
