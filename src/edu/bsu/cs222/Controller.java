package edu.bsu.cs222;

import com.sun.xml.internal.bind.v2.TODO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class Controller {

    @FXML
    public Button FileButton;

    @FXML
    public TextField minimumUsesTextField;

    public void ChooseImageFromFile() throws Exception {

        ImageView imageView = new FilePicker().returnImageView();

       //TODO: Make ShowSelectedPicture check null inside class
        ShowSelectedPicture showSelectedPicture = null;
        if (imageView != null) {
            showSelectedPicture = new ShowSelectedPicture(imageView);
        }
        Objects.requireNonNull(showSelectedPicture).picture();


        //TODO: Condense
        Image forColors = imageView.getImage();
        LinkedList<Pixel> pixelList = new ScanPictureForColors(forColors).returnPixel();



        SimplifyColors sc = new SimplifyColors(pixelList);
        sc.DeleteRepeatColors();
        pixelList = sc.returnShrunkList();


        FXMLLoader tableLoader = new FXMLLoader(getClass().getClassLoader().getResource("tableView.fxml"));
        TableController TableController = new TableController();
        TableController.setParameters(pixelList);
        tableLoader.setController(TableController);

        HBox root = tableLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


        /** Redundant because of new features in Pixel()
        LinkedList<String> HexValues = new LinkedList<>();
        LinkedList<Display> displays = new LinkedList<>();

        //Shrink array of hexValues before putting them into the DisplayArray
        for (int i = 0; i < pixelList.size(); i++) {
            String hex = new ReturnStringHexValue().returnStringHexValue(pixelList.get(i));
            HexValues.add(i, hex);
        }



        List<String> ShrinkedHexValues;
        SimplifyColors simplifyColors = new SimplifyColors();

        //TODO: Refactor/format code so that this is done on the same list which DeleteRarelyUsedColors is done on
        ShrinkedHexValues = simplifyColors.DeleteRepeatColors(HexValues);
        List<Integer> count = simplifyColors.getCount();

        for (int k = 0; k < ShrinkedHexValues.size(); k++) {
            Display display = new Display();
            display.setHex(ShrinkedHexValues.get(k));
            display.setCount(count.get(k));
            displays.add(k, display);
        }

        //Checks textField for minimumUses, if field is blank assumes 0
        //TODO: Deal with non integer values being entered into the textField
        String stringInTextField = minimumUsesTextField.getCharacters().toString();

        Boolean containsNonDigit = false;
        for( int i = 0; i < stringInTextField.length(); i++) {
            if(!Character.isDigit(stringInTextField.charAt(i))) {
                containsNonDigit = true;
            }
        }

        if (containsNonDigit == true) {
            //TODO: Create a Visual exception
            stringInTextField = "";
            System.out.println("The value you entered within the textBox contained non-numeric characters, try again");
        }


        int uses;
        if (stringInTextField.equals("")) {
           uses = 0;
       } else {
           uses = Integer.parseInt(stringInTextField);
       }

        

        //TODO: Display a message for when all elements in a table have been deleted:
        displays = simplifyColors.DeleteRarelyUsedColors(displays,uses);


        FXMLLoader tableLoader = new FXMLLoader(getClass().getClassLoader().getResource("tableView.fxml"));
        TableController TableController = new TableController();
        TableController.setParameters(displays);


        tableLoader.setController(TableController);
        HBox root = tableLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
         **/
    }

}
