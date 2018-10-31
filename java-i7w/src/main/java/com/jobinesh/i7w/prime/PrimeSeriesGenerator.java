/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.prime;

import com.jobinesh.i7w.fibonacci.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jobinesh
 */
public class PrimeSeriesGenerator {

    private int serires[] = null;
    private int seriesSize = 100;

    public PrimeSeriesGenerator() {

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
        int index = 0;
        int i = 2;
        while (index < seriesSize) {

            if (NumberUtil.isPrime(i)) {
                serires[index++] = i;
            }
            i++;
        }
    }

    public void printSerires() {
        System.out.println(Arrays.toString(serires));
    }

    public static void main(String[] arg) {
        PrimeSeriesGenerator generator = new PrimeSeriesGenerator();
        generator.setSize(20);
        generator.generateSeries();
        generator.printSerires();
    }
}
