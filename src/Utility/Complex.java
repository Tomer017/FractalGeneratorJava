package Utility;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex square() {
        // (a + bi)^2 = a^2 - b^2 + 2abi
        double newReal = this.real * this.real - this.imaginary * this.imaginary;
        double newImaginary = 2 * this.real * this.imaginary;
        return new Complex(newReal, newImaginary);
    }

    public Complex add(Complex c) {
        double newReal = this.real + c.real;
        double newImaginary = this.imaginary + c.imaginary;
        return new Complex(newReal, newImaginary);
    }

    public double getMagnitudeSquared() {
        return this.real * this.real + this.imaginary * this.imaginary;
    }
}


