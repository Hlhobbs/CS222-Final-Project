package edu.bsu.cs222;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;


public class controllerTest extends Application {

    private TableView<Display> tableView;
    private TableColumn<Display, Image> imageCol;
    private TableColumn<Display, String> StringCol;
    public ObservableList<Display> list;

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox parent = new HBox();
        VBox vBox = new VBox();
        vBox.setPrefSize(parent.getPrefWidth(), parent.getPrefHeight());

        Display d = new Display();
        d.setSimpleHex("Hex values");

        ObservableList<Display> list = FXCollections.observableArrayList();
        list.addAll(d);

        TableView<Display> tableView = new TableView<>(list);
        tableView.prefHeight(vBox.getPrefHeight());
        tableView.prefWidth(vBox.getPrefWidth());

        TableColumn<Display, String> hexColumn = new TableColumn<Display, String>("hex");
        hexColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Display, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Display, String> param) {
                return param.getValue().getSimpleHex();
            }
        });


        tableView.getColumns().addAll(hexColumn);
        tableView.setVisible(true);
        vBox.getChildren().add(tableView);
        parent.getChildren().addAll(vBox);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}