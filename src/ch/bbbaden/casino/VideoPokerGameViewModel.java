/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author misch
 */
public class VideoPokerGameViewModel implements PropertyChangeListener{
    private VideoPokerGameModel model;
    private VideoPoker mainApp;
    private StringProperty coinVal = new SimpleStringProperty();
    private StringProperty coinAnz = new SimpleStringProperty();

    public VideoPokerGameViewModel(VideoPokerGameModel model) {
        this.model = model;
    }
    
    public void setMainApp(VideoPoker mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
         coinAnz.set(evt.getNewValue().toString());
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
    
    
}
