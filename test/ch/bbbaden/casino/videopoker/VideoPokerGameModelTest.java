/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.videopoker;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
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
public class VideoPokerGameModelTest {
    
    public VideoPokerGameModelTest() {
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
     * Test of AddPropertyChangeListener method, of class VideoPokerGameModel.
     */
    @Test
    public void testAddPropertyChangeListener() {
        System.out.println("AddPropertyChangeListener");
        PropertyChangeListener listener = null;
        VideoPokerGameModel instance = null;
        instance.AddPropertyChangeListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateCards method, of class VideoPokerGameModel.
     */
    @Test
    public void testGenerateCards() {
        System.out.println("generateCards");
        VideoPokerGameModel instance = null;
        instance.generateCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class VideoPokerGameModel.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        VideoPokerGameModel instance = null;
        double expResult = 0.0;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of coinAnzBet1 method, of class VideoPokerGameModel.
     */
    @Test
    public void testCoinAnzBet1() {
        System.out.println("coinAnzBet1");
        VideoPokerGameModel instance = null;
        instance.coinAnzBet1();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of coinAnzBet5 method, of class VideoPokerGameModel.
     */
    @Test
    public void testCoinAnzBet5() {
        System.out.println("coinAnzBet5");
        VideoPokerGameModel instance = null;
        instance.coinAnzBet5();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoinVal method, of class VideoPokerGameModel.
     */
    @Test
    public void testSetCoinVal() {
        System.out.println("setCoinVal");
        VideoPokerGameModel instance = null;
        instance.setCoinVal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deal method, of class VideoPokerGameModel.
     */
    @Test
    public void testDeal() {
        System.out.println("deal");
        VideoPokerGameModel instance = null;
        instance.deal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gamble method, of class VideoPokerGameModel.
     */
    @Test
    public void testGamble() {
        System.out.println("gamble");
        VideoPokerGameModel instance = null;
        instance.gamble();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vergleicheCardsGamble method, of class VideoPokerGameModel.
     */
    @Test
    public void testVergleicheCardsGamble() {
        System.out.println("vergleicheCardsGamble");
        int i = 0;
        VideoPokerGameModel instance = null;
        instance.vergleicheCardsGamble(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gewinnUeberpruefung method, of class VideoPokerGameModel.
     */
    @Test
    public void testGewinnUeberpruefung() {
        System.out.println("gewinnUeberpruefung");
        VideoPokerGameModel instance = null;
        instance.gewinnUeberpruefung();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of card1Hold method, of class VideoPokerGameModel.
     */
    @Test
    public void testCard1Hold() {
        System.out.println("card1Hold");
        int i = 0;
        VideoPokerGameModel instance = null;
        instance.card1Hold(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardsOnTable method, of class VideoPokerGameModel.
     */
    @Test
    public void testGetCardsOnTable() {
        System.out.println("getCardsOnTable");
        VideoPokerGameModel instance = null;
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getCardsOnTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
