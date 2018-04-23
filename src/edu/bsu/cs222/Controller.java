package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;
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