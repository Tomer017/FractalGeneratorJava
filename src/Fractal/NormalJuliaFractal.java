package Fractal;

import Utility.Fractal;
import java.awt.*;
import java.awt.image.BufferedImage;

public class NormalJuliaFractal extends Fractal {
    private final int width = 1920;
    private final int height = 1080;
    private BufferedImage image;
    private boolean fractalGenerated = false;


    public NormalJuliaFractal(int numIter){
        super(numIter);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void generateFractal(){
        for (int px = 0; px < width; px++){
            for (int py = 0; py < height; py++){
                // zx represents the real part of z
                double zx = getXmin() + (getXmax() - getXmin()) * ((double) px / (width - 1.0));
                // zy represents the imaginary part of z
                double zy = getYmax() - ((getYmax() - getYmin()) * ((double) py / (height - 1.0)));

                double cx = 0.0;
                double cy = 0.0;

                int iter = 0;


                while (zx * zx + zy * zy <= 10 && iter < getMaxIter()){
                    double xtemp = zx * zx - zy * zy;
                    zy = 2 * zx * zy + cy;
                    zx = xtemp + cx;
                    iter++;
                }

                Color color = null;
                if (iter == getMaxIter()){
                    color = Color.BLACK;
                }
                else {
                    int shade = (int) (255.0 * iter/getMaxIter());
                    color = new Color(shade, 150, 255 - shade);
                    image.setRGB(px, py, color.getRGB());
                }
            }
        }
        fractalGenerated = true;
    }

    @Override
    public void render(Graphics2D g) {
        if (image == null){
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }
    
        if (!fractalGenerated){
            generateFractal();
        }
        g.drawImage(image, 0, 0 , null);
    }
}
