/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.mainmenu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class MainMenuController implements Initializable {
    private MainMenuViewModel vm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void bind(){
        
    }

    public void setViewModel(MainMenuViewModel vm) {
        this.vm = vm;
    }
     
}
