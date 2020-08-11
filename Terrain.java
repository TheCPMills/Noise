import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Terrain {
    private static final int WIDTH = 512;
    private static final int HEIGHT = 256;
    private static final double SEPARATION = 7;
    private static int NOISE_ROW = (int) (Math.random() * 512);
    public static BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public static BufferedImage file;

    public static void main(String[] args) throws IOException {
        setRef("noise.png");
        for(int i = 0; i < WIDTH; i++) {
            int location = (HEIGHT / 2) + ((int) ((getPixelColor(i, NOISE_ROW) / SEPARATION) + 0.5)) - ((int) (128 / SEPARATION));
            for(int j = 0; j < HEIGHT; j++) {
                if(j > location) {
                    setPixelColor(i, j, 0x299432);
                } else if(j == location) {
                    setPixelColor(i, j, 0x60301A);
                } else {
                    setPixelColor(i, j, 0x6FB5D8);
                } 
            }
        }
        for (int i = 0; i < WIDTH; i++) {
            setPixelColor(i, HEIGHT / 2, 0xFFFFFF);
        }
        ImageIO.write(image, "png", new File("terrain.png"));
    }

    public static int getPixelColor(int x, int y) throws IOException {
        File file = new File("noise.png");
        BufferedImage image = ImageIO.read(file);

        int clr = image.getRGB(x, y);
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;
        if(red != green || green != blue || blue != red) {
            System.out.println("Somehow, this color is not a shade of grey. But not to worry! It is all taken care of. Just thought you should know.");
        }
        return red;
    }

    public static void setPixelColor(int x, int y, int hexColor) {
        image.setRGB(x, y, hexColor);
    }

    public static void setRef(String fileName){
        try {
            ImageIO.read(new File(fileName));
        } catch(IOException ex) {};
    }
}