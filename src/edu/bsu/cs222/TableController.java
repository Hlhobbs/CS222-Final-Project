package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

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
    Label totalDistinctColors;


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
                    System.out.println("Hey we got here");
                } catch (IndexOutOfBoundsException e) {

                }
            }
        }
    }
}

/**
 public void initialize(URL location, ResourceBundle resources) {

 totalDistinctColors.setText("Total number of distinct colors displayed: " + String.valueOf(pixels.size()));
 thumbnailCol.setCellFactory((TableColumn<Pixel, String> param) -> new TableCell<>() {



 public void updateItem(String s, boolean empty) {
 if (s != null) {
 HBox box = new HBox();
 box.setSpacing(10);
 VBox vbox = new VBox();

 ImageView imageview = new ImageView();
 imageview.setFitHeight(50);
 imageview.setFitWidth(50);
 imageview.setImage(new ThumbnailFromHexValue(s).returnImage());

 box.getChildren().addAll(imageview, vbox);
 //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
 setGraphic(box);
 }
 }
 });
 tableView.setItems(pixels);
 }
 */



