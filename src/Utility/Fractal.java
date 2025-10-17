package Utility;

import java.awt.*;

public class Fractal {
    private double xmin = -2.5;
    private double xmax = 1.0;
    private double ymin = -1.0;
    private double ymax = 1.0;
    int numIterations;



    public Fractal(int numIterations){
        this.numIterations = numIterations;
    }

    public void generateFractal(){

    }

    public void render(Graphics2D g){

    }

    public double getYmax() {
        return ymax;
    }

    public void setYmax(double ymax) {
        this.ymax = ymax;
    }

    public double getYmin() {
        return ymin;
    }

    public void setYmin(double ymin) {
        this.ymin = ymin;
    }

    public double getXmax() {
        return xmax;
    }

    public void setXmax(double xmax) {
        this.xmax = xmax;
    }

    public double getXmin() {
        return xmin;
    }

    public void setXmin(double xmin) {
        this.xmin = xmin;
    }

    public int getMaxIter(){
        return numIterations;
    }

    public void setMaxIter(int iter){
        this.numIterations = iter;
    }
}
