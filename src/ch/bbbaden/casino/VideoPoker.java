/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

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
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/VideoPokerMenu.fxml"));
        Parent root;
        root = loader.load();
        VideoPokerMenuController view = loader.getController();
        VideoPokerMenuModel model= new VideoPokerMenuModel();
        VideoPokerMenuViewModel viewModel = new  VideoPokerMenuViewModel(model);
        
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        /*
         FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root;
        root = loader.load();
        FXMLDocumentController view = loader.getController();
        Model model = new Model();
        final ViewModel viewModel = new ViewModel(model);
        view.setVm(viewModel);
        model.AddPropertyChangeListener(viewModel);
        view.bind();
        
        final Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void showGame(){
    
    }
    
}
