package edu.bsu.cs222;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Objects;


public class Controller {

    @FXML
    public Button FileButton;

    @FXML
    public TextField minimumUsesTextField;

    public void ChooseImageFromFile() throws Exception {

        ImageView imageView = new FilePicker().returnImageView();

       String containedInTextField = minimumUsesTextField.getText();
       int uses = new MinimumUsesFromTextField(containedInTextField).asInt();

        //Checks the validity of the image obtained from the file system and displays it
       if (imageView != null) {
           ShowSelectedPicture sc = new ShowSelectedPicture(imageView);
           Stage pictureStage = new Stage();
           sc.start(pictureStage);
       } else {
           System.out.println("There was an issue with the image chosen");
       }

        LinkedList<Pixel> pixelList = new ScanPictureForColors(Objects.requireNonNull(imageView).getImage()).returnPixel();


        SimplifyColors sc = new SimplifyColors(pixelList);
        sc.DeleteRepeatColors();
        sc.DeleteRareColors(uses);
        pixelList = sc.returnShrunkList();


        FXMLLoader tableLoader = new FXMLLoader(getClass().getClassLoader().getResource("tableView.fxml"));
        TableController TableController = new TableController();
        TableController.setParameters(pixelList);
        tableLoader.setController(TableController);

        HBox root = tableLoader.load();
        Scene table = new Scene(root);
        Stage tableStage = new Stage();
        tableStage.setScene(table);
        tableStage.show();
    }

}
