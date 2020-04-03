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
        hilfeTxt.setText("1. über den Knopf zwischen den Bet köpfen value des Chipes auswählen" + "\n" + "2. über die Betknöpfe auswählen wie viele Coins gesetzt werden"
                + "\n" + "3. Auf deal klicken" + "\n" + "4. Auf die Karten klicken, die man wegwerfen will." +"\n"+ "5. Auf Draw klicken" + 
                "\n" + "6. wenn gewonnen auf Gamble klicken will, wenn man den Gewinn verwetten will"
                +"\n"+"7. im Gamblemodus auf eine Karte klicken, die noch nicht aufgedeckt wurde" + "\n"+
                "natural_Royal_Flush -> A,K,Q,J,10(gleiche Farbe) || vier_deuces -> 4 * 2 ||Royal_Flush -> A,K,Q,J,10 (gleiche Farbe + Joker)"+"\n"+"5ofAKind -> 5* gleiches Zeichen ||"
                + " straight_Flush -> 5er Folge gleiche Farben(Joker erlaubt, nicht mit Ass beginnend)"+"\n"+"4ofAKind -> 4*gleiches Zeichen(Joker) || FullHouse -> 3 und 2 * gleiche Zeichen(Joker)"
                +"\n" + "flush -> 5* selbe Farbe || straight -> 5er Folge(Joker) || 3ofAKind -> 3*gleichesZeichen"
        );
        
    }    

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void gameAction(ActionEvent event) {
        mainApp.showVideoPokerGame();
    }
    
}
