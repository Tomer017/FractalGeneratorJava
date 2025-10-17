package Fractal;

import Utility.Fractal;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MandelbrotFractal extends Fractal {
    private int x, y;
    private final int width = 1920;
    private final int height = 1080;
    private BufferedImage image;

    public MandelbrotFractal(int maxIter){
        super(maxIter);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    }

    @Override
    public void generateFractal(){
        for (int px = 0; px < width; px++){
            for (int py = 0; py < height; py++){
                double a = getXmin() + (getXmax() - getXmin()) * ((double) px / (width - 1.0));
                double b = getYmax() - ((getYmax() - getYmin()) * ((double) py / (height - 1.0)));

                double x = 0.0;
                double y = 0.0;

                int iter = 0;

                while (x*x + y*y <= 4 && iter < getMaxIter()) {
                    double xTemp = x*x - y*y + a;
                    double yTemp = 2*x*y + b;

                    x = xTemp;
                    y = yTemp;

                    iter++;
                }

                Color color;
                if (iter == getMaxIter()) {
                    color = Color.BLACK;
                    image.setRGB(px, py, color.getRGB());
                } else{
                    int shade = (int) (255.0 * iter/getMaxIter());
                    color = new Color(shade, 150, 255 - shade);
                    image.setRGB(px, py, color.getRGB());
                }
            }
        }

    }

    @Override
    public void render(Graphics2D g){
        if (image == null){
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }

        int color = image.getRGB(width/2, height/2);

        if (color == 0x00000000){
            generateFractal();
        }
        g.drawImage(image, 0, 0 , null);
    }
}
