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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class VideoPokerGameController implements Initializable {
    private VideoPokerGameViewModel vm;
    private boolean ersteRunde = true; 
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
        winLbl.textProperty().bind(vm.getWin());
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
        if(ersteRunde==true){
            vm.spiele();
            cards();
            ersteRunde = false;
            dealBtn.setText("Draw");
        }else{
            vm.spiele();
            cards();
        }
        
    }

    @FXML
    private void card1Action(MouseEvent event) {
        vm.card(0);
    }
     @FXML
    private void card2Action(MouseEvent event) {
        vm.card(1);
    }

    @FXML
    private void card3Action(MouseEvent event) {
        vm.card(2);
    }

    @FXML
    private void card4Action(MouseEvent event) {
        vm.card(3);
    }

    @FXML
    private void card5Action(MouseEvent event) {
        vm.card(4);
    }
    
    public void cards(){
        Card karte1 = vm.getCard(0);
        card1.setText("");
        card1.setGraphic(new ImageView(showCard(karte1.getColor(),karte1.getRank())));
        Card karte2 = vm.getCard(1);
        card2.setText("");
        card2.setGraphic(new ImageView(showCard(karte2.getColor(),karte2.getRank())));
        Card karte3 = vm.getCard(2);
        card3.setText("");
        card3.setGraphic(new ImageView(showCard(karte3.getColor(),karte3.getRank())));
        Card karte4 = vm.getCard(3);
        card4.setText("");
        card4.setGraphic(new ImageView(showCard(karte4.getColor(),karte4.getRank())));
        Card karte5 = vm.getCard(4);
        card5.setText("");
        card5.setGraphic(new ImageView(showCard(karte5.getColor(),karte5.getRank())));
    }
    public String showCard(Color color, Rank rank){
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
