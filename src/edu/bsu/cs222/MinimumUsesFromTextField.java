package edu.bsu.cs222;

public class MinimumUsesFromTextField {

    private int uses;

    //MinimumUsesFromTextField is a method that gets the number from the text field. SimplifyNumberOfColors uses it for DeleteRareColors

    public MinimumUsesFromTextField(String stringInTextField) {

        //Checks textField for minimumUses, if field is blank assumes 0
        Boolean containsNonDigit = false;
        for( int i = 0; i < stringInTextField.length(); i++) {
            if(!Character.isDigit(stringInTextField.charAt(i))) {
                containsNonDigit = true;
            }
        }

        if (containsNonDigit == true) {
            stringInTextField = "";
            System.out.println("The value you entered within the textBox contained non-numeric characters, try again");
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
