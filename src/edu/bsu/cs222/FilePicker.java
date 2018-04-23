package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class FilePicker {

    private InputStream inputStream;

    //FilePicker is a method that allows the user to browse their files for a picture.

    FilePicker() throws FileNotFoundException {

        FileChooser testFileChooser = new FileChooser();
        testFileChooser.setTitle("File Chooser");
        File chosenTestFile;

        //The following extensions are picture files which the program can display
        testFileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp"));

        chosenTestFile = testFileChooser.showOpenDialog(null);

        if (chosenTestFile != null) {
            inputStream = new FileInputStream(chosenTestFile);
        }
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
