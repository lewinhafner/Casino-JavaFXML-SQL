/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.videopoker;

import ch.bbbaden.casino.MainApp;

/**
 *
 * @author misch
 */
public class VideoPokerMenuViewModel {
    private VideoPokerMenuModel model;
    private MainApp mainApp;
    public VideoPokerMenuViewModel(VideoPokerMenuModel model) {
        this.model = model;
        
    }
    
    public void startAction(){
       
        mainApp.showVideoPokerGame();
        
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
}
