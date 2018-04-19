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
    private
    Label totalDistinctColors;
    @FXML
    TabPane tabPane = new TabPane();
    @FXML
    Tab compTab;
    @FXML
    private HBox box;
    @FXML
    private ImageView compView;


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
                    Image compImage = new ThumbnailFromHexValue(relatedColors.getComplementary(),100,100).returnImage();
                    compView = new ImageView(compImage);

                    box.getChildren().clear();
                    box.getChildren().add(compView);
                    compTab.setContent(box);

                } catch (IndexOutOfBoundsException e) {}
            }
        }
    }
}



