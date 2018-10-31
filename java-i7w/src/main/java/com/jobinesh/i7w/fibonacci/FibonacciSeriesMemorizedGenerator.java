/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jobinesh
 */
public class FibonacciSeriesMemorizedGenerator implements FibonacciSeriesGenerator{

    private int serires[] = null;
    private int seriesSize = 100;

    public FibonacciSeriesMemorizedGenerator() {

    }

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
        serires[0] = 1;
        serires[1] = 1;

        for (int i = 2; i < seriesSize; i++) {

            int fibonacci = serires[i - 1] + serires[i - 2];
            serires[i] = fibonacci;
        }
    }

    public void printSerires() {
        System.out.println(Arrays.toString(serires));
    }

    public static void main(String[] arg) {
        FibonacciSeriesMemorizedGenerator generator = new FibonacciSeriesMemorizedGenerator();
        generator.setSize(20);
        generator.generateSeries();
        generator.printSerires();
    }
}
