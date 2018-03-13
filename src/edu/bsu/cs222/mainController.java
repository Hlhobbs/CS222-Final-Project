package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class mainController {

    TableView<Pixel> table;

    //start
    public void start(Stage primaryStage) {
        //Color Column
        TableColumn<Pixel, Image> colorColumn = new TableColumn<>("Color");
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

        //Hex Column
        TableColumn<Pixel, String> hexColumn = new TableColumn<>("Hex Value");
        hexColumn.setCellValueFactory(new PropertyValueFactory<>("hex"));

        //Sets up Table
        table = new TableView<>();
        //Needs ObservableList with data to populate aka getData()
        //table.setItems();
        table.getColumns().addAll(colorColumn, hexColumn);
    }

    //public ObservableList<type> getData(){
        //ObservableList<type> datas = FXCollections.observableArrayList();
        //datas.add(new data());
        //return datas;
}
