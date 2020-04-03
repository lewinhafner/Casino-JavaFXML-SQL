/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.mainmenu;

import ch.bbbaden.casino.MainApp;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author misch
 */
public class MainMenuViewModel implements PropertyChangeListener{
    private MainMenuModel model;
    private MainApp mainApp;

    public MainMenuViewModel(MainMenuModel model) {
        this.model = model;
    }

    

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
