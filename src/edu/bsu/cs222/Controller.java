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
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
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
            try {
                imageView = new FilePicker().returnImageView();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String containedInTextField = minimumUsesTextField.getText();
            int uses = 0;
            try {
                uses = new MinimumUsesFromTextField(containedInTextField).asInt();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(imageView.toString());
            System.out.println(uses);

            try {
                MainLogic logic = new MainLogic(imageView, uses);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }
}