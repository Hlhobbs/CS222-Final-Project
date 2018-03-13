package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Controller {

    TableView<Pixel> table;

    private Desktop desktop = Desktop.getDesktop();
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


        final FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Choose an image!");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        final Button openButton = new Button("Open a Picture...");

        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        File file = fileChooser.showOpenDialog(primaryStage);
                        if (file != null) {
                            openFile(file);
                        }
                    }
                });



    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //public ObservableList<type> getData(){
        //ObservableList<type> datas = FXCollections.observableArrayList();
        //datas.add(new data());
        //return datas;
}
