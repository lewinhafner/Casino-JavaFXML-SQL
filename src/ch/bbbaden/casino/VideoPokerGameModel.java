/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author misch
 */
public class VideoPokerGameModel {

    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    //Spiel
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> cardsOnTable = new ArrayList<>();
    private int cards;
    private int win = 0;

    private int coinAnz = 1;
    private double coinVal = 0.25;
    private boolean ersteRunde = true;

    public void AddPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public void generateCards() {
        for (Color color : Color.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, color));
            }
        }
        Collections.shuffle(deck);
    }

    public void coinAnzBet1() {
        int oldCoin = coinAnz;
        if (coinAnz == 5) {
            coinAnz = 1;
        } else {
            coinAnz += 1;
        }
        changes.firePropertyChange("Bet", oldCoin, coinAnz);
    }

    public void coinAnzBet5() {
        int oldCoin = coinAnz;
        coinAnz = 5;
        changes.firePropertyChange("Bet", oldCoin, coinAnz);
    }

    public void setCoinVal() {
        double oldValue = coinVal;
        if (coinVal == 0.25) {
            coinVal = 0.5;
        } else if (coinVal == 0.5) {
            coinVal = 1;
        } else if (coinVal == 1) {
            coinVal = 2;
        } else if (coinVal == 2) {
            coinVal = 5;
        } else if (coinVal == 5) {
            coinVal = 10;
        } else if (coinVal == 10) {
            coinVal = 50;
        } else if (coinVal == 50) {
            coinVal = 100;
        } else {
            coinVal = 0.25;
        }
        changes.firePropertyChange("updateCoin", oldValue, coinVal);
    }

    public void deal() {
        if (ersteRunde == true) {
            generateCards();
            for (int i = 0; i < 5; i++) {
                cardsOnTable.add(deck.get(i));
            }
            cards = 4;
            int winOld = win;
            if (natural_royal_flush() == true) {
                win = coinAnz * 800;
                changes.firePropertyChange("win", winOld, win);
            } else if (vier_deuces() == true) {
                win = coinAnz * 200;
                changes.firePropertyChange("win", winOld, win);
            }else if(wild_royal_flush()){
                win = coinAnz * 25;
                changes.firePropertyChange("win", winOld, win);
            }

        }
    }

    public ArrayList<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    private boolean natural_royal_flush() {
        ArrayList<Rank> rankA = new ArrayList<>();
        ArrayList<Color> color = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
            color.add(card.getColor());
        }
        boolean alleFarben = false;
        Color first = color.get(0);
        for (int i = 1; i < color.size(); i++) {
            if (first == color.get(i)) {
                alleFarben = true;
            } else {
                alleFarben = false;
                break;
            }
        }
        if (alleFarben == true) {
            if (rankA.contains(Rank.ACE) && rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private boolean vier_deuces() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }
        int anzZwei = 0;
        for (int i = 0; i < rankA.size(); i++) {
            if (rankA.get(i) == Rank.TWO) {
                anzZwei += 1;
            }
        }
        if (anzZwei >= 4) {
            return true;
        }
        return false;
    }

    private boolean wild_royal_flush() {
        ArrayList<Rank> rankA = new ArrayList<>();
        ArrayList<Color> color = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
            color.add(card.getColor());
        }
        boolean alleFarben = false;
        Color first = color.get(0);
        for (int i = 1; i < color.size(); i++) {
            if (first == color.get(i)) {
                alleFarben = true;
            } else {
                alleFarben = false;
                break;
            }
        }
        if (alleFarben == true) {
            int anzZwei = 0;
            for (int i = 0; i < rankA.size(); i++) {
                if (rankA.get(i) == Rank.TWO) {
                    anzZwei += 1;
                }
            }
            switch (anzZwei) {
                case 1: 
                    if(rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)){
                        return true;
                    }else if(rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)){
                        return true;
                    }else{
                        return false;
                    }
                case 2:
                    if(rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.TEN)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)){
                    
                    }else if(rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.QUEEN) && rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)){
                        return true;
                    }
                case 3:
                    if(rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)){
                        return true;
                    }else if(rankA.contains(Rank.QUEEN) && rankA.contains(Rank.TEN)){
                        return true;
                    }else if(rankA.contains(Rank.KING) && rankA.contains(Rank.TEN)){
                        return true;
                    }else if(rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)){
                        return true;
                    }else if(rankA.contains(Rank.QUEEN) && rankA.contains(Rank.KING)){
                        return true;
                    }else if(rankA.contains(Rank.ACE) && rankA.contains(Rank.KING)){
                        return true;
                    }else if(rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE)){
                        return true;
                    }
                case 4: 
                    if(rankA.contains(Rank.TEN)||rankA.contains(Rank.JACK)||rankA.contains(Rank.QUEEN)||rankA.contains(Rank.KING)||rankA.contains(Rank.ACE)){
                        return true;
                    }
                default:
                    return false;
            }
        }else{
            return false;
        }
        
    }

}
