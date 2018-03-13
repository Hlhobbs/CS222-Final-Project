package edu.bsu.cs222;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class tableController extends Application {

    private TableView tableView;
    private ObservableList<Display> displays;

    public void setParameters(ObservableList<Display> DList) {
        this.displays = DList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Display> list = FXCollections.observableArrayList();

        /**
         for (int i = 0; i < hexString.size(); i++) {
         list.get(i).setHex(hexString.get(i));
         list.get(i).setImage(imageList.get(i));
         }
         **/
        Image imageView =new Image("https://upload.wikimedia.org/wikipedia/commons/2/26/Pyeongchang_Olympic_Stadium_at_day_for_2018_Winter_Paralympics_opening_ceremony_-_5.jpg");
        Display d1 = new Display();

        list.add(d1);

        TableColumn hexColumn = new TableColumn<>("Hex values");
        hexColumn.setCellValueFactory(new PropertyValueFactory<>("hex"));
        hexColumn.setPrefWidth(120);

        TableColumn imageColumn = new TableColumn("Colors");
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));

        tableView.getColumns().add(hexColumn);
        tableView.getColumns().add(imageColumn);
        tableView.setItems(list);
    }
}
