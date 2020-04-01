/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import java.util.ArrayList;

/**
 *
 * @author misch
 */
public class VideoPokerGameModel {
    ArrayList<Card> deck = new ArrayList<>();
    
    public void generateCards(){
        for(Color color : Color.values()){
            for(Rank rank : Rank.values()){
                deck.add(new Card(rank,color));
            }
        }
    }
}
