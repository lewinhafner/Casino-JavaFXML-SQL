/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class VideoPokerGameController implements Initializable {
    private VideoPokerGameViewModel vm;
    @FXML
    private Button menuBtn;
    @FXML
    private Button bet1Btn;
    @FXML
    private Button bet5Btn;
    @FXML
    private Button coinValue;
    @FXML
    private Label coinAnz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        coinAnz.setText("1");
    }    
    
     public void bind(){
        coinAnz.textProperty().bind(vm.getCoinAnz());
    }

    @FXML
    private void menuAction(ActionEvent event) {
    }
    public void setViewModel(VideoPokerGameViewModel vm){
        this.vm = vm;
    }

    @FXML
    private void bet1Action(ActionEvent event) {
        vm.bet1();
    }

    @FXML
    private void bet5Action(ActionEvent event) {
    }

    @FXML
    private void coinValueAction(ActionEvent event) {
    }
    
}
