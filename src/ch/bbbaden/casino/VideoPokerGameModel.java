/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 *
 * @author misch
 */
public class VideoPokerGameModel {
     protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private ArrayList<Card> deck = new ArrayList<>();
    private int coinAnz = 1;
    private double coinVal = 0.25;
    
    public void AddPropertyChangeListener(final PropertyChangeListener listener){
        changes.addPropertyChangeListener(listener);
    }
    
    public void generateCards(){
        for(Color color : Color.values()){
            for(Rank rank : Rank.values()){
                deck.add(new Card(rank,color));
            }
        }
    }
    public void coinAnzBet1(){
        int oldCoin = coinAnz;
        if(coinAnz == 5){
            coinAnz = 1;
        }else{
            coinAnz += 1;
        }
        changes.firePropertyChange("Bet", oldCoin, coinAnz);
    }
     public void coinAnzBet5(){
        int oldCoin = coinAnz;
        coinAnz = 5;
        changes.firePropertyChange("Bet", oldCoin, coinAnz);
    }

    public void setCoinVal() {
        double oldValue = coinVal;
        if(coinVal == 0.25){
            coinVal = 0.5;
        }else if(coinVal == 0.5){
            coinVal = 1;
        }else if(coinVal == 1){
            coinVal = 2;
        }else if(coinVal == 2){
            coinVal = 5;
        }else if(coinVal == 5){
            coinVal = 10;
        }else if(coinVal == 10){
            coinVal = 50;
        }else if(coinVal == 50){
            coinVal = 100;
        }else{
            coinVal = 0.25;
        }
        changes.firePropertyChange("updateCoin", oldValue, coinVal);
    }
     
    
}
