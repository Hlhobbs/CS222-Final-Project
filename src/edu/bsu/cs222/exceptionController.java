package edu.bsu.cs222;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class exceptionController implements Initializable {

    String exception;

    @FXML
    Label text = new Label();

    @FXML
    public void setException(String s) {
        this.exception = s;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.text.setText(exception);
    }
}
