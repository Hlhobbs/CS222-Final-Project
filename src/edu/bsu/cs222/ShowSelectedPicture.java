package edu.bsu.cs222;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.ToDoubleBiFunction;

public class ShowSelectedPicture implements Initializable {

    private ImageView imageView;
    private Image image;
    private String hex;
    private Image thumbnail;

    @FXML
    private
    Pane pane;
    @FXML
    private
    Button button;
    @FXML
    private
    TextField xCoor;
    @FXML
    private
    TextField yCoor;
    @FXML
    private
    VBox imageBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane.getChildren().add(imageView);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: Deal with no values in boxes/ invalid searches

                imageBox.getChildren().clear();

                int x = Integer.valueOf(xCoor.getText());
                int y = Integer.valueOf(yCoor.getText());
                ScanPictureForColors scanPictureForColors = new ScanPictureForColors(image, x, y);
                Pixel pixel = scanPictureForColors.returnPixel();
                thumbnail = new ThumbnailFromHexValue(pixel.getHexValue(),100,100).returnImage();
                hex = pixel.getHexValue();

                Label hexLabel = new Label("Hex Value is " + hex);
                ImageView thumbView = new ImageView(thumbnail);

                imageBox.getChildren().addAll(hexLabel,thumbView);



            }
        });
    }

    public void setImageView(Image i) {
        this.image = i;
        if (i.getWidth() > 500) {
            this.imageView = new ImageView();
            imageView.setImage(i);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(500);
        } else {
            this.imageView = new ImageView(i);
        }
    }
}
