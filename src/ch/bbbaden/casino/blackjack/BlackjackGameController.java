package ch.bbbaden.casino.blackjack;

import ch.bbbaden.casino.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Shenia Scherer
 */
public class BlackjackGameController implements Initializable {

    //--DECLARING AND INITIALIZING VARIABLE--//
    private BlackjackGameViewModel vm;
    ArrayList<Card> cardsplayer = new ArrayList<>();
    ArrayList<Card> cardsdealer = new ArrayList<>();
    private int playersum = 0;
    private int dealersum = 0;
    private int cardstakenP = 0;
    private int cardstakenD = 1;
    private double amountsum = 0;
    private boolean play = true;
    private boolean standactive = false;
    private boolean hitactive = false;
    private boolean doubleTrue = false;
    private int insurance = 0;
    private boolean insuranceCheck = false;
    private int score = 0;
    private boolean hasAce = false;
    private User user;

    //--DEFINE CARDS--//
    IntegerProperty card1 = new SimpleIntegerProperty();
    IntegerProperty card2 = new SimpleIntegerProperty();
    IntegerProperty card3 = new SimpleIntegerProperty();
    IntegerProperty card4 = new SimpleIntegerProperty();
    IntegerProperty card5 = new SimpleIntegerProperty();
    IntegerProperty card6 = new SimpleIntegerProperty();
    IntegerProperty card7 = new SimpleIntegerProperty();
    IntegerProperty card8 = new SimpleIntegerProperty();
    IntegerProperty card9 = new SimpleIntegerProperty();
    IntegerProperty card10 = new SimpleIntegerProperty();
    IntegerProperty cardDouble = new SimpleIntegerProperty();

    @FXML
    private Button doublebtn;
    @FXML
    private Button standbtn;
    @FXML
    private Button hitbtn;
    @FXML
    private Button menubtn;
    @FXML
    private ImageView cardP1;
    @FXML
    private ImageView cardP2;
    @FXML
    private ImageView cardD1;
    @FXML
    private ImageView cardD2;
    @FXML
    private ImageView cardD3;
    @FXML
    private ImageView cardD4;
    @FXML
    private ImageView cardD5;
    @FXML
    private ImageView cardP3;
    @FXML
    private ImageView cardP4;
    @FXML
    private ImageView cardP5;
    @FXML
    private Button playBtn;
    @FXML
    private Button resetbtn;
    @FXML
    private Label doublelbl;
    @FXML
    private Label resultlbl;
    @FXML
    private Label scorelbl;
    @FXML
    private Label totalDealerlbl;
    @FXML
    private Label totalPlayerlbl;
    @FXML
    private TextField amountxt;
    @FXML
    private ImageView doubleCard;
    @FXML
    private Button insurancebtn;
    @FXML
    private TextField insurnacetxt;
    @FXML
    private Label creditlbl;
    @FXML
    private ImageView cardDHide;

    //--INITIALIZING THE BUTTONS--//
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        doublebtn.setVisible(false);

        doublebtn.setDisable(true);

        insurancebtn.setDisable(true);
        insurancebtn.setVisible(false);
        insurnacetxt.setDisable(true);
        insurnacetxt.setVisible(false);

        

    }

    public void setViewModel(BlackjackGameViewModel vm) {
        this.vm = vm;
    }

    //--BINDING--//
    public void bind() {
        card1.bind(vm.getCardP1());
        card2.bind(vm.getCardD1());
        card3.bind(vm.getCardP2());
        card4.bind(vm.getCardD2());
        card5.bind(vm.getCardP3());
        card6.bind(vm.getCardD3());
        card7.bind(vm.getCardP4());
        card8.bind(vm.getCardD4());
        card9.bind(vm.getCardP5());
        card10.bind(vm.getCardD5());
        cardDouble.bind(vm.getCardDouble());

    }

    public void setUser(User user) {
        this.user = user;
        creditlbl.setText(Double.toString(user.getBalance()));
    }
    

    /*When play button is clicked 
    Two cards of Player and Dealer is shown. The Sum of the cards Value will be counted. 
    Double button is shown when, the sum is 9, 10 or 11
     */
    @FXML
    private void playAction(ActionEvent event) {
        if (play == true) {
            try {
                amountsum = Double.parseDouble(amountxt.getText());
                double oldBalance = user.getBalance();
                double newBalance = user.getBalance() - amountsum;
                user.setBalance(newBalance);
                creditlbl.setText(Double.toString(user.getBalance()));
                vm.setAmount(amountsum);
                standactive = true;
                hitactive = true;

                vm.play();
                cardsPlayer(card1, cardP1, "cards", 11);
                cardsDealer(card2, cardD1, "cards", 11);

                //Check the ace Value
                if (cardsplayer.get(0).getValue() == 11) {
                    cardsPlayer(card3, cardP2, "cards", 1);
                } else {
                    cardsPlayer(card3, cardP2, "cards", 11);
                }

                //Check the ace Value
                if (cardsdealer.get(0).getValue() == 11) {
                    cardsDealer(card4, cardD2, "cards", 1);
                } else {
                    cardsDealer(card4, cardD2, "cards", 11);
                }
                cardDHide.setImage(new Image("cards/CardBack.png"));

                if (cardsdealer.get(0).getValue() == 11) {
                    insurancebtn.setDisable(false);
                    insurancebtn.setVisible(true);
                    insurnacetxt.setDisable(false);
                    insurnacetxt.setVisible(true);
                }

                playersum = 0;
                //--PLAYER SUMME--//
                for (int i = 0; i < cardsplayer.size(); i++) {
                    playersum += cardsplayer.get(i).getValue();
                }
                if (playersum > 20) {
                    stand();
                }

                totalPlayerlbl.setText(Integer.toString(playersum));

                //--DEALER SUMME--//
                for (int i = 0; i < cardsdealer.size(); i++) {
                    dealersum += cardsdealer.get(i).getValue();
                }
                totalDealerlbl.setText(Integer.toString(cardsdealer.get(0).getValue()));
                dealersum = 0;

                play = false;

                playersum = 0;
                for (int i = 0; i < cardsplayer.size(); i++) {
                    playersum += cardsplayer.get(i).getValue();
                }

                //--DOUBLE BUTTON--//
                if (playersum > 8 && playersum < 12) {
                    doublebtn.setVisible(true);

                    doublebtn.setDisable(false);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount, please give a valid amount.");
            }
        } else {
            System.out.println("Invalid amount, please give a valid amount.");
        }
    }

    //rewrite to model
    //When hit button is clicked
    @FXML
    private void hitAction(ActionEvent event) {
        System.out.println(playersum);
        if (playersum < 21 && hitactive == true) {
            vm.hitAction(cardstakenP);
            switch (cardstakenP) {
                case 2:

                    //Ace value
                    playersum = 0;
                    for (int i = 0; i < cardsplayer.size(); i++) {
                        playersum += cardsplayer.get(i).getValue();
                    }
                    if (playersum > 10) {
                        cardsPlayer(card5, cardP3, "cards", 1);
                    } else {
                        cardsPlayer(card5, cardP3, "cards", 11);
                    }

                    playersum = 0;
                    for (int i = 0; i < cardsplayer.size(); i++) {
                        playersum += cardsplayer.get(i).getValue();
                    }
                    if (playersum > 20) {
                        stand();
                    } else {
                        System.out.print("");
                    }
                    break;
                case 3:

                    //Ace value
                    playersum = 0;
                    for (int i = 0; i < cardsplayer.size(); i++) {
                        playersum += cardsplayer.get(i).getValue();
                    }
                    if (playersum > 10) {
                        cardsPlayer(card7, cardP4, "cards", 1);
                    } else {
                        cardsPlayer(card7, cardP4, "cards", 11);
                    }

                    for (int i = 0; i < cardsplayer.size(); i++) {
                        playersum += cardsplayer.get(i).getValue();
                    }
                    if (playersum > 20) {
                        stand();
                    } else {
                        System.out.print("");
                    }
                    break;
                case 4:

                    //Ace value
                    playersum = 0;
                    for (int i = 0; i < cardsplayer.size(); i++) {
                        playersum += cardsplayer.get(i).getValue();
                    }
                    if (playersum > 10) {
                        cardsPlayer(card9, cardP5, "cards", 1);
                    } else {
                        cardsPlayer(card9, cardP5, "cards", 11);
                    }

                    for (int i = 0; i < cardsplayer.size(); i++) {
                        playersum += cardsplayer.get(i).getValue();
                    }
                    if (playersum > 20) {
                        stand();
                    } else {
                        System.out.print("");
                    }
                    break;
            }
            playersum = 0;
            for (int i = 0; i < cardsplayer.size(); i++) {
                playersum += cardsplayer.get(i).getValue();
            }
            totalPlayerlbl.setText(Integer.toString(playersum));
        } else {
            System.out.println("Invalid input, please try again.");
        }
    }

    //rewrite to model
    //When Stand button is clicked
    @FXML
    private void standAction(ActionEvent event) {
        if (standactive == true) {
            dealersum = 0;
            for (int i = 0; i < cardsdealer.size(); i++) {
                dealersum += cardsdealer.get(i).getValue();
            }
            vm.standAction(dealersum, cardstakenD);
            cardDHide.setImage(null);

            //Ace Value
            dealersum = 0;
            for (int i = 0; i < cardsdealer.size(); i++) {
                dealersum += cardsdealer.get(i).getValue();
            }
            if (dealersum > 10) {
                cardsDealer(card6, cardD3, "cards", 1);
            } else {
                cardsDealer(card6, cardD3, "cards", 11);
            }

            //new dealersum
            dealersum = 0;
            for (int i = 0; i < cardsdealer.size(); i++) {
                dealersum += cardsdealer.get(i).getValue();
            }

            playersum = 0;
            for (int i = 0; i < cardsplayer.size(); i++) {
                playersum += cardsplayer.get(i).getValue();
            }
            if (playersum > 21) {
                dealersum = 0;
                for (int i = 0; i < cardsdealer.size(); i++) {
                    dealersum += cardsdealer.get(i).getValue();
                }
            } else {
                //if sum <17 then new card
                if (dealersum < 17) {
                    vm.standAction(dealersum, cardstakenD);

                    //Ace value
                    dealersum = 0;
                    for (int i = 0; i < cardsdealer.size(); i++) {
                        dealersum += cardsdealer.get(i).getValue();
                    }
                    if (dealersum > 10) {
                        cardsDealer(card8, cardD4, "cards", 1);
                    } else {
                        cardsDealer(card8, cardD4, "cards", 11);
                    }

                    dealersum = 0;
                    for (int i = 0; i < cardsdealer.size(); i++) {
                        dealersum += cardsdealer.get(i).getValue();
                    }

                    if (dealersum < 17) {
                        vm.standAction(dealersum, cardstakenD);

                        //Ace value
                        dealersum = 0;
                        for (int i = 0; i < cardsdealer.size(); i++) {
                            dealersum += cardsdealer.get(i).getValue();
                        }

                        if (dealersum > 10) {
                            cardsDealer(card10, cardD5, "cards", 1);
                        } else {
                            cardsDealer(card10, cardD5, "cards", 11);
                        }

                        dealersum = 0;
                        for (int i = 0; i < cardsdealer.size(); i++) {
                            dealersum += cardsdealer.get(i).getValue();
                        }
                    }
                }
            }

            totalDealerlbl.setText(Integer.toString(dealersum));

            dealersum = 0;
            for (int i = 0; i < cardsdealer.size(); i++) {
                dealersum += cardsdealer.get(i).getValue();
            }

            playersum = 0;
            for (int i = 0; i < cardsplayer.size(); i++) {
                playersum += cardsplayer.get(i).getValue();
            }

            checkAll(playersum, dealersum);
            standactive = false;
            hitactive = false;
        }

    }

    //When player goes over 21 or when player click double 
    private void stand() {
        if (doubleTrue == true) {
            dealersum = 0;
            for (int i = 0; i < cardsdealer.size(); i++) {
                dealersum += cardsdealer.get(i).getValue();
            }
            vm.standAction(dealersum, cardstakenD);
            cardDHide.setImage(null);

            //new dealersum
            dealersum = 0;
            for (int i = 0; i < cardsdealer.size(); i++) {
                dealersum += cardsdealer.get(i).getValue();
            }

            playersum = 0;
            for (int i = 0; i < cardsplayer.size(); i++) {
                playersum += cardsplayer.get(i).getValue();
            }
            if (playersum > 21) {
                dealersum = 0;
                for (int i = 0; i < cardsdealer.size(); i++) {
                    dealersum += cardsdealer.get(i).getValue();
                }
            } else {

                //Ace value and if dealersum < 17 then new card
                dealersum = 0;
                for (int i = 0; i < cardsdealer.size(); i++) {
                    dealersum += cardsdealer.get(i).getValue();
                }
                if (dealersum > 10) {
                    cardsDealer(card3, cardD3, "cards", 1);
                } else {
                    cardsDealer(card3, cardD3, "cards", 11);
                }

                dealersum = 0;
                for (int i = 0; i < cardsdealer.size(); i++) {
                    dealersum += cardsdealer.get(i).getValue();
                }
                if (dealersum < 17) {
                    vm.standAction(dealersum, cardstakenD);

                    //Ace value
                    dealersum = 0;
                    for (int i = 0; i < cardsdealer.size(); i++) {
                        dealersum += cardsdealer.get(i).getValue();
                    }
                    if (dealersum > 10) {
                        cardsDealer(card8, cardD4, "cards", 1);
                    } else {
                        cardsDealer(card8, cardD4, "cards", 11);
                    }

                    dealersum = 0;
                    for (int i = 0; i < cardsdealer.size(); i++) {
                        dealersum += cardsdealer.get(i).getValue();
                    }

                    if (dealersum < 17) {
                        vm.standAction(dealersum, cardstakenD);

                        //Ace value
                        dealersum = 0;
                        for (int i = 0; i < cardsdealer.size(); i++) {
                            dealersum += cardsdealer.get(i).getValue();
                        }
                        if (dealersum > 10) {
                            cardsDealer(card10, cardD5, "cards", 1);
                        } else {
                            cardsDealer(card10, cardD5, "cards", 11);
                        }

                        dealersum = 0;
                        for (int i = 0; i < cardsdealer.size(); i++) {
                            dealersum += cardsdealer.get(i).getValue();
                        }
                    }
                }
                totalDealerlbl.setText(Integer.toString(dealersum));

                playersum = 0;
                for (int i = 0; i < cardsplayer.size(); i++) {
                    playersum += cardsplayer.get(i).getValue();
                }
                checkAll(playersum, dealersum);
            }
        } else {
            if (standactive == true) {
                dealersum = 0;
                for (int i = 0; i < cardsdealer.size(); i++) {
                    dealersum += cardsdealer.get(i).getValue();
                }
                vm.standAction(dealersum, cardstakenD);
                cardDHide.setImage(null);

                //new dealersum
                dealersum = 0;
                for (int i = 0; i < cardsdealer.size(); i++) {
                    dealersum += cardsdealer.get(i).getValue();
                }

                //if sum <17 then new card
                if (dealersum < 17) {
                    vm.standAction(dealersum, cardstakenD);

                    //Ace value 
                    dealersum = 0;
                    for (int i = 0; i < cardsdealer.size(); i++) {
                        dealersum += cardsdealer.get(i).getValue();
                    }
                    if (dealersum > 10) {
                        cardsDealer(card8, cardD4, "cardsDealer", 1);
                    } else {
                        cardsDealer(card8, cardD4, "cardsDealer", 11);
                    }

                    dealersum = 0;
                    for (int i = 0; i < cardsdealer.size(); i++) {
                        dealersum += cardsdealer.get(i).getValue();
                    }

                    if (dealersum < 17) {
                        vm.standAction(dealersum, cardstakenD);

                        //Ace value
                        dealersum = 0;
                        for (int i = 0; i < cardsdealer.size(); i++) {
                            dealersum += cardsdealer.get(i).getValue();
                        }
                        if (dealersum > 10) {
                            cardsDealer(card10, cardD5, "cardsDealer", 1);
                        } else {
                            cardsDealer(card10, cardD5, "cardsDealer", 11);
                        }

                        dealersum = 0;
                        for (int i = 0; i < cardsdealer.size(); i++) {
                            dealersum += cardsdealer.get(i).getValue();
                        }
                    }
                }
                totalDealerlbl.setText(Integer.toString(dealersum));

                dealersum = 0;
                for (int i = 0; i < cardsdealer.size(); i++) {
                    dealersum += cardsdealer.get(i).getValue();
                }

                playersum = 0;
                for (int i = 0; i < cardsplayer.size(); i++) {
                    playersum += cardsplayer.get(i).getValue();
                }

                checkAll(playersum, dealersum);
                standactive = false;
                hitactive = false;
            }
            totalDealerlbl.setText(Integer.toString(dealersum));

            dealersum = 0;
            for (int i = 0; i < cardsdealer.size(); i++) {
                dealersum += cardsdealer.get(i).getValue();
            }

            playersum = 0;
            for (int i = 0; i < cardsplayer.size(); i++) {
                playersum += cardsplayer.get(i).getValue();
            }

            checkAll(playersum, dealersum);
            standactive = false;
            hitactive = false;
        }

    }

    @FXML
    private void menuAction(ActionEvent event) throws IOException {
        vm.goToMenu();
    }

    //Double inserted amount and 3rd card is taken
    @FXML
    private void doubleAction(MouseEvent event) {

        //Counts the Amount twice
        doubleTrue = true;
        int amount = Integer.parseInt(this.amountxt.getText());
        int doubleamount = amount * 2;
        doublelbl.setText(String.valueOf(doubleamount));
        vm.cardDouble();
        playersum = 0;
        for (int i = 0; i < cardsplayer.size(); i++) {
            playersum += cardsplayer.get(i).getValue();
        }
        if (playersum > 10) {
            cardsPlayer(cardDouble, doubleCard, "DoubleCards", 1);
        } else {
            cardsPlayer(cardDouble, doubleCard, "DoubleCards", 11);
        }
        hitbtn.setDisable(true);
        standbtn.setDisable(true);

        playersum = 0;
        for (int i = 0; i < cardsplayer.size(); i++) {
            playersum += cardsplayer.get(i).getValue();
        }
        totalPlayerlbl.setText(Integer.toString(playersum));
        stand();
    }

    /*
    Check if player won, loses or ties and put credit to the Database
    Resets and player can play again
     */
    private void checkAll(int summeP, int summeD) {
        boolean NegativeP = false;
        boolean NegativeD = false;
        if (insuranceCheck == true) {
            insurance(insurance);
        } else {

        }
        if (doubleTrue) {
            if (21 - summeP < 0) {
                NegativeP = true;
                resultlbl.setText("YOU LOST!!");
                double newBalance = user.getBalance() - amountsum;
                user.setBalance(newBalance);
                creditlbl.setText(Double.toString(user.getBalance()));
                user.updateStatistics(5, amountsum*2, resultlbl.getText(), -amountsum*2);
            } else {
                NegativeP = false;
            }
            if (21 - summeD < 0) {
                NegativeD = true;
                resultlbl.setText("YOU WON!!");
                double newBalance = user.getBalance() + amountsum *3;
                user.setBalance(newBalance);
                creditlbl.setText(Double.toString(user.getBalance()));
                 user.updateStatistics(5, amountsum*2, resultlbl.getText(), amountsum*2);
            } else {
                NegativeD = false;
            }
            if (NegativeP == false && NegativeD == false) {
                if (21 - summeP < 21 - summeD) {
                    resultlbl.setText("YOU WON!");
                     double newBalance = user.getBalance() + amountsum *3;
                    user.setBalance(newBalance);
                    creditlbl.setText(Double.toString(user.getBalance()));
                    user.updateStatistics(5, amountsum*2, resultlbl.getText(), amountsum*2);
                } else if (21 - summeP > 21 - summeD) {
                    resultlbl.setText("YOU LOST!!");
                    double newBalance = user.getBalance() - amountsum;
                    user.setBalance(newBalance);
                    creditlbl.setText(Double.toString(user.getBalance()));
                     user.updateStatistics(5, amountsum*2, resultlbl.getText(), -amountsum*2);
                } else {
                    resultlbl.setText("TIE!");
                    double newBalance = user.getBalance() + amountsum;
                    user.setBalance(newBalance);
                    creditlbl.setText(Double.toString(user.getBalance()));
                     user.updateStatistics(5, amountsum*2, resultlbl.getText(), 0);
                }
            }
        } else {
            if (21 - summeP < 0) {
                NegativeP = true;
                resultlbl.setText("YOU LOST!!");
                user.updateStatistics(5, amountsum, resultlbl.getText(), -amountsum);
            } else {
                NegativeP = false;
            }
            if (21 - summeD < 0) {
                NegativeD = true;
                resultlbl.setText("YOU WON!!");
                double newBalance = user.getBalance() + amountsum *2;
                user.setBalance(newBalance);
                creditlbl.setText(Double.toString(user.getBalance()));
                user.updateStatistics(5, amountsum, resultlbl.getText(), amountsum);
            } else {
                NegativeD = false;
            }
            if (NegativeP == false && NegativeD == false) {
                if (21 - summeP < 21 - summeD) {
                    resultlbl.setText("YOU WON!!");
                    double newBalance = user.getBalance() + amountsum *2;
                    user.setBalance(newBalance);
                    creditlbl.setText(Double.toString(user.getBalance()));
                    user.updateStatistics(5, amountsum, resultlbl.getText(), amountsum);
                } else if (21 - summeP > 21 - summeD) {
                    resultlbl.setText("YOU LOST!!");
                    user.updateStatistics(5, amountsum, resultlbl.getText(), -amountsum);
                    
                } else {
                    resultlbl.setText("TIE!");
                     double newBalance = user.getBalance() + amountsum;
                    user.setBalance(newBalance);
                    creditlbl.setText(Double.toString(user.getBalance()));
                    user.updateStatistics(5, amountsum, resultlbl.getText(), 0);
                }
            }
        }
    }

    //Resets everything, when reset button is clicked
    //When Insurnace button is clicked
    @FXML
    private void insuranceAction(ActionEvent event) {
        if (insurnacetxt.getText().isEmpty()) {

        } else {
            insurancebtn.textFillProperty().set(Color.MAROON);
            insuranceCheck = true;
            insurance = Integer.parseInt(insurnacetxt.getText());
            System.out.println("You clicked Insurance.");
        }
    }

    //When dealer has 21, credit will be either reducted or increased
    private void insurance(int credit) {
        dealersum = 0;
        for (int i = 0; i < cardsdealer.size(); i++) {
            dealersum += cardsdealer.get(i).getValue();
        }
        if (dealersum == 21) {
            double newBalance = user.getBalance() + credit + amountsum;
            user.setBalance(newBalance);
            creditlbl.setText(Double.toString(user.getBalance()));
            user.updateStatistics(5, amountsum+credit, "Versicherungs gewinn", amountsum*2+credit);
        } else {
            double newBalance = user.getBalance() - credit + amountsum;
            user.setBalance(newBalance);
            creditlbl.setText(Double.toString(user.getBalance()));
            user.updateStatistics(5, amountsum+credit, "Versicherungs verloren", -amountsum-credit);
        }
    }

    private void scorePlayer() {

    }

    @FXML
    private void ResetAction(ActionEvent event) {
        play = true;
        cardsplayer.clear();
        cardsdealer.clear();
        playersum = 0;
        dealersum = 0;
        cardstakenP = 0;
        cardstakenD = 0;
        hitactive = false;
        standactive = false;
        hitbtn.setDisable(false);
        standbtn.setDisable(false);

        totalDealerlbl.setText(Integer.toString(dealersum));
        totalPlayerlbl.setText(Integer.toString(playersum));
        resultlbl.setText("");
        amountxt.setText("");

        doublelbl.setText("");
        doubleCard.setImage(null);
        doublebtn.setVisible(false);

        cardD1.setImage(null);
        cardD2.setImage(null);
        cardD3.setImage(null);
        cardD4.setImage(null);
        cardD5.setImage(null);
        cardP1.setImage(null);
        cardP2.setImage(null);
        cardP3.setImage(null);
        cardP4.setImage(null);
        cardP5.setImage(null);

        insurnacetxt.setVisible(false);
        insurnacetxt.setText("");
        insurancebtn.setVisible(false);
        insurancebtn.textFillProperty().set(Color.WHITE);
        insuranceCheck = false;
        insurance = 0;

    }

    //Cards of Player
    private void cardsPlayer(IntegerProperty card, ImageView cardView, String set, int aceValue) {
        cardstakenP++;
        switch (card.get()) {
            case 1:
                cardView.setImage(new Image(set + "/2C.png"));
                cardsplayer.add(new Card(1, 2));
                break;
            case 2:
                cardView.setImage(new Image(set + "/2D.png"));
                cardsplayer.add(new Card(2, 2));
                break;
            case 3:
                cardView.setImage(new Image(set + "/2H.png"));
                cardsplayer.add(new Card(3, 2));
                break;
            case 4:
                cardView.setImage(new Image(set + "/2S.png"));
                cardsplayer.add(new Card(4, 2));
                break;
            case 5:
                cardView.setImage(new Image(set + "/3C.png"));
                cardsplayer.add(new Card(5, 3));
                break;
            case 6:
                cardView.setImage(new Image(set + "/3D.png"));
                cardsplayer.add(new Card(6, 3));
                break;
            case 7:
                cardView.setImage(new Image(set + "/3H.png"));
                cardsplayer.add(new Card(7, 3));
                break;
            case 8:
                cardView.setImage(new Image(set + "/3S.png"));
                cardsplayer.add(new Card(8, 3));
                break;
            case 9:
                cardView.setImage(new Image(set + "/4C.png"));
                cardsplayer.add(new Card(9, 4));
                break;
            case 10:
                cardView.setImage(new Image(set + "/4D.png"));
                cardsplayer.add(new Card(10, 4));
                break;
            case 11:
                cardView.setImage(new Image(set + "/4H.png"));
                cardsplayer.add(new Card(11, 4));
                break;
            case 12:
                cardView.setImage(new Image(set + "/4S.png"));
                cardsplayer.add(new Card(12, 4));
                break;
            case 13:
                cardView.setImage(new Image(set + "/5C.png"));
                cardsplayer.add(new Card(13, 5));
                break;
            case 14:
                cardView.setImage(new Image(set + "/5D.png"));
                cardsplayer.add(new Card(14, 5));
                break;
            case 15:
                cardView.setImage(new Image(set + "/5H.png"));
                cardsplayer.add(new Card(15, 5));
                break;
            case 16:
                cardView.setImage(new Image(set + "/5S.png"));
                cardsplayer.add(new Card(16, 5));
                break;
            case 17:
                cardView.setImage(new Image(set + "/6C.png"));
                cardsplayer.add(new Card(17, 6));
                break;
            case 18:
                cardView.setImage(new Image(set + "/6D.png"));
                cardsplayer.add(new Card(18, 6));
                break;
            case 19:
                cardView.setImage(new Image(set + "/6H.png"));
                cardsplayer.add(new Card(19, 6));
                break;
            case 20:
                cardView.setImage(new Image(set + "/6S.png"));
                cardsplayer.add(new Card(20, 6));
                break;
            case 21:
                cardView.setImage(new Image(set + "/7C.png"));
                cardsplayer.add(new Card(21, 7));
                break;
            case 22:
                cardView.setImage(new Image(set + "/7D.png"));
                cardsplayer.add(new Card(22, 7));
                break;
            case 23:
                cardView.setImage(new Image(set + "/7H.png"));
                cardsplayer.add(new Card(23, 7));
                break;
            case 24:
                cardView.setImage(new Image(set + "/7S.png"));
                cardsplayer.add(new Card(24, 7));
                break;
            case 25:
                cardView.setImage(new Image(set + "/8C.png"));
                cardsplayer.add(new Card(25, 8));
                break;
            case 26:
                cardView.setImage(new Image(set + "/8D.png"));
                cardsplayer.add(new Card(26, 8));
                break;
            case 27:
                cardView.setImage(new Image(set + "/8H.png"));
                cardsplayer.add(new Card(27, 8));
                break;
            case 28:
                cardView.setImage(new Image(set + "/8S.png"));
                cardsplayer.add(new Card(28, 8));
                break;
            case 29:
                cardView.setImage(new Image(set + "/9C.png"));
                cardsplayer.add(new Card(29, 9));
                break;
            case 30:
                cardView.setImage(new Image(set + "/9D.png"));
                cardsplayer.add(new Card(30, 9));
                break;
            case 31:
                cardView.setImage(new Image(set + "/9H.png"));
                cardsplayer.add(new Card(31, 9));
                break;
            case 32:
                cardView.setImage(new Image(set + "/9S.png"));
                cardsplayer.add(new Card(32, 9));
                break;
            case 33:
                cardView.setImage(new Image(set + "/10C.png"));
                cardsplayer.add(new Card(33, 10));
                break;
            case 34:
                cardView.setImage(new Image(set + "/10D.png"));
                cardsplayer.add(new Card(34, 10));
                break;
            case 35:
                cardView.setImage(new Image(set + "/10H.png"));
                cardsplayer.add(new Card(35, 10));
                break;
            case 36:
                cardView.setImage(new Image(set + "/10S.png"));
                cardsplayer.add(new Card(36, 10));
                break;
            case 37:
                cardView.setImage(new Image(set + "/AC.png"));
                cardsplayer.add(new Card(37, aceValue));
                break;
            case 38:
                cardView.setImage(new Image(set + "/AD.png"));
                cardsplayer.add(new Card(38, aceValue));
                break;
            case 39:
                cardView.setImage(new Image(set + "/AH.png"));
                cardsplayer.add(new Card(39, aceValue));
                break;
            case 40:
                cardView.setImage(new Image(set + "/AS.png"));
                cardsplayer.add(new Card(40, aceValue));
                break;
            case 41:
                cardView.setImage(new Image(set + "/JC.png"));
                cardsplayer.add(new Card(41, 10));
                break;
            case 42:
                cardView.setImage(new Image(set + "/JD.png"));
                cardsplayer.add(new Card(42, 10));
                break;
            case 43:
                cardView.setImage(new Image(set + "/JH.png"));
                cardsplayer.add(new Card(43, 10));
                break;
            case 44:
                cardView.setImage(new Image(set + "/JS.png"));
                cardsplayer.add(new Card(44, 10));
                break;
            case 45:
                cardView.setImage(new Image(set + "/KC.png"));
                cardsplayer.add(new Card(45, 10));
                break;
            case 46:
                cardView.setImage(new Image(set + "/KD.png"));
                cardsplayer.add(new Card(46, 10));
                break;
            case 47:
                cardView.setImage(new Image(set + "/KH.png"));
                cardsplayer.add(new Card(47, 10));
                break;
            case 48:
                cardView.setImage(new Image(set + "/KS.png"));
                cardsplayer.add(new Card(48, 10));
                break;
            case 49:
                cardView.setImage(new Image(set + "/QC.png"));
                cardsplayer.add(new Card(49, 10));
                break;
            case 50:
                cardView.setImage(new Image(set + "/QD.png"));
                cardsplayer.add(new Card(50, 10));
                break;
            case 51:
                cardView.setImage(new Image(set + "/QH.png"));
                cardsplayer.add(new Card(51, 10));
                break;
            case 52:
                cardView.setImage(new Image(set + "/QS.png"));
                cardsplayer.add(new Card(51, 10));
                break;
            default:
                System.out.println("Card 0");
                break;
        }
    }

    //Cards of Dealer
    private void cardsDealer(IntegerProperty card, ImageView cardView, String set, int aceValue) {
        cardstakenD++;
        switch (card.get()) {
            case 1:
                cardView.setImage(new Image(set + "/2C.png"));
                cardsdealer.add(new Card(1, 2));
                break;
            case 2:
                cardView.setImage(new Image(set + "/2D.png"));
                cardsdealer.add(new Card(2, 2));
                break;
            case 3:
                cardView.setImage(new Image(set + "/2H.png"));
                cardsdealer.add(new Card(3, 2));
                break;
            case 4:
                cardView.setImage(new Image(set + "/2S.png"));
                cardsdealer.add(new Card(4, 2));
                break;
            case 5:
                cardView.setImage(new Image(set + "/3C.png"));
                cardsdealer.add(new Card(5, 3));
                break;
            case 6:
                cardView.setImage(new Image(set + "/3D.png"));
                cardsdealer.add(new Card(6, 3));
                break;
            case 7:
                cardView.setImage(new Image(set + "/3H.png"));
                cardsdealer.add(new Card(7, 3));
                break;
            case 8:
                cardView.setImage(new Image(set + "/3S.png"));
                cardsdealer.add(new Card(8, 3));
                break;
            case 9:
                cardView.setImage(new Image(set + "/4C.png"));
                cardsdealer.add(new Card(9, 4));
                break;
            case 10:
                cardView.setImage(new Image(set + "/4D.png"));
                cardsdealer.add(new Card(10, 4));
                break;
            case 11:
                cardView.setImage(new Image(set + "/4H.png"));
                cardsdealer.add(new Card(11, 4));
                break;
            case 12:
                cardView.setImage(new Image(set + "/4S.png"));
                cardsdealer.add(new Card(12, 4));
                break;
            case 13:
                cardView.setImage(new Image(set + "/5C.png"));
                cardsdealer.add(new Card(13, 5));
                break;
            case 14:
                cardView.setImage(new Image(set + "/5D.png"));
                cardsdealer.add(new Card(14, 5));
                break;
            case 15:
                cardView.setImage(new Image(set + "/5H.png"));
                cardsdealer.add(new Card(15, 5));
                break;
            case 16:
                cardView.setImage(new Image(set + "/5S.png"));
                cardsdealer.add(new Card(16, 5));
                break;
            case 17:
                cardView.setImage(new Image(set + "/6C.png"));
                cardsdealer.add(new Card(17, 6));
                break;
            case 18:
                cardView.setImage(new Image(set + "/6D.png"));
                cardsdealer.add(new Card(18, 6));
                break;
            case 19:
                cardView.setImage(new Image(set + "/6H.png"));
                cardsdealer.add(new Card(19, 6));
                break;
            case 20:
                cardView.setImage(new Image(set + "/6S.png"));
                cardsdealer.add(new Card(20, 6));
                break;
            case 21:
                cardView.setImage(new Image(set + "/7C.png"));
                cardsdealer.add(new Card(21, 7));
                break;
            case 22:
                cardView.setImage(new Image(set + "/7D.png"));
                cardsdealer.add(new Card(22, 7));
                break;
            case 23:
                cardView.setImage(new Image(set + "/7H.png"));
                cardsdealer.add(new Card(23, 7));
                break;
            case 24:
                cardView.setImage(new Image(set + "/7S.png"));
                cardsdealer.add(new Card(24, 7));
                break;
            case 25:
                cardView.setImage(new Image(set + "/8C.png"));
                cardsdealer.add(new Card(25, 8));
                break;
            case 26:
                cardView.setImage(new Image(set + "/8D.png"));
                cardsdealer.add(new Card(26, 8));
                break;
            case 27:
                cardView.setImage(new Image(set + "/8H.png"));
                cardsdealer.add(new Card(27, 8));
                break;
            case 28:
                cardView.setImage(new Image(set + "/8S.png"));
                cardsdealer.add(new Card(28, 8));
                break;
            case 29:
                cardView.setImage(new Image(set + "/9C.png"));
                cardsdealer.add(new Card(29, 9));
                break;
            case 30:
                cardView.setImage(new Image(set + "/9D.png"));
                cardsdealer.add(new Card(30, 9));
                break;
            case 31:
                cardView.setImage(new Image(set + "/9H.png"));
                cardsdealer.add(new Card(31, 9));
                break;
            case 32:
                cardView.setImage(new Image(set + "/9S.png"));
                cardsdealer.add(new Card(32, 9));
                break;
            case 33:
                cardView.setImage(new Image(set + "/10C.png"));
                cardsdealer.add(new Card(33, 10));
                break;
            case 34:
                cardView.setImage(new Image(set + "/10D.png"));
                cardsdealer.add(new Card(34, 10));
                break;
            case 35:
                cardView.setImage(new Image(set + "/10H.png"));
                cardsdealer.add(new Card(35, 10));
                break;
            case 36:
                cardView.setImage(new Image(set + "/10S.png"));
                cardsdealer.add(new Card(36, 10));
                break;
            case 37:
                cardView.setImage(new Image(set + "/AC.png"));//
                cardsdealer.add(new Card(37, aceValue));
                break;
            case 38:
                cardView.setImage(new Image(set + "/AD.png"));//
                cardsdealer.add(new Card(38, aceValue));
                break;
            case 39:
                cardView.setImage(new Image(set + "/AH.png"));//
                cardsdealer.add(new Card(39, aceValue));
                break;
            case 40:
                cardView.setImage(new Image(set + "/AS.png"));//
                cardsdealer.add(new Card(40, aceValue));
                break;
            case 41:
                cardView.setImage(new Image(set + "/JC.png"));
                cardsdealer.add(new Card(41, 10));
                break;
            case 42:
                cardView.setImage(new Image(set + "/JD.png"));
                cardsdealer.add(new Card(42, 10));
                break;
            case 43:
                cardView.setImage(new Image(set + "/JH.png"));
                cardsdealer.add(new Card(43, 10));
                break;
            case 44:
                cardView.setImage(new Image(set + "/JS.png"));
                cardsdealer.add(new Card(44, 10));
                break;
            case 45:
                cardView.setImage(new Image(set + "/KC.png"));
                cardsdealer.add(new Card(45, 10));
                break;
            case 46:
                cardView.setImage(new Image(set + "/KD.png"));
                cardsdealer.add(new Card(46, 10));
                break;
            case 47:
                cardView.setImage(new Image(set + "/KH.png"));
                cardsdealer.add(new Card(47, 10));
                break;
            case 48:
                cardView.setImage(new Image(set + "/KS.png"));
                cardsdealer.add(new Card(48, 10));
                break;
            case 49:
                cardView.setImage(new Image(set + "/QC.png"));
                cardsdealer.add(new Card(49, 10));
                break;
            case 50:
                cardView.setImage(new Image(set + "/QD.png"));
                cardsdealer.add(new Card(50, 10));
                break;
            case 51:
                cardView.setImage(new Image(set + "/QH.png"));
                cardsdealer.add(new Card(51, 10));
                break;
            case 52:
                cardView.setImage(new Image(set + "/QS.png"));
                cardsdealer.add(new Card(51, 10));
                break;
            default:
                System.out.println("Card 0");
                break;
        }
    }
    

}
