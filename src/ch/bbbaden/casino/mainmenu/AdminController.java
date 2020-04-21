/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.mainmenu;

import Datenbank.Query;
import ch.bbbaden.casino.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class AdminController implements Initializable {

    MainApp mainApp;
    Query q = new Query();
    ArrayList<User> users = new ArrayList<>();
    
    @FXML
    private Button menuBtn;
    @FXML
    private ComboBox<String> usernameCb;
    @FXML
    private ComboBox<String> spielCb;
    @FXML
    private ListView<String> usernameLv;
    @FXML
    private ListView<String> spielLv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //usernameLv und usernameCb initialisieren
        try {
            // TODO
        q.updateUser();
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        users = q.getUsers();
        for(User user: users){
              usernameCb.getItems().add(user.getUsername());
        }
        usernameCb.setValue(users.get(0).getUsername());
        try {
            ArrayList<String> items = q.getUsersStats(usernameCb.getValue());
            String start = String.format("%-18s", "Spiel");
            start += String.format("%-18s","Bet");
            start += String.format("%-18s","Result");
            start += String.format("%-18s","change");
            usernameLv.getItems().add(start);
            usernameLv.getItems().addAll(items);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //gameCb und gameLv initialisieren
        spielCb.getItems().add("Slots");
        spielCb.getItems().add("Yatzi");
        spielCb.getItems().add("Roulette");
        spielCb.getItems().add("VideoPoker");
        spielCb.getItems().add("Blackjack");
        spielCb.setValue("Slots");
        try {
            ArrayList<String> items = q.getSpielStats(spielCb.getValue());
            String start = String.format("%-18s", "Spieler");
            start += String.format("%-18s","Bet");
            start += String.format("%-18s","Result");
            start += String.format("%-18s","change");
            spielLv.getItems().add(start);
            spielLv.getItems().addAll(items);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void menuAction(ActionEvent event) {
        mainApp.showMainMenu();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void usernameAction(ActionEvent event) {
        //UsernameLv aktulisieren
         try {
            usernameLv.getItems().clear();
            ArrayList<String> items = q.getUsersStats(usernameCb.getValue());
            String start = String.format("%-18s", "Spiel");
            start += String.format("%-18s","Bet");
            start += String.format("%-18s","Result");
            start += String.format("%-18s","change");
            usernameLv.getItems().add(start);
            usernameLv.getItems().addAll(items);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void spielAction(ActionEvent event) {
        //SpielerLv wird aktualisiert was in der Combobox steht
        try {
            spielLv.getItems().clear();
            ArrayList<String> items = q.getSpielStats(spielCb.getValue());
            String start = String.format("%-18s", "Spieler");
            start += String.format("%-18s","Bet");
            start += String.format("%-18s","Result");
            start += String.format("%-18s","change");
            spielLv.getItems().add(start);
            spielLv.getItems().addAll(items);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
