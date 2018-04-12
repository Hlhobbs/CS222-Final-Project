package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private ObservableList<Pixel> pixels;

    TableController() {
    }

    void setParameters(LinkedList<Pixel> pixelList) {
        this.pixels = FXCollections.observableArrayList(pixelList);
    }


    @FXML
    Label label;
    @FXML
    private
    TableView<Pixel> tableView;
    @FXML
    TableColumn<Pixel, String> hexCol;
    @FXML
    private
    TableColumn thumbnailCol;
    @FXML
    TableColumn<Pixel, Integer> countCol;
    @FXML
    TableColumn<Pixel, String> rgbCol;
    @FXML
    private
    Label totalDistinctColors;
    @FXML
    TabPane tabPane = new TabPane();
    @FXML
    Tab compTab = new Tab();


    public void initialize(URL location, ResourceBundle resources) {

        totalDistinctColors.setText("Total number of distinct colors displayed: " + String.valueOf(pixels.size()));
        ThumbnailClickCellFactory cellFactory = new ThumbnailClickCellFactory(new ClickMouseHandler());
        thumbnailCol.setCellFactory(cellFactory);


        tableView.setItems(pixels);
    }

    private class ClickMouseHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (event.getClickCount() == 1) {

                try {
                    Pixel pixel = pixels.get(((TableCell) event.getSource()).getIndex());
                    RelatedColors relatedColors = new RelatedColors(pixel.getHexValue());
                    Image compImage = new ThumbnailFromHexValue(relatedColors.getComplementary()).returnImage();
                    ImageView compView = new ImageView(compImage);

                    HBox box = new HBox();
                    box.getChildren().add(compView);
                    compTab.setGraphic(box);

                } catch (IndexOutOfBoundsException e) {}
            }
        }
    }
}



