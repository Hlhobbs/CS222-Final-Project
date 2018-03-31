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

    public FilePicker() throws FileNotFoundException {
        ImageView tempImageView = null;
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
            tempImageView = new ImageView(createdImage);
        }
        this.imageView = tempImageView;
    }

    public ImageView returnImageView() {
        return this.imageView;
    }
}
