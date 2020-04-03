/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

/**
 *
 * @author misch
 */
public class VideoPokerMenuViewModel {
    private VideoPokerMenuModel model;
    private VideoPoker mainApp;
    public VideoPokerMenuViewModel(VideoPokerMenuModel model) {
        this.model = model;
        
    }
    
    public void startAction(){
       
        mainApp.showGame();
        
    }

    public void setMainApp(VideoPoker mainApp) {
        this.mainApp = mainApp;
    }
    
}
