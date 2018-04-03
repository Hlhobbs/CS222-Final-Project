package edu.bsu.cs222;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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

        if (containsNonDigit == true) {
            stringInTextField = "";
            String exception = "The value you entered within the textBox contained non-numeric characters, all colors will be shown";
            exceptionController eC = new exceptionController();
            eC.setException(exception);
            eC.start(new Stage());
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
