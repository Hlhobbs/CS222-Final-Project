package Models;

import Controller.ExceptionController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ProgramException {

    public ProgramException(String exception) throws IOException {
        ExceptionController eC = new ExceptionController();
        eC.setException(exception);
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("resources/exceptionFXML.fxml")));
        loader.setController(eC);

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("exception");
        stage.setScene(new Scene(root, 300, 25));
        stage.show();
    }

}
