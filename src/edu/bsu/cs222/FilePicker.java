package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FilePicker {

    private ImageView imageView;

    //FilePicker is a method that allows the user to browse their files for a picture.

    public FilePicker() throws FileNotFoundException {

        ImageView tempImageView = null;
        FileChooser testFileChooser = new FileChooser();
        testFileChooser.setTitle("File Chooser");
        File chosenTestFile;

        //The following extensions are picture files which the program can display
        testFileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

        chosenTestFile = testFileChooser.showOpenDialog(null);

        if (chosenTestFile != null) {
            InputStream inputStream = new FileInputStream(chosenTestFile);
            Image createdImage = new Image(inputStream);

            //Both lines are necessary else throws an exception
            tempImageView = new ImageView(createdImage);
        }
        this.imageView = tempImageView;
    }

    public ImageView returnImageView() {
        return this.imageView;
    }
}
