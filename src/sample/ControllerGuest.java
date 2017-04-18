package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by robin on 2017-04-09.
 */
public class ControllerGuest implements Initializable {


    @FXML
    private TextArea guestTextArea;




    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void guestLogout(ActionEvent ae) {
        Node node = (Node)ae.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MainScene.fxml"));
        Parent root = null;

        try {
            root = (Parent)loader.load();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    private void matchButton(ActionEvent ae){
        //lägg till kod när vi har connectat till databas.
        guestTextArea.setText("previous and upcomeing matches.");

    }
    @FXML
    private void teamButton(ActionEvent ae){
        //lägg till kod när vi har connectat till databas.
        guestTextArea.setText("Names of players.");
    }
    @FXML
    private void statisticButton(ActionEvent ae){
        //lägg till kod när vi har connectat till databas.
        guestTextArea.setText("Player and match statistics.");
    }

}
