package Controller;

import Functions.Pixel;
import Functions.RelatedColors;
import Functions.ThumbnailClickCellFactory;
import Functions.ThumbnailFromHexValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ColorViewerController implements Initializable {

    private ObservableList<Pixel> pixels;

    public ColorViewerController() {
    }

    public void setParameters(LinkedList<Pixel> pixelList) {
        this.pixels = FXCollections.observableArrayList(pixelList);
    }


    @FXML
    protected
    Label compLabel;
    @FXML
    protected
    TableView<Pixel> tableView;
    @FXML
    TableColumn<Pixel, String> hexCol;
    @FXML
    protected
    TableColumn thumbnailCol;
    @FXML
    TableColumn<Pixel, Integer> countCol;
    @FXML
    protected
    Label totalDistinctColors;


    @FXML
    protected
    TabPane tabPane;

    @FXML
    protected
    Tab compTab;
    @FXML
    protected VBox compBox;
    @FXML
    protected ImageView compView;

    @FXML
    private
    Tab triadTab;
    @FXML
    private VBox triadBox;

    @FXML
    private
    Tab splitCompTab;
    @FXML
    private VBox splitCompBox;

    @FXML
    private Tab tetradTab;
    @FXML
    private VBox tetradBox;



    private RelatedColors relatedColors;


    public void initialize(URL location, ResourceBundle resources) {

        totalDistinctColors.setText("Total number of distinct colors displayed: " + String.valueOf(pixels.size()));
        ThumbnailClickCellFactory cellFactory = new ThumbnailClickCellFactory(new ClickMouseHandler());
        thumbnailCol.setCellFactory(cellFactory);


        tableView.setItems(pixels);
    }

    private class ClickMouseHandler implements EventHandler<MouseEvent> {

        @Override
        //On click populates the Tabs with the related colors to what color is clicked
        public void handle(MouseEvent event) {
            if (event.getClickCount() == 1) try {
                relatedColors = new RelatedColors(pixels.get(((TableCell) event.getSource()).getIndex()).getHexValue());

                ComplementaryColors();
                TriadColors();
                TetradColors();

            } catch (IndexOutOfBoundsException ignored) {
            }
        }
    }

    private void TetradColors() {
        ImageView tetradView_1 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTetrad()[0], 100, 100).returnImage());
        ImageView tetradView_2 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTetrad()[1], 100, 100).returnImage());
        ImageView tetradView_3 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTetrad()[2], 100, 100).returnImage());
        ImageView tetradView_4 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTetrad()[3], 100, 100).returnImage());

        Label tetradLabel_1 = new Label("Hex Value = " + relatedColors.getTetrad()[0]);
        Label tetradLabel_2 = new Label("Hex Value = " + relatedColors.getTetrad()[1]);
        Label tetradLabel_3 = new Label("Hex Value = " + relatedColors.getTetrad()[2]);
        Label tetradLabel_4 = new Label("Hex Value = " + relatedColors.getTetrad()[3]);


        tetradBox.getChildren().clear();
        tetradBox.getChildren().addAll(tetradLabel_1, tetradView_1, tetradLabel_2, tetradView_2, tetradLabel_3, tetradView_3, tetradLabel_4, tetradView_4);
        tetradTab.setContent(tetradBox);

    }

    private void SplitCompColors() {
        ImageView splitCompView_1 = new ImageView(new ThumbnailFromHexValue(relatedColors.getSplitcomp()[0], 100, 100).returnImage());
        ImageView splitCompView_2 = new ImageView(new ThumbnailFromHexValue(relatedColors.getSplitcomp()[1], 100, 100).returnImage());
        ImageView splitCompView_3 = new ImageView(new ThumbnailFromHexValue(relatedColors.getSplitcomp()[2], 100, 100).returnImage());

        Label splitCompLabel_1 = new Label("Hex Value = " + relatedColors.getSplitcomp()[0]);
        Label splitCompLabel_2 = new Label("Hex Value = " + relatedColors.getSplitcomp()[1]);
        Label splitCompLabel_3 = new Label("Hex Value = " + relatedColors.getSplitcomp()[2]);

        splitCompBox.getChildren().clear();
        splitCompBox.getChildren().addAll(splitCompLabel_1, splitCompView_1, splitCompLabel_2, splitCompView_2, splitCompLabel_3, splitCompView_3);
        splitCompTab.setContent(splitCompBox);
    }

    private void TriadColors() {
        ImageView triadView_1 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTriad()[0], 100, 100).returnImage());
        ImageView triadView_2 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTriad()[1], 100, 100).returnImage());
        ImageView triadView_3 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTriad()[2], 100, 100).returnImage());

        Label triadLabel_1 = new Label("Hex Value = " + relatedColors.getTriad()[0]);
        Label triadLabel_2 = new Label("Hex Value = " + relatedColors.getTriad()[1]);
        Label triadLabel_3 = new Label("Hex Value = " + relatedColors.getTriad()[2]);

        triadBox.getChildren().clear();
        triadBox.getChildren().addAll(triadLabel_1, triadView_1, triadLabel_2, triadView_2, triadLabel_3, triadView_3);
        triadTab.setContent(triadBox);
    }

    private void ComplementaryColors() {
        compView = new ImageView(new ThumbnailFromHexValue(relatedColors.getComplementary(),100,100).returnImage());
        compLabel = new Label();
        compLabel.setText("Hex Value = " + relatedColors.getComplementary());

        compBox.getChildren().clear();
        compBox.getChildren().addAll(compLabel,compView);
        compTab.setContent(compBox);
    }
}



