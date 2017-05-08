import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Drawer {
    public static void drawImage(int[][] bits, String path, int mul) throws IOException {
        int size = bits.length;
        int black = Color.BLACK.getRGB();
        int white = Color.WHITE.getRGB();
        BufferedImage image = new BufferedImage(mul*size, mul*size, BufferedImage.TYPE_INT_RGB );

        for ( int i = 0; i < size; i++ ) {
            for ( int j = 0; j < size; j++ ) {
                if(bits[i][j]==1) drawMulPoints(mul, black, image, i, j);
                else drawMulPoints(mul, white, image, i, j);
            }
        }
        File file = new File(path+".png");
        ImageIO.write(image, "png", file);
    }

    private static void drawMulPoints(int mul, int color, BufferedImage image, int i, int j) {
        for (int k = 0; k < mul; k++) {
            for (int l = 0; l < mul; l++) {
                image.setRGB(mul*i + k, mul*j + l, color);
                image.setRGB(mul*i + k, mul*j + l, color);
            }
        }
    }
}
