package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private ObservableList<Pixel> pixels;

    public TableController() { }

    public void setParameters(LinkedList<Pixel> pixelList) {
        this.pixels = FXCollections.observableArrayList(pixelList);
    }



    @FXML
    Label label;
    @FXML
    TableView<Pixel> tableView;
    @FXML
    TableColumn<Pixel, String> hexCol;
    @FXML
    TableColumn<Pixel, String> thumbnailCol;
    @FXML
    TableColumn<Pixel, Integer> countCol;


    public void initialize(URL location, ResourceBundle resources) {
        thumbnailCol.setCellFactory((TableColumn<Pixel, String> param) -> {
            TableCell<Pixel, String> cell = new TableCell<Pixel, String>() {
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
            };
            return cell;
        });
        tableView.setItems(pixels);
    }
}


