package Functions;

import Controller.ExceptionController;
import Models.ProgramException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class MinimumUsesFromTextField {

    private int uses;

    //MinimumUsesFromTextField is a method that gets the number from the text field. SimplifyNumberOfColors uses it for DeleteRareColors

    public MinimumUsesFromTextField(String stringInTextField) throws Exception {

        //Checks textField for minimumUses, if field is blank assumes 0
        Boolean containsNonDigit = false;
        for( int i = 0; i < stringInTextField.length(); i++) {
            if(!Character.isDigit(stringInTextField.charAt(i))) {
                containsNonDigit = true;
            }
        }

        if (containsNonDigit) {
            stringInTextField = "";
            ProgramException programException = new ProgramException("The value you entered within the textBox contained non-numeric characters, all colors will be shown");
        }

        if (stringInTextField.equals("")) {
            this.uses = 0;
        } else {
            this.uses = Integer.parseInt(stringInTextField);
        }
    }

    public int asInt() {
        return this.uses;
    }
}
