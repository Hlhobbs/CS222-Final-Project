package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Controller {

    public Button FileButton;

    public void ChooseImageFromFile(ActionEvent actionEvent) throws Exception {
        ImageView imageView = null;
        //Choose an image file from the users computer system
        //File choosing has to be done in the main thread according to Java

        FileChooser testFileChooser = new FileChooser();
        testFileChooser.setTitle("Test File Chooser");
        File chosenTestFile;
        testFileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

        chosenTestFile = testFileChooser.showOpenDialog(null);

        if (chosenTestFile != null) {
            InputStream inputStream = new FileInputStream(chosenTestFile);
            CreateImage createImage = new CreateImage(inputStream);
            Image createdImage = createImage.returnImage();

            //Both lines are necessary else throws an exception
            imageView = new ImageView(createdImage);
        }


        DisplayPicture displayPicture = new DisplayPicture(imageView);
        displayPicture.picture();

        Image forColors = imageView.getImage();
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();

        List<Pixel> pixelList = scanPictureForColors.ScanPixelsForColors(forColors);
        LinkedList HexValues = new LinkedList();
        LinkedList displays = new LinkedList();

        //Shrink array of hexValues before putting them into the DisplayArray
        for (int i = 0; i < pixelList.size(); i++) {
            String hex = new returnStringHexValue().returnStringHexValue(pixelList.get(i));
            HexValues.add(i, hex);
        }


        List<String> ShrinkedHexValues;
        SimplifyColors simplifyColors = new SimplifyColors();
        ShrinkedHexValues = simplifyColors.DeleteRepeatColors(HexValues);
        List<Integer> count = simplifyColors.getCount();

        for (int k = 0; k < ShrinkedHexValues.size(); k++) {
            Display display = new Display();
            display.setHex(ShrinkedHexValues.get(k));
            display.setCount(count.get(k));
            displays.add(k, display);
        }


        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("tableView.fxml"));
        tableController tableController = new tableController();
        tableController.setParameters(displays);


        tableLoader.setController(tableController);
        HBox root = tableLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
