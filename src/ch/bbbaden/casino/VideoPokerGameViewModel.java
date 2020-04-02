/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author misch
 */
public class VideoPokerGameViewModel implements PropertyChangeListener{
    private VideoPokerGameModel model;
    private VideoPoker mainApp;
    private ArrayList<Card> deck = new ArrayList();
    
    private StringProperty coinVal = new SimpleStringProperty();
    private StringProperty coinAnz = new SimpleStringProperty();
    private StringProperty win = new SimpleStringProperty();
    private boolean ersteRunde = true;
    
    public VideoPokerGameViewModel(VideoPokerGameModel model) {
        this.model = model;
    }

    public StringProperty getCoinVal() {
        return coinVal;
    }

    public StringProperty getWin() {
        return win;
    }
    
    public void setMainApp(VideoPoker mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("Bet")){
            coinAnz.set(evt.getNewValue().toString());
        }else if(evt.getPropertyName().equals("updateCoin")){
            coinVal.set(evt.getNewValue().toString() + " $");
        }else if(evt.getPropertyName().equals("win")){
            win.set(evt.getNewValue().toString());
        }
        
          
    }

    public StringProperty getCoinAnz() {     
        return coinAnz;
    }
    public void bet1(){
        model.coinAnzBet1();
    }
    public void bet5(){
        model.coinAnzBet5();
    }
    public void setCoinVal(){
        model.setCoinVal();
    }
    
    public void spiele(){
        model.deal();
        deck = model.getCardsOnTable();
    }
    public Card getCard(int i){
        return deck.get(i);
    }
    public void card(int i){
        model.card1Hold(i);
    }
    
    
}
