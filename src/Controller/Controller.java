package Controller;

import Main.MainLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private Button FileButton;

    @FXML
    private TextField minimumUsesTextField;

    private String containedInTextField;
    private InputStream inputStream;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FileButton.setOnAction(event -> {
            this.containedInTextField = minimumUsesTextField.getText();
            try {
                MainLogic logic = new MainLogic(containedInTextField);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

}