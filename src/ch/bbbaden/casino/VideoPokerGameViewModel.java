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
public class VideoPokerGameViewModel {
    private VideoPokerGameModel model;
    private VideoPoker mainApp;

    public VideoPokerGameViewModel(VideoPokerGameModel model) {
        this.model = model;
    }
    
    public void setMainApp(VideoPoker mainApp) {
        this.mainApp = mainApp;
    }
    
    
}
