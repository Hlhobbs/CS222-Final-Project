package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class exceptionController implements Initializable {

    private String exception;

    @FXML
    private
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
