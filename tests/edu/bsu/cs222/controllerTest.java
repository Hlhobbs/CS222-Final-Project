package edu.bsu.cs222;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
    @Override
    public void start(Stage primaryStage) throws Exception {


        //List<String> hexString;
        //List<ImageView> imageList;

        /**
         for (int i = 0; i < hexString.size(); i++) {
         list.get(i).setHex(hexString.get(i));
         list.get(i).setImage(imageList.get(i));
         }
         **/
        ImageView imageView = new ImageView(new Image("https://upload.wikimedia.org/wikipedia/commons/2/26/Pyeongchang_Olympic_Stadium_at_day_for_2018_Winter_Paralympics_opening_ceremony_-_5.jpg"));
        Display d1 = new Display(imageView, "Hex");

        ObservableList<Display> list = FXCollections.observableArrayList();
        list.add(d1);


        TableView<Display> tableView = new TableView<Display>(list);

        TableColumn<Display, ImageView> imageCol = new TableColumn<Display,ImageView>("image");
        imageCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Display, ImageView>, ObservableValue<ImageView>>() {
            @Override
            public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<Display, ImageView> param) {
                return param.getValue().getImage();
            }
        });

        TableColumn<Display, String> stringCol = new TableColumn<Display, String>("hex");
        stringCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Display, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Display, String> param) {
                return param.getValue().getHex();
            }
        });
    }
}