package Functions;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;


public class ThumbnailClickCellFactory implements Callback<TableColumn, TableCell> {

    private final EventHandler<Event> click;

    public ThumbnailClickCellFactory(EventHandler click) {
        this.click = click;
    }

    @Override
    public TableCell call(TableColumn param) {
        TableCell<Pixel, String> cell = new TableCell<>() {
            public void updateItem(String s, boolean empty) {
                if (s != null) {
                    HBox box = new HBox();
                    box.setSpacing(10);
                    VBox vbox = new VBox();

                    ImageView imageview = new ImageView();
                    imageview.setFitHeight(50);
                    imageview.setFitWidth(50);
                    ThumbnailFromHexValue compThumb = new ThumbnailFromHexValue(s);
                    imageview.setImage(compThumb.returnImage());

                    box.getChildren().addAll(imageview, vbox);
                    //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                    setGraphic(box);
                }
            }
        };
        if (click != null) {
            cell.setOnMouseClicked(click);
        }
        return cell;
    }
}
