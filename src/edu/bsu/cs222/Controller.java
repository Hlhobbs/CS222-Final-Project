package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public Button FileButton;
    public Button URLButton;
    public TextField UrlField;

    public void ChooseImageFromFile(ActionEvent actionEvent) throws FileNotFoundException {
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
        List<String> HexValues = new ArrayList<String>();
        List<Display> displays = new ArrayList<Display>();

        //Shrink array of hexValues before putting them into the DisplayArray
        for (int i = 0; i < pixelList.size(); i++) {
            String hex = new returnStringHexValue().returnStringHexValue(pixelList.get(i));
            HexValues.add(i, hex);
        }

        ObservableList<String> ShrinkedHexValues = FXCollections.observableArrayList();
        SimplifyColors simplifyColors = new SimplifyColors();
        ShrinkedHexValues = simplifyColors.DeleteRepeatColors(HexValues);
        List<Integer> count = simplifyColors.getCount();


        for (int k = 0; k < ShrinkedHexValues.size(); k++) {
            Display display = new Display();
            display.setHex(ShrinkedHexValues.get(k));
            display.setCount(count.get(k));
            displays.add(k, display);
        }

        tableController tableController = new tableController();
        tableController.setParameters(displays);
        Stage stage = new Stage();
        tableController.start(stage);
    }

    public void getUrl(ActionEvent actionEvent) throws FileNotFoundException {
        ImageView imageView = null;
        String imagesource = UrlField.getText();
        File URLFile = null;
        //URlFile = null;
        if (URLFile != null) {
            InputStream inputStream = new FileInputStream(URLFile);
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
        List<String> HexValues = new ArrayList<String>();
        List<Display> displays = new ArrayList<Display>();


        for (int i = 0; i < pixelList.size(); i++) {
            String hex = new returnStringHexValue().returnStringHexValue(pixelList.get(i));
            HexValues.add(i, hex);
            Display display = new Display();
            display.setHex(hex);
            displays.add(i, display);
        }

        tableController tableController = new tableController();
        tableController.setParameters(displays);
        Stage stage = new Stage();
        tableController.start(stage);
    }
}
