package Controller;

import Functions.CreatePixelList;
import Functions.FilePicker;
import Functions.MinimumUsesFromTextField;
import Functions.Pixel;
import Functions.ProgramException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private Button FileButton;

    @FXML
    private TextField minimumUsesTextField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //The button on the first window that pops up
        FileButton.setOnAction(event -> {
            try {
                InputStream inputStream = new FilePicker().getInputStream();
                int uses = new MinimumUsesFromTextField(minimumUsesTextField.getText()).asInt();

                Image image;
                if (inputStream != null) {

                    image = new Image(inputStream);

                    //Displays the selected picture and allows the user to search the picture for the color at a pixel
                    ImageController showSelectedPicture = new ImageController();
                    showSelectedPicture.setImageView(image);

                    FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/showPictureFXML.fxml")));
                    loader.setController(showSelectedPicture);

                    VBox root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("image");
                    stage.setScene(new Scene(root));
                    stage.show();

                    LinkedList<Pixel> pixelList = new CreatePixelList(image, uses).returnList();

                    FXMLLoader tableLoader = new FXMLLoader(getClass().getClassLoader().getResource("resources/ColorViewer.fxml"));
                    ColorViewerController TableController = new ColorViewerController();
                    TableController.setParameters(pixelList);
                    tableLoader.setController(TableController);

                    HBox tRoot = tableLoader.load();
                    Scene table = new Scene(tRoot);
                    Stage tableStage = new Stage();
                    tableStage.setTitle("TableView");
                    tableStage.setScene(table);
                    tableStage.show();
                } else {
                    ProgramException exception = new ProgramException("There was an issue with the image chosen");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

}