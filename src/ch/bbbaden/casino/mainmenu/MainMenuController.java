/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.mainmenu;

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
public class MainMenuController implements Initializable {
    private MainMenuViewModel vm;
    @FXML
    private Label pokerLbl;
    @FXML
    private Label rouletteLbl;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button kasseBtn;
    @FXML
    private Label slotsLbl;
    @FXML
    private Label yatziLbl;
    @FXML
    private Label blackjackLbl;
    @FXML
    private Label kontoUserlbl;
    @FXML
    private Button statistikBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
     public void bind(){
        kontoUserlbl.textProperty().bind(vm.getBalance());
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

    @FXML
    private void logoutAction(ActionEvent event) {
        vm.showLogin();
    }

    @FXML
    private void kasseAction(ActionEvent event) {
        vm.showKasse();
    }

    @FXML
    private void slotsAction(MouseEvent event) {
    }

    @FXML
    private void yatziAction(MouseEvent event) {
    }

    @FXML
    private void blackjackAction(MouseEvent event) {
    }

    @FXML
    private void statistikAction(ActionEvent event) {
        vm.showStats();
    }
    
    public void userAdmin(){
        if(vm.getRole().equals("admin")){
            statistikBtn.setVisible(true);
        }else{
            statistikBtn.setVisible(false);    
        }
    }
     
}
