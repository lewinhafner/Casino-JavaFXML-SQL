package ch.bbbaden.casino.blackjack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Shenia Scherer
 */
public class BlackjackMenuController implements Initializable {

    private BlackjackMenuViewModel vm;

    @FXML
    private Button startBtn;
    @FXML
    private Button mainMenubtn;
    @FXML
    private Label moneyLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void startAction(ActionEvent event) throws IOException {
        vm.startAction();
    }

    public void setViewModel(BlackjackMenuViewModel vm) {
        this.vm = vm;
    }

    public void bind() {
        moneyLbl.textProperty().bind(vm.getBalance());
    }

    @FXML
    private void mainMenuAction(ActionEvent event) {
        vm.gotoMenu();
    }

}
