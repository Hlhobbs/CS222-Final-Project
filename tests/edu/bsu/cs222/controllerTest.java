package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class controllerTest extends Application {

    private TableColumn<Display, Image> DisplayCol;

    @Override
    public void start(Stage primaryStage) {
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
                // Attach the imageView to the cell
                cell.setGraphic(imageview);
                return cell;
            });
            DisplayCol.setCellValueFactory(new PropertyValueFactory<>("image"));

        TableColumn<Display, String> stringCol = new TableColumn<>("hex");

        HBox parent = new HBox();
        VBox vBox = new VBox();
        TableView<Display> tableView = new TableView<>();


        tableView.getColumns().addAll(DisplayCol, stringCol);
        vBox.getChildren().add(tableView);
        parent.getChildren().addAll(vBox);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }
}