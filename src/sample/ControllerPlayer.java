package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by robin on 2017-04-09.
 */
public class ControllerPlayer extends ControllerGuest implements Initializable {
    @FXML
    private TextArea playerTextArea;


    @FXML
    private ChoiceBox choiceBoxView; //Choicebox for View functions in Player Scene



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxView.getItems().add("View Matches");
        choiceBoxView.getItems().add("View Players");
        choiceBoxView.getItems().add("View Player Statistics");
        choiceBoxView.getItems().add("View Match Statistics");
        choiceBoxView.getItems().add("View Training");




    }

    @FXML
    private void playerLogout(ActionEvent ae) {


        try {
            changeScene(ae,"MainScene.fxml");
        } catch (IOException var7) {
            var7.printStackTrace();
        }


    }

        @FXML
        private void trainingButton (ActionEvent ae){
            //Add new scene?
        }

        // Prints the output from selected choiceBox and prints to Text area.
        @FXML
        private void viewBoxPlayer (ActionEvent ae){

            if (choiceBoxView.getValue().equals("View Matches")){
                viewMatches(playerTextArea);
            }

            if (choiceBoxView.getValue().equals("View Players")){
                viewPlayers(playerTextArea);
            }

            if (choiceBoxView.getValue().equals("View Player Statistics")){
                viewPlayerStatistics(playerTextArea);
            }

            if (choiceBoxView.getValue().equals("View Match Statistics")){
                viewMatchStatistics(playerTextArea);
            }

            if (choiceBoxView.getValue().equals("View Training")){
                viewTraining(playerTextArea);


            }

        }

        @FXML
        private void attendTraining (ActionEvent ae){

            try {
               changeScene(ae,"PlayerSceneAttend.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        @FXML
        public void absence (ActionEvent ae){

            try {

                changeScene(ae, "PlayerSceneAbsence.fxml");
            } catch (IOException em) {
                em.printStackTrace();

            }


        }
    }



















