package Models;

import Controller.ColorViewerController;
import Functions.Pixel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class ColorViewer {

    public ColorViewer(LinkedList<Pixel> pixelList) throws IOException {
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
    }
}
