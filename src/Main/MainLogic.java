package Main;

import Controller.ShowSelectedPicture;
import Controller.TableController;
import Controller.exceptionController;
import Functions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Objects;

public class MainLogic {

    public MainLogic(String textfield) throws Exception {

        InputStream inputStream = new FilePicker().getInputStream();
        int uses = new MinimumUsesFromTextField(textfield).asInt();

        //Checks the validity of the image obtained from the file system and displays it
        Image image = null;
        if (inputStream != null) {
            ShowSelectedPicture showSelectedPicture = new ShowSelectedPicture();
            image = new Image(inputStream);
            showSelectedPicture.setImageView(image);

            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/showPictureFXML.fxml")));
            loader.setController(showSelectedPicture);

            VBox root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("image");
            stage.setScene(new Scene(root));
            stage.show();


        } else {
            String exception = "There was an issue with the image chosen";
            exceptionController eC = new exceptionController();
            eC.setException(exception);
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/exceptionFXML.fxml")));
            loader.setController(eC);

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("exception");
            stage.setScene(new Scene(root, 300, 25));
            stage.show();

        }

        LinkedList<Pixel> pixelList = new ScanPictureForColors(image).returnPixelList();


        SimplifyNumberOfColors sc = new SimplifyNumberOfColors(pixelList);
        sc.DeleteRareColors(uses);
        pixelList = sc.returnShrunkList();


        FXMLLoader tableLoader = new FXMLLoader(getClass().getClassLoader().getResource("resources/tableView.fxml"));
        TableController TableController = new TableController();
        TableController.setParameters(pixelList);
        tableLoader.setController(TableController);

        HBox root = tableLoader.load();
        Scene table = new Scene(root);
        Stage tableStage = new Stage();
        tableStage.setTitle("TableView");
        tableStage.setScene(table);
        tableStage.show();
    }
}
