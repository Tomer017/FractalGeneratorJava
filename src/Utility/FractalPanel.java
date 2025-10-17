package Utility;

import javax.swing.*;
import Fractal.MandelbrotFractal;

import java.awt.*;

public class FractalPanel extends JPanel {
    MandelbrotFractal fractal;

    public FractalPanel(MandelbrotFractal fractal) {
        this.fractal = fractal;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        fractal.render(g2);
    }
}
