import Fractal.MandelbrotFractal;
import Utility.FractalPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Scanner scnr = new Scanner(System.in);
        int numIters;

        System.out.println("How many iterations would you like to do");
        numIters = scnr.nextInt();

        MandelbrotFractal mbf = new MandelbrotFractal(numIters);



        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.add(new FractalPanel(mbf));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
