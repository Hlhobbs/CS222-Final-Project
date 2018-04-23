package edu.bsu.cs222;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Objects;

public class MainLogic {

    public MainLogic(String textfield) throws Exception {

        InputStream inputStream = new FilePicker().getInputStream();
        ImageView imageView = new ImageView(new Image(inputStream));

        int uses = new MinimumUsesFromTextField(textfield).asInt();

        //Checks the validity of the image obtained from the file system and displays it
        if (imageView != null) {
            ShowSelectedPicture sc = new ShowSelectedPicture(imageView);
            Stage pictureStage = new Stage();
            sc.start(pictureStage);
        } else {
            String exception = "There was an issue with the image chosen";
            exceptionController eC = new exceptionController();
            eC.setException(exception);
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/exceptionFXML.fxml")));
            loader.setController(eC);

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("exception");
            stage.setScene(new Scene(root,300,25));
            stage.show();

        }

        LinkedList<Pixel> pixelList = new ScanPictureForColors(Objects.requireNonNull(imageView).getImage()).returnPixel();


        SimplifyNumberOfColors sc = new SimplifyNumberOfColors(pixelList);
        sc.DeleteRareColors(uses);
        pixelList = sc.returnShrunkList();


        FXMLLoader tableLoader = new FXMLLoader(getClass().getClassLoader().getResource("resources/tableView.fxml"));
        TableController TableController = new TableController();
        TableController.setParameters(pixelList);
        tableLoader.setController(TableController);

        HBox root = tableLoader.load();
        Scene table = new Scene(root);
        Stage tableStage = new Stage();
        tableStage.setTitle("TableView");
        tableStage.setScene(table);
        tableStage.show();
    }
}
