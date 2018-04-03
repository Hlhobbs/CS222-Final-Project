package edu.bsu.cs222;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class exceptionController extends Application {

    String exception;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text = new Text();
        text.setText(exception);

        text.setX(350);
        text.setY(250);

        text.setFont(Font.font ("Verdana", 12));

        Group group = new Group(text);
        HBox root = new HBox();
        root.setSpacing(10);
        root.getChildren().add(group);

        Scene scene = new Scene(root);
        primaryStage.setTitle("exception");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void setException(String s) {
        this.exception = s;
    }


}
