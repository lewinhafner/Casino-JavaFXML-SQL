/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author misch
 */
public class VideoPoker extends Application {
    Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
      
       this.stage = stage;
       showMenu();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void showMenu(){
         try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("VideoPokerMenu.fxml"));
        Parent root;
        root = loader.load();
        VideoPokerMenuController view = loader.getController();
        VideoPokerMenuModel model= new VideoPokerMenuModel();
        VideoPokerMenuViewModel viewModel = new  VideoPokerMenuViewModel(model);
        viewModel.setMainApp(this);
        view.setViewModel(viewModel);
        
        
        
       final Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(VideoPoker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showGame(){  
        System.out.println("dcvsdv");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VideoPokerGame.fxml"));
            Parent root;
            root = loader.load();
            VideoPokerGameController view = loader.getController();
            VideoPokerGameModel model= new VideoPokerGameModel();
            VideoPokerGameViewModel viewModel = new  VideoPokerGameViewModel(model);
            viewModel.setMainApp(this);
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(VideoPoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
