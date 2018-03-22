package edu.bsu.cs222;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class tableController extends Application {

    private ObservableList<Display> displays;

    public void setParameters(ObservableList<Display> DList) {
        this.displays = DList;
    }

    @Override
    public void start(Stage primaryStage) {

        TableView<Display> tableView = new TableView<Display>(displays);


        TableColumn<Display, String> hexCol = new TableColumn<>("hex");
        hexCol.setCellValueFactory(new PropertyValueFactory<>("hex"));
        hexCol.setPrefWidth(120);

        TableColumn<Display, String> thumbnailCol = new TableColumn<>("thumbnails");
        thumbnailCol.setCellValueFactory(new PropertyValueFactory<>("hex"));
        thumbnailCol.setPrefWidth(120);

        thumbnailCol.setCellFactory(new Callback<TableColumn<Display, String>, TableCell<Display, String>>() {
            @Override
            public TableCell<Display, String> call(TableColumn<Display, String> param) {
                TableCell<Display, String> cell = new TableCell<Display, String>() {
                    public void updateItem(String s, boolean empty) {
                        if (s != null) {
                            HBox box = new HBox();
                            box.setSpacing(10);
                            VBox vbox = new VBox();

                            ImageView imageview = new ImageView();
                            imageview.setFitHeight(50);
                            imageview.setFitWidth(50);
                            imageview.setImage(new imageFromHexValue(s).returnImage());

                            box.getChildren().addAll(imageview, vbox);
                            //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                            setGraphic(box);
                        }
                    }
                };
                return cell;
            }
        });

        tableView.getColumns().addAll(hexCol,thumbnailCol);

        HBox parent = new HBox();
        parent.setPrefSize(600, 400);
        parent.setPadding(new Insets(5));
        parent.setSpacing(5);
        parent.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.setPrefSize(parent.getPrefWidth(), parent.getPrefHeight());

        vBox.getChildren().add(tableView);
        parent.getChildren().addAll(vBox);

        primaryStage.setScene(new Scene(parent));
        primaryStage.setTitle("List of Hexadecimal color codes");
        primaryStage.show();

    }
}
