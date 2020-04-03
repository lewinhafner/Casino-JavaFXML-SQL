/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.videopoker;

import ch.bbbaden.casino.MainApp;
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
public class VideoPokerHilfeController implements Initializable {
    private MainApp mainApp;
    @FXML
    private Label hilfeTxt;
    @FXML
    private Button gameBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hilfeTxt.setText("1. über den Knopf zwischen den Bet köpfen value des Chipes auswählen" + "\n" + "2. über die Betknöpfe auswählen wie viele Coins gesetzt werdem"
                + "\n" + "3. Auf deal klicken" + "\n" + "4. Auf die Karten klicken, die man wegwerfen will." +"\n"+ "5. Auf Draw klicken" + 
                "\n" + "6. wenn gewonnen auf Gamble klicken will, wenn man den Gewinn verwetten will"
                +"\n"+"7. im Gamblemodus auf eine Karte klicken, die noch nicht aufgedeckt wurde"
        );
        
    }    

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void gameAction(ActionEvent event) {
        mainApp.showGame();
    }
    
}
