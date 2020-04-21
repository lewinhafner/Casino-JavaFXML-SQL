/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.videopoker;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class VideoPokerGameController implements Initializable {
    private VideoPokerGameViewModel vm;
    private boolean ersteRunde = true; 
    private boolean canGamble = false;
    private boolean gambleMode = false;
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
    @FXML
    private Label card2;
    @FXML
    private Label card3;
    @FXML
    private Label card4;
    @FXML
    private Label card5;
    @FXML
    private Label winLbl;
    @FXML
    private Label winTxtLbl;
    @FXML
    private Button gambleBtn;
    @FXML
    private Button hilfeBtn;
    @FXML
    private Label balancelbl;
    @FXML
    private Label weg1;
    @FXML
    private Label weg2;
    @FXML
    private Label weg3;
    @FXML
    private Label weg4;
    @FXML
    private Label weg5;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        coinAnz.setText("1");
        weg1.setVisible(false);
        weg2.setVisible(false);
        weg3.setVisible(false);
        weg4.setVisible(false);
        weg5.setVisible(false);
    }    
    
     public void bind(){
        coinAnz.textProperty().bind(vm.getCoinAnz());
        coinValue.textProperty().bind(vm.getCoinVal());
        winLbl.textProperty().bind(vm.getWinQuote());
        winTxtLbl.textProperty().bind(vm.getWinTxt());
        balancelbl.textProperty().bind(vm.getBalance());
    }

    @FXML
    private void menuAction(ActionEvent event) {
        vm.goToMenu();
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
        //Erste Runde wird gestartet
        if(ersteRunde==true && gambleMode== false || ersteRunde==true &&winTxtLbl.getText().equals("Du hast verloren") ){
            canGamble = false;
            vm.spiele();
            cards();
            ersteRunde = false;
            dealBtn.setText("Draw");
            gambleMode = false;
        }else if (gambleMode == false){
            //Zweite Runde
            weg1.setVisible(false);
            weg2.setVisible(false);
            weg3.setVisible(false);
            weg4.setVisible(false);
            weg5.setVisible(false);
            vm.spiele();
            cards();
            ersteRunde = true;
            dealBtn.setText("Deal");
            if(winTxtLbl.getText().equals("Win")){
                canGamble = true;
            }
        }
        
    }

    @FXML
    private void card1Action(MouseEvent event) {
        //Card wegtun
        if(gambleMode == false && ersteRunde != true){
            vm.card(0);
            if(vm.getCard(0).getHold() == false){
                weg1.setVisible(true);
            }else{
                weg1.setVisible(false);
            }
        }else{
            //Card umkehren beim Gamblen
            vm.vergleicheCardsGamble(0);
            gambleMode = false;
            cards();
        }
        
    }
     @FXML
    private void card2Action(MouseEvent event) {
        //Card wegtun
        if(gambleMode == false && ersteRunde != true){
            vm.card(1);
            if(vm.getCard(1).getHold() == false){
                weg2.setVisible(true);
            }else{
                weg2.setVisible(false);
            }
        }else {
            //Card umkehren beim Gamblen
            vm.vergleicheCardsGamble(1);
            gambleMode = false;
            cards();
        }
        
    }

    @FXML
    private void card3Action(MouseEvent event) {
        //Card wegtun
        if(gambleMode == false && ersteRunde != true){
            vm.card(2);
            if(vm.getCard(2).getHold() == false){
                weg3.setVisible(true);
            }else{
                weg3.setVisible(false);
            }
        }else{
            //Card umkehren beim Gamblen
            vm.vergleicheCardsGamble(2);
            gambleMode = false;
            cards();
        }
    }

    @FXML
    private void card4Action(MouseEvent event) {
        //Card wegtun
         if(gambleMode == false && ersteRunde != true){
            vm.card(3);
            if(vm.getCard(3).getHold() == false){
                weg4.setVisible(true);
            }else{
                weg4.setVisible(false);
            }
        }else{
            //Card umkehren beim Gamblen
            vm.vergleicheCardsGamble(3);
            gambleMode = false;
             cards();
        }
    }

    @FXML
    private void card5Action(MouseEvent event) {
        //Card wegtun
        if(gambleMode == false && ersteRunde != true){
            vm.card(4);
            if(vm.getCard(4).getHold() == false){
                weg5.setVisible(true);
            }else{
                weg5.setVisible(false);
            }
        }else{
            //Card umkehren beim Gamblen
            vm.vergleicheCardsGamble(4);
            gambleMode = false;
             cards();
        }
    }
    @FXML
    private void gambleAction(ActionEvent event) {
        //gamblen
        if(canGamble == true && gambleMode == false){
            vm.gamble();
            gambleMode = true;
            cards();
        }
    }
     @FXML
    private void hilfeAction(ActionEvent event) {
        //hilfe wechseln
        if(ersteRunde==true && gambleMode== false || ersteRunde==true &&winTxtLbl.getText().equals("Du hast verloren") ){
            vm.hilfe();
        }
        
    }
    public void cards(){
        //Karten anzeigen lassen
        Card karte1 = vm.getCard(0);
        card1.setText("");
        card1.setGraphic(new ImageView(showCard(karte1.getColor(),karte1.getRank(),karte1)));
        Card karte2 = vm.getCard(1);
        card2.setText("");
        card2.setGraphic(new ImageView(showCard(karte2.getColor(),karte2.getRank(),karte2)));
        Card karte3 = vm.getCard(2);
        card3.setText("");
        card3.setGraphic(new ImageView(showCard(karte3.getColor(),karte3.getRank(),karte3)));
        Card karte4 = vm.getCard(3);
        card4.setText("");
        card4.setGraphic(new ImageView(showCard(karte4.getColor(),karte4.getRank(),karte4)));
        Card karte5 = vm.getCard(4);
        card5.setText("");
        card5.setGraphic(new ImageView(showCard(karte5.getColor(),karte5.getRank(),karte5)));
    }
    public String showCard(Color color, Rank rank, Card card){
        //Wie die Karten aussehen
        if(card.isVerdeckt() == true){
            return "cards/purple_back.png";
        }
        if(color == Color.CLUB){
            
            if(rank == Rank.ACE){
                return "cards/AC.png";
            }else if(rank == Rank.KING){
                return "cards/KC.png";
            }else if(rank == Rank.QUEEN){
                return "cards/QC.png";
            }else if(rank == Rank.JACK){
                return "cards/JC.png";
            }else if(rank == Rank.TEN){
                return "cards/10C.png";
            }else if(rank == Rank.NINE){
                return "cards/9C.png";
            }else if(rank == Rank.EIGHT){
                return "cards/8C.png";
            }else if(rank == Rank.SEVEN){
                return "cards/7C.png";
            }else if(rank == Rank.SIX){
                return "cards/6C.png";
            }else if(rank == Rank.FIVE){
                return "cards/5C.png";
            }else if(rank == Rank.FOUR){
                return "cards/4C.png";
            }else if(rank == Rank.THREE){
                return "cards/3C.png";
            }else{
                return "cards/2C.png";
            }
            
        }else if(color == Color.DIAMOND){
            
            if(rank == Rank.ACE){
                return "cards/AD.png";
            }else if(rank == Rank.KING){
                return "cards/KD.png";
            }else if(rank == Rank.QUEEN){
                return "cards/QD.png";
            }else if(rank == Rank.JACK){
                return "cards/JD.png";
            }else if(rank == Rank.TEN){
                return "cards/10D.png";
            }else if(rank == Rank.NINE){
                return "cards/9D.png";
            }else if(rank == Rank.EIGHT){
                return "cards/8D.png";
            }else if(rank == Rank.SEVEN){
                return "cards/7D.png";
            }else if(rank == Rank.SIX){
                return "cards/6D.png";
            }else if(rank == Rank.FIVE){
                return "cards/5D.png";
            }else if(rank == Rank.FOUR){
                return "cards/4D.png";
            }else if(rank == Rank.THREE){
                return "cards/3D.png";
            }else{
                return "cards/2D.png";
            }
        }else if(color == Color.HEART){
            
            if(rank == Rank.ACE){
                return "cards/AH.png";
            }else if(rank == Rank.KING){
                return "cards/KH.png";
            }else if(rank == Rank.QUEEN){
                return "cards/QH.png";
            }else if(rank == Rank.JACK){
                return "cards/JH.png";
            }else if(rank == Rank.TEN){
                return "cards/10H.png";
            }else if(rank == Rank.NINE){
                return "cards/9H.png";
            }else if(rank == Rank.EIGHT){
                return "cards/8H.png";
            }else if(rank == Rank.SEVEN){
                return "cards/7H.png";
            }else if(rank == Rank.SIX){
                return "cards/6H.png";
            }else if(rank == Rank.FIVE){
                return "cards/5H.png";
            }else if(rank == Rank.FOUR){
                return "cards/4H.png";
            }else if(rank == Rank.THREE){
                return "cards/3H.png";
            }else{
                return "cards/2H.png";
            }
        
        }else{
            
            if(rank == Rank.ACE){
                return "cards/AS.png";
            }else if(rank == Rank.KING){
                return "cards/KS.png";
            }else if(rank == Rank.QUEEN){
                return "cards/QS.png";
            }else if(rank == Rank.JACK){
                return "cards/JS.png";
            }else if(rank == Rank.TEN){
                return "cards/10S.png";
            }else if(rank == Rank.NINE){
                return "cards/9S.png";
            }else if(rank == Rank.EIGHT){
                return "cards/8S.png";
            }else if(rank == Rank.SEVEN){
                return "cards/7S.png";
            }else if(rank == Rank.SIX){
                return "cards/6S.png";
            }else if(rank == Rank.FIVE){
                return "cards/5S.png";
            }else if(rank == Rank.FOUR){
                return "cards/4S.png";
            }else if(rank == Rank.THREE){
                return "cards/3S.png";
            }else{
                return "cards/2S.png";
            }
        
        }
        
    }

   

  

   
}
