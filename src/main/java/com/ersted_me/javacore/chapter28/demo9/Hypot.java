package main.java.com.ersted_me.javacore.chapter28.demo9;

import java.util.concurrent.Callable;

class Hypot implements Callable<Double> {
    double side1, side2;

    public Hypot(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt((side2 * side2) + (side2 * side2));
    }
}
