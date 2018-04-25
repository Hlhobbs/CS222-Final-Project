package Controller;


import Functions.Pixel;
import Functions.ScanPictureForColors;
import Functions.ThumbnailFromHexValue;
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
    @FXML
    private Label hexLabel;
    @FXML
    private ImageView thumbView;
    @FXML
    private
    Label ExceptionLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane.getChildren().add(imageView);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: Deal with no values in boxes/ invalid searches
                if (xCoor.getText().trim().isEmpty() || yCoor.getText().trim().isEmpty()) {
                    ExceptionLabel.setText("Please enter in coordinates for a pixel");
                } else if (!(xCoor.getText().matches("^[0-9]+$")) && !(yCoor.getText().matches("^[0-9]+$"))) {
                    ExceptionLabel.setText("Enter numeric charcters");
                } else {
                    int x = Integer.valueOf(xCoor.getText());
                    int y = Integer.valueOf(yCoor.getText());

                    if (x > image.getWidth() || 0 > x || y > image.getHeight() || 0 > y) {
                        ExceptionLabel.setText("The coordinates exist outside the pixel's bounds");
                    } else {
                        ExceptionLabel.setText("");
                        ScanPictureForColors scanPictureForColors = new ScanPictureForColors(image, x, y);
                        Pixel pixel = scanPictureForColors.returnPixel();
                        thumbnail = new ThumbnailFromHexValue(pixel.getHexValue(),100,100).returnImage();
                        hex = pixel.getHexValue();

                        hexLabel = new Label("Hex Value is " + hex);
                        thumbView = new ImageView(thumbnail);


                        imageBox.getChildren().clear();
                        imageBox.getChildren().addAll(hexLabel,thumbView);
                    }
                }
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
