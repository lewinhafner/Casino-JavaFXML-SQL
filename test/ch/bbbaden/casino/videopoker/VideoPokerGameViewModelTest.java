/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.videopoker;

import ch.bbbaden.casino.MainApp;
import ch.bbbaden.casino.User;
import java.beans.PropertyChangeEvent;
import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author misch
 */
public class VideoPokerGameViewModelTest {
    
    public VideoPokerGameViewModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCoinVal method, of class VideoPokerGameViewModel.
     */
    @Test
    public void testGetCoinVal() {
      //Arrange
      User user= new User(8,"MischaF","Mischa","Fischer", "12345", 10000000,"sdf@asfd.sdc", "player", 19);
      VideoPokerGameModel model = new VideoPokerGameModel(user);
      VideoPokerGameViewModel vm = new VideoPokerGameViewModel(model);
      String ausgabe;
      //Act
      
      System.out.println(vm.getCoinVal().getValue());
      vm.setCoinVal();
      
      vm.setCoinVal();
      System.out.println(vm.getCoinVal().getValue());
      //ausgabe = Double.parseDouble(vm.getCoinVal().toString());
      //Assert
      //assertEquals(0.5, ausgabe, 0.0);
    }
    
}
