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
import java.util.Scanner;
import java.util.logging.Logger;

public class Controller {

    private Scanner scanner = new Scanner(System.in);;
    private String InputType = "";


    public void Controller() {
    }

    public String getInputType() {
        System.out.println("Enter URL or File to choose where to locate image");
        String tempString = scanner.nextLine();
        this.InputType = tempString;
        return InputType;
    }

    public Image createImage(String inputType) {
        Image image = null;
        if (inputType == "URL") {
            return (image = new ChooseUrl().getPictureFromUrl());
        }
        return image;
    }
}
