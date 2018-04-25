package Controller;

import Main.MainLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public Button FileButton;

    @FXML
    public TextField minimumUsesTextField;

    private String containedInTextField;
    private ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FileButton.setOnAction(event -> {
            String containedInTextField = minimumUsesTextField.getText();
            try {
                MainLogic logic = new MainLogic(containedInTextField);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }
}