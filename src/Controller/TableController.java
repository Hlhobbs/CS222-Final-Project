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

public class TableController implements Initializable {

    private ObservableList<Pixel> pixels;

    public TableController() {
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
    private ImageView triadView_1;
    @FXML
    private ImageView triadView_2;
    @FXML
    private ImageView triadView_3;

    @FXML
    private Label triadLabel_1;
    @FXML
    private Label triadLabel_2;
    @FXML
    private Label triadLabel_3;

    @FXML
    private Tab tetradTab;
    @FXML
    private VBox tetradBox;
    @FXML
    private ImageView tetradView_1;
    @FXML
    private ImageView tetradView_2;
    @FXML
    private ImageView tetradView_3;
    @FXML
    private ImageView tetradView_4;

    @FXML
    private Label tetradLabel_1;
    @FXML
    private Label tetradLabel_2;
    @FXML
    private Label tetradLabel_3;
    @FXML
    private Label tetradLabel_4;




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
        tetradView_1 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTetrad()[0],100,100).returnImage());
        tetradView_2 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTetrad()[1],100,100).returnImage());
        tetradView_3 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTetrad()[2],100,100).returnImage());
        tetradView_4 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTetrad()[3],100,100).returnImage());

        tetradLabel_1 = new Label("Hex Value = " + relatedColors.getTetrad()[0]);
        tetradLabel_2 = new Label("Hex Value = " + relatedColors.getTetrad()[1]);
        tetradLabel_3 = new Label("Hex Value = " + relatedColors.getTetrad()[2]);
        tetradLabel_4 = new Label("Hex Value = " + relatedColors.getTetrad()[3]);


        tetradBox.getChildren().clear();
        tetradBox.getChildren().addAll(tetradLabel_1,tetradView_1,tetradLabel_2,tetradView_2,tetradLabel_3,tetradView_3,tetradLabel_4,tetradView_4);
        tetradTab.setContent(tetradBox);

    }

    private void TriadColors() {
        triadView_1 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTriad()[0],100,100).returnImage());
        triadView_2 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTriad()[1],100,100).returnImage());
        triadView_3 = new ImageView(new ThumbnailFromHexValue(relatedColors.getTriad()[2],100,100).returnImage());

        triadLabel_1 = new Label("Hex Value = " + relatedColors.getTriad()[0]);
        triadLabel_2 = new Label("Hex Value = " + relatedColors.getTriad()[1]);
        triadLabel_3 = new Label("Hex Value = " + relatedColors.getTriad()[2]);

        triadBox.getChildren().clear();
        triadBox.getChildren().addAll(triadLabel_1,triadView_1,triadLabel_2,triadView_2,triadLabel_3,triadView_3);
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



