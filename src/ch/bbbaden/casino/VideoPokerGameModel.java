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
        deck.removeAll(deck);
        for (Color color : Color.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, color));
            }
        }
        Collections.shuffle(deck);
    }

    public void coinAnzBet1() {
        if (ersteRunde == true) {
            int oldCoin = coinAnz;
            if (coinAnz == 5) {
                coinAnz = 1;
            } else {
                coinAnz += 1;
            }
            changes.firePropertyChange("Bet", oldCoin, coinAnz);
        }
    }

    public void coinAnzBet5() {
        if (ersteRunde == true) {
            int oldCoin = coinAnz;
            coinAnz = 5;
            changes.firePropertyChange("Bet", oldCoin, coinAnz);
        }
    }

    public void setCoinVal() {
        if (ersteRunde == true) {
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
    }

    public void deal() {
        if (ersteRunde == true) {
            generateCards();
            cardsOnTable.removeAll(cardsOnTable);
            for (int i = 0; i < 5; i++) {
                cardsOnTable.add(deck.get(i));
            }
            cards = 5;
            gewinnUeberpruefung();
        }
    }

    public void gewinnUeberpruefung() {
        int winOld = win;
        if (natural_royal_flush() == true) {
            win = coinAnz * 800;
            changes.firePropertyChange("win", winOld, win);
        } else if (vier_deuces() == true) {
            win = coinAnz * 200;
            changes.firePropertyChange("win", winOld, win);
        } else if (wild_royal_flush() == true) {
            win = coinAnz * 25;
            changes.firePropertyChange("win", winOld, win);
        } else if (funfGleiche() == true) {
            win = coinAnz * 15;
            changes.firePropertyChange("win", winOld, win);
        } else if (straightFlush() == true) {
            win = coinAnz * 9;
            changes.firePropertyChange("win", winOld, win);
        } else if (vierling() == true) {
            win = coinAnz * 5;
            changes.firePropertyChange("win", winOld, win);
        } else if (fullHouse() == true) {
            win = coinAnz * 3;
            changes.firePropertyChange("win", winOld, win);
        } else if (flush() == true) {
            win = coinAnz * 2;
            changes.firePropertyChange("win", winOld, win);
        } else if (straight() == true) {
            win = coinAnz * 2;
            changes.firePropertyChange("win", winOld, win);
        } else if (drilling() == true) {
            win = coinAnz * 1;
            changes.firePropertyChange("win", winOld, win);
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
                    if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)) {

                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    }
                case 3:
                    if (rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.KING)) {
                        return true;
                    } else if (rankA.contains(Rank.ACE) && rankA.contains(Rank.KING)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE)) {
                        return true;
                    }
                case 4:
                    if (rankA.contains(Rank.TEN) || rankA.contains(Rank.JACK) || rankA.contains(Rank.QUEEN) || rankA.contains(Rank.KING) || rankA.contains(Rank.ACE)) {
                        return true;
                    }
                default:
                    return false;
            }
        } else {
            return false;
        }

    }

    private boolean funfGleiche() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }

        Rank rank1 = null;
        if (rankA.get(0) != Rank.TWO) {
            rank1 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO) {
            rank1 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO) {
            rank1 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO) {
            rank1 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO) {
            rank1 = rankA.get(4);
        }
        boolean ausgabe = false;
        for (int i = 0; i < 5; i++) {
            if (rankA.get(i) == rank1 || rankA.get(i) == Rank.TWO) {
                ausgabe = true;
            } else {
                ausgabe = false;
                break;
            }
        }
        return ausgabe;
    }

    private boolean straightFlush() {
        ArrayList<Rank> rankA = new ArrayList<>();
        ArrayList<Color> color = new ArrayList<>();
        boolean ausgabe = false;
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
        if (cardsOnTable.contains(Rank.ACE)) {
            return false;
        }
        if (alleFarben == true) {
            Collections.sort(rankA);
            Rank rank1 = rankA.get(0);
        }

        return ausgabe;
    }

    private boolean vierling() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }
        Rank rank1 = null;
        if (rankA.get(0) != Rank.TWO) {
            rank1 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO) {
            rank1 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO) {
            rank1 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO) {
            rank1 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO) {
            rank1 = rankA.get(4);
        }
        int anz = 0;
        for (int i = 0; i < 5; i++) {
            if (rankA.get(i) == rank1 || rankA.get(i) == Rank.TWO) {
                anz += 1;
            }
        }
        if (anz == 4) {
            return true;
        }
        return false;
    }

    private boolean fullHouse() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }
        Rank rank1 = null;
        if (rankA.get(0) != Rank.TWO) {
            rank1 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO) {
            rank1 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO) {
            rank1 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO) {
            rank1 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO) {
            rank1 = rankA.get(4);
        }
        Rank rank2 = null;
        if (rankA.get(0) != Rank.TWO && rankA.get(0) != rank1) {
            rank2 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO && rankA.get(0) != rank1) {
            rank2 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO && rankA.get(0) != rank1) {
            rank2 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO && rankA.get(0) != rank1) {
            rank2 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO && rankA.get(0) != rank1) {
            rank2 = rankA.get(4);
        }
        int anz1 = 0;
        int anz2 = 0;
        for (int i = 0; i < 5; i++) {
            if (rankA.get(i) == rank1) {
                anz1 += 1;
            } else if (rankA.get(i) == rank2) {
                anz2 += 1;
            }
            if (rankA.get(i) == Rank.TWO) {
                if (anz1 < 3) {
                    anz1++;
                } else {
                    anz2++;
                }
            }
        }
        if (anz1 == 3 && anz2 == 2 || anz1 == 2 && anz2 == 3) {
            return true;
        }
        return false;
    }

    private boolean flush() {
        ArrayList<Color> color = new ArrayList<>();
        for (Card card : cardsOnTable) {
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
        return alleFarben;
    }

    private boolean straight() {
        ArrayList<Rank> rankA = new ArrayList<>();

        boolean ausgabe = false;
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());

        }
        Collections.sort(rankA);
        Rank rank1 = rankA.get(0);

        return false;
    }

    private boolean drilling() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }
        Rank rank1 = null;
        if (rankA.get(0) != Rank.TWO) {
            rank1 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO) {
            rank1 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO) {
            rank1 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO) {
            rank1 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO) {
            rank1 = rankA.get(4);
        }
        int anzZwei = 0;
        for (int i = 0; i < rankA.size(); i++) {
            if (rankA.get(i) == Rank.TWO) {
                anzZwei += 1;
            }
        }
        if (anzZwei > 2) {
            return false;
        }
        int anz = 0;
        for (int i = 0; i < 5; i++) {
            if (rankA.get(i) == rank1 || rankA.get(i) == Rank.TWO) {
                anz += 1;
            }
        }
        if (anz == 3) {
            return true;
        }
        return false;
    }
}
