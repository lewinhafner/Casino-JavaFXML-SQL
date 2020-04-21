/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.login;

import Datenbank.Query;
import ch.bbbaden.casino.MainApp;
import ch.bbbaden.casino.User;
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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class SignUpController implements Initializable {

    Query q = new Query();
    MainApp mainApp;
    ArrayList<User> users = new ArrayList<>();

    @FXML
    private Button closeBtn;
    @FXML
    private Button signUpBtn;
    @FXML
    private TextField forenameTxt;
    @FXML
    private TextField surnameTxt;
    @FXML
    private TextField ageTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField passwordTxt;
    @FXML
    private TextField usernameTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            q.updateUser();
            users = q.getUsers();
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void closeAction(ActionEvent event) {
        mainApp.showLogin();
    }

    @FXML
    private void signUpAction(ActionEvent event) {
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();
        String forename = forenameTxt.getText();
        String surname = surnameTxt.getText();
        String email = emailTxt.getText();
        try {
            int age = Integer.parseInt(ageTxt.getText());
            if (username.length() > 5 && password.length() > 5 && forename.length() > 1 && surname.length() > 1 && email.length() > 2 && age >= 18) {
                boolean vergeben = false;
                for (User u : users) {
                    if (u.getUsername().equals(username)) {
                        vergeben = true;
                    }
                }
                if (vergeben == false) {
                    try {
                        q.createUser(username, forename, surname, password, email, age);
                    } catch (SQLException ex) {
                        Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    mainApp.showLogin();
                }else{
                     JOptionPane.showMessageDialog(null,
                        "Username ist schon vergeben",
                        "Fehler Meldung",
                        JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "Eine Eingabe ist Falsch oder fehlt",
                        "Fehler Meldung",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Eine Eingabe ist Falsch oder fehlt",
                    "Fehler Meldung",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
