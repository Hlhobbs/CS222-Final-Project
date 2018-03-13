package edu.bsu.cs222;

import java.util.Scanner;

public class Controller {

    private Scanner scanner = new Scanner(System.in);
    private int InputType = -1;


    Controller() {
    }

    public int getInputType() {
        System.out.println("Enter 1 for URL or 2 for File to choose where to locate image");
        this.InputType = scanner.nextInt();
        return InputType;
    }

    public String imageURL() {
            System.out.println("Enter the exact URL of an image");
            Scanner urlScanner = new Scanner(System.in);
        return urlScanner.nextLine();
    }
}
