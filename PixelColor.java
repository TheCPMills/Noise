import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class PixelColor {
    public static void main(String args[]) throws IOException {
        File file = new File("noise.png");
        BufferedImage image = ImageIO.read(file);
        // Getting pixel color by position x and y 
        int clr = image.getRGB(0, 0);
        int red =   (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue =   clr & 0x000000ff;
        System.out.println("Red Color value = " + red);
        System.out.println("Green Color value = " + green);
        System.out.println("Blue Color value = " + blue);
    }
}