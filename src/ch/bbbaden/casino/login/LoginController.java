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

/**
 * FXML Controller class
 *
 * @author misch
 */
public class LoginController implements Initializable {
    
    private int id = 0;
    private String username = "";
    private String password = "";

    Query sql = new Query();
    ArrayList<User> users = new ArrayList<>();
    private String signUp = "";
    MainApp mainApp;
    
    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField passwordTxt;
    @FXML
    private Button signeUpBtn;
    @FXML
    private Button LoginBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            sql.updateUser();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

      

        for (int i = 0; i < sql.getUsers().size(); i++) {
            users.add(sql.getUsers().get(i));
        }
    }    

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private void SigneAction(ActionEvent event) {
        mainApp.showSignUp();
    }

    @FXML
    private void LoginAction(ActionEvent event) {
        username = usernameTxt.getText();
        password = passwordTxt.getText();

        for(User u : users){
            if (u.getUsername().equals(username)) {
                if (u.getPassword().equals(password)) {
                    System.out.println("Login Successful!!");
                    mainApp.setUser(u);
                    mainApp.showMainMenu();
                    
                    break;
                } else {
                    System.out.println("Benutzername/Password Falsch");
                }
            }
        }
        
        
    }
    
}
