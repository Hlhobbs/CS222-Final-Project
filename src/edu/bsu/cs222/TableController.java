package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private ObservableList<Pixel> pixels;

    public TableController() {
    }

    public void setParameters(LinkedList<Pixel> pixelList) {
        this.pixels = FXCollections.observableArrayList(pixelList);
    }



    @FXML
    TableView<Pixel> tableView;
    @FXML
    TableColumn<Pixel, String> hexCol;
    @FXML
    TableColumn<Pixel, String> thumbnailCol;
    @FXML
    TableColumn<Pixel, Integer> countCol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        thumbnailCol.setCellFactory(param -> {
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




    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<Display> tableView = new TableView<Display>(displays);


        TableColumn<Display, String> hexCol = new TableColumn<>("Hexadecimal color codes");
        hexCol.setCellValueFactory(new PropertyValueFactory<>("hex"));
        hexCol.setPrefWidth(120);

        TableColumn<Display, String> thumbnailCol = new TableColumn<>("thumbnails");
        thumbnailCol.setCellValueFactory(new PropertyValueFactory<>("hex"));
        thumbnailCol.setPrefWidth(120);

        TableColumn<Display, Integer> countCol = new TableColumn<>("uses");
        countCol.setCellValueFactory(new PropertyValueFactory<Display,Integer>("count"));
        countCol.setPrefWidth(120);


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
                            imageview.setImage(new ThumbnailFromHexValue(s).returnImage());

                            box.getChildren().addAll(imageview, vbox);
                            //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                            setGraphic(box);
                        }
                    }
                };
                return cell;
            }
        });

        tableView.getColumns().addAll(hexCol,thumbnailCol,countCol);

        HBox parent = new HBox();

        parent.getChildren().add(tableView);

        primaryStage.setScene(new Scene(parent));

        primaryStage.setTitle("List of Hexadecimal color codes");
        primaryStage.show();
    }**/


