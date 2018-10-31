/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.fibonacci;

import java.util.Arrays;

/**
 *
 * @author Jobinesh
 */
public class FibonacciSeriesRecursiveGenerator implements FibonacciSeriesGenerator {

    private int serires[] = null;
    private int seriesSize = 100;

    public int getSize() {
        return seriesSize;
    }

    public void setSize(int size) {
        this.seriesSize = size;
        serires = new int[seriesSize];
    }

    public void generateSeries() {
        if (serires == null) {
            serires = new int[seriesSize];
        }

        for (int i = 1; i <= seriesSize; i++) {
            serires[i-1] = getFibonacci(i);
        }
    }

    protected int getFibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        } else {
            return getFibonacci(number - 2) + getFibonacci(number - 1);
        }
    }

    public void printSerires() {
        System.out.println(Arrays.toString(serires));
    }

    public static void main(String[] arg) {
        FibonacciSeriesRecursiveGenerator generator = new FibonacciSeriesRecursiveGenerator();
        generator.setSize(20);
        generator.generateSeries();
        generator.printSerires();
    }

}
