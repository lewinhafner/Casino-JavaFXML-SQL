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
import javafx.scene.input.MouseEvent;

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
    @FXML
    private Button dealBtn;
    @FXML
    private Label card1;

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
        coinValue.textProperty().bind(vm.getCoinVal());
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
        vm.bet5();
    }

    @FXML
    private void coinValueAction(ActionEvent event) {
        vm.setCoinVal();
    }

    @FXML
    private void dealAction(ActionEvent event) {
        vm.spiele();
        cards();
    }

    @FXML
    private void card1Action(MouseEvent event) {
    }
    
    public void cards(){
        Card karte1 = vm.getCard(0);
        card1.setText(karte1.getColor() + " "+ karte1.getRank());
        Card karte2 = vm.getCard(1);
        Card karte3 = vm.getCard(2);
        Card karte4 = vm.getCard(3);
        Card karte5 = vm.getCard(4);
    }
    public void showCard(Color color, Rank rank){
        if(color == Color.CLUB){
            
        }else if(color == Color.DIAMOND){
        
        }else if(color == Color.HEART){
        
        }else{
        
        }
        
    }
}
