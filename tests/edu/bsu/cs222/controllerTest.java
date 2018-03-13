package edu.bsu.cs222;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;

public class controllerTest extends Application {

    private TableColumn<Display, Image> DisplayCol;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DisplayCol.setCellFactory(param -> {
                final ImageView imageview = new ImageView();
                imageview.setFitHeight(50);
                imageview.setFitWidth(50);

                TableCell<Display, Image> cell = new TableCell<Display, Image>() {
                    public void updateItem(Image item, boolean empty) {
                        if (item != null) {
                            imageview.setImage(item);
                        }
                    }
                };
                // Attach the imageview to the cell
                cell.setGraphic(imageview);
                return cell;
            });
            DisplayCol.setCellValueFactory(new PropertyValueFactory<Display, Image>("image"));

        TableColumn<Display, String> stringCol = new TableColumn<Display, String>("hex");
        stringCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Display, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Display, String> param) {
                return param.getValue().getHex();
            }
        });
    }
}