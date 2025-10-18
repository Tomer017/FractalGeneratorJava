import Fractal.MandelbrotFractal;
import Fractal.NormalJuliaFractal;
import Utility.Fractal;
import Utility.FractalPanel;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Fractal f = null;
        frame.setSize(1920, 1080);
        frame.setVisible(true);

        int typeToGenerate = Integer.parseInt(
                JOptionPane.showInputDialog("Please enter the type of fractal you would like to generate: \n " +
                        "1. Mandelbrot Set\n" +
                        "2. Julia Set\n"));

        int numIters = Integer.parseInt(
                JOptionPane.showInputDialog("Please enter the number of iterations you would like to do: "
        ));


        switch (typeToGenerate){
            case 1:
                f = new MandelbrotFractal(numIters);
                break;
            case 2:
                f = new NormalJuliaFractal(numIters);
                break;
        }

        frame.add(new FractalPanel(f));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.repaint();
    }
}
