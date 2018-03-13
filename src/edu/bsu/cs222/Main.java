package edu.bsu.cs222;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        String inputType = controller.getInputType();
        ImageView imageView = null;

        //Choose an image file from the users computer system
        //File choosing has to be done in the main thread according to Java
        if (inputType == "File") {
            FileChooser testFileChooser = new FileChooser();
            testFileChooser.setTitle("Test File Chooser");
            testFileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
            );

            File chosenTestFile = testFileChooser.showOpenDialog(null);

            if (chosenTestFile != null) {
                InputStream inputStream = new FileInputStream(chosenTestFile);
                CreateImage createImage = new CreateImage(inputStream);
                Image createdImage = createImage.returnImage();

                //Both lines are necessary else throws an exception
                javafx.scene.image.ImageView tempImageView = new javafx.scene.image.ImageView(createdImage);
                imageView = tempImageView;
            }
        } else {
            String url = controller.imageURL();
            CreateImage createImage = new CreateImage(url);
            Image createdImage = createImage.returnImage();

            //Both lines are necessary else throws an exception
            javafx.scene.image.ImageView tempImageView = new javafx.scene.image.ImageView(createdImage);
            imageView = tempImageView;
        }

        DisplayPicture displayPicture = new DisplayPicture(imageView);
        displayPicture.picture();

        Image forColors = imageView.getImage();
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();

        ObservableList<Pixel> pixelList = scanPictureForColors.ScanPixelsforColors(forColors);
        ObservableList<String> HexValues = FXCollections.observableArrayList();
        ObservableList<Display> displays = FXCollections.observableArrayList();


        for (int i = 0; i < pixelList.size(); i++) {
            String hex = new returnStringHexValue().returnStringHexValue(pixelList.get(i));
            HexValues.add(i,hex);
            SimpleStringProperty simpleStringProperty = new SimpleStringProperty();
            simpleStringProperty.setValue(HexValues.get(i));
            Display display = new Display();
            display.setHex(simpleStringProperty);
            displays.add(i,display);
        }

        tableController tableController = new tableController();
        tableController.setParameters(displays);
        Stage stage = new Stage();
        tableController.start(stage);






    }
}
