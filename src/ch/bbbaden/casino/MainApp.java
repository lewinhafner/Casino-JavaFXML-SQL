/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;


import ch.bbbaden.casino.login.LoginController;
import ch.bbbaden.casino.login.SignUpController;
import ch.bbbaden.casino.mainmenu.*;
import ch.bbbaden.casino.videopoker.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author misch
 */
public class MainApp extends Application {

    Stage stage;
    User user;
    @Override
    public void start(Stage stage) throws Exception {
       
    
       this.stage = stage;
       stage.initStyle(StageStyle.UNDECORATED);
       //showMainMenu();
       showLogin();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void setUser(User user) {
        this.user = user;
    }
    
     public void showMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu/MainMenu.fxml"));
            Parent root;
            root = loader.load();
             MainMenuController view = loader.getController();
            MainMenuModel model = new MainMenuModel();
            MainMenuViewModel viewModel = new MainMenuViewModel(model, user);
            viewModel.setMainApp(this);
            view.setViewModel(viewModel);
            view.bind();
            final Scene scene = new Scene(root);         
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void showLogin(){
         
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login/Login.fxml"));
            Parent root;
            root = loader.load();
            LoginController view = loader.getController();
            view.setMainApp(this);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     }
     public void showSignUp(){
         
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login/SignUp.fxml"));
            Parent root;
            root = loader.load();
            SignUpController view = loader.getController();
            view.setMainApp(this);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     }
      public void showKasse(){
         
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu/Kasse.fxml"));
            Parent root;
            root = loader.load();
            KasseController view = loader.getController();
            view.setMainApp(this);
            view.setUser(user);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     }
    public void showVideoPokerMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("videopoker/VideoPokerMenu.fxml"));
            Parent root;
            root = loader.load();
            VideoPokerMenuController view = loader.getController();
            VideoPokerMenuModel model = new VideoPokerMenuModel();
            VideoPokerMenuViewModel viewModel = new VideoPokerMenuViewModel(model, user);
            viewModel.setMainApp(this);
            view.setViewModel(viewModel);
            view.bind();
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showVideoPokerGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("videopoker/VideoPokerGame.fxml"));
            Parent root;
            root = loader.load();
            VideoPokerGameController view = loader.getController();
            VideoPokerGameModel model = new VideoPokerGameModel(user);
            VideoPokerGameViewModel viewModel = new VideoPokerGameViewModel(model);
            viewModel.setMainApp(this);
            model.AddPropertyChangeListener(viewModel);
            view.setViewModel(viewModel);
            view.bind();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void showVideoPokerHilfe() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("videopoker/VideoPokerHilfe.fxml"));
            Parent root;
            root = loader.load();
            VideoPokerHilfeController view = loader.getController();
            view.setMainApp(this);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
