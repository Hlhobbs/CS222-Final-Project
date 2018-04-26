package Controller;

import Functions.*;
import Models.ColorViewer;
import Models.ProgramException;
import Models.ShowSelectedPicture;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FileButton.setOnAction(event -> {
            try {
                InputStream inputStream = new FilePicker().getInputStream();
                int uses = new MinimumUsesFromTextField(minimumUsesTextField.getText()).asInt();

                //Checks the validity of the image obtained from the file system and displays it


                Image image = null;
                if (inputStream != null) {
                    image = new Image(inputStream);
                    ShowSelectedPicture showSelectedPicture = new ShowSelectedPicture(image);
                    LinkedList<Pixel> pixelList = new CreatePixelList(image, uses).returnList();
                    //Method is used as a model to display the ColorView, which contains the table of colors in the image and the ability to look at related colors
                    @SuppressWarnings("unused") ColorViewer colorViewer = new ColorViewer(pixelList);
                } else {
                    ProgramException exception = new ProgramException("There was an issue with the image chosen");
                }



            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

}