package Models;

import Controller.ImageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ShowSelectedPicture {

    public ShowSelectedPicture(Image image) throws IOException {
        ImageController showSelectedPicture = new ImageController();
        showSelectedPicture.setImageView(image);

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/showPictureFXML.fxml")));
        loader.setController(showSelectedPicture);

        VBox root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("image");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
