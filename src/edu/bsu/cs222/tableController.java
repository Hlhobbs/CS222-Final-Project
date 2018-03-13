package edu.bsu.cs222;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

        TableView tableView = new TableView(displays);
        TableColumn<Display, String> hexCol = new TableColumn<>("hex");

        hexCol.setCellValueFactory(param -> param.getValue().getHex());

        HBox parent = new HBox();
        parent.setPrefSize(600, 400);
        parent.setPadding(new Insets(5));
        parent.setSpacing(5);
        parent.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.setPrefSize(parent.getPrefWidth(), parent.getPrefHeight());

        tableView.getColumns().addAll(hexCol);

        vBox.getChildren().add(tableView);
        parent.getChildren().addAll(vBox);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }
}
