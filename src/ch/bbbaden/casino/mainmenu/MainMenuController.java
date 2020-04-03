/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.mainmenu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class MainMenuController implements Initializable {
    private MainMenuViewModel vm;
    @FXML
    private Label pokerLbl;
    @FXML
    private Label rouletteLbl;
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

    @FXML
    private void pokerAction(MouseEvent event) {
        vm.showPoker();
    }

    @FXML
    private void rouletteAction(MouseEvent event) {
    }
     
}
