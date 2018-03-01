package bsu.edu.cs222;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tests {

    @Test
    public void PictureTest(){
        BufferedImage picture = null;
        try{
            picture = ImageIO.read(new File("/Users/HaydenHobbs/Desktop/L.jpg"));
        } catch (IOException e){

        }
        
    }
}
