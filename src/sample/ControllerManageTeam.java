package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

/**
 * Created by Daniel on 2017-04-19.
 */
public class ControllerManageTeam implements Initializable {

    @FXML private TextArea playersInTheTeamTextArea;
    @FXML private TextField addPlayerIDTextField;
    @FXML private TextField removePlayerIDTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField surNameTextField;
    @FXML private TextField positionTextField;
    @FXML private TextField userNameTextField;
    @FXML private TextField passwordTextField;
    @FXML private Button addPlayerButton;
    @FXML private Button removePlayerButton;
    @FXML private Button backButton;


    @FXML
    private void buttonPressed(ActionEvent ae){

        Button source = (Button) ae.getSource();

        if (source == backButton){
            try {
                Node node = (Node) ae.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("CoachScene.fxml"));
                Parent root = null;
                root = (Parent) loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (source == addPlayerButton){
            addPlayer();
        }

        if (source == removePlayerButton){
            try {
                int index = Integer.parseInt(removePlayerIDTextField.getText());
                //deletePlayerFromDB(index);
            } catch (InputMismatchException ex){
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setTitle("Error");
                dialog.setHeaderText("Error:");
                dialog.setContentText("Your input was invalid.");
                dialog.showAndWait();
            }
        }


    }

    public void addPlayer(){

        try {
            int playerID = DataStorage.getInstance().getPlayerList().size() + 1;
            String firstname = firstNameTextField.getText();
            String surname = surNameTextField.getText();
            String position = String.valueOf(Player.Position.valueOf(positionTextField.getText().toUpperCase()));
            String username = userNameTextField.getText();
            String password = passwordTextField.getText();


        } catch (NullPointerException ex){
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error:");
            dialog.setContentText("You did not enter all the required information.");
            dialog.showAndWait();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playersInTheTeamTextArea.setText("");
        // Set the text to all the players in the team.
    }
}
