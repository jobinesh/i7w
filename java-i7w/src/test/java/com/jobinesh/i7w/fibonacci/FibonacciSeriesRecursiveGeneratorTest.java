/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.fibonacci;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmpurush
 */
public class FibonacciSeriesRecursiveGeneratorTest {
    
    public FibonacciSeriesRecursiveGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSize method, of class FibonacciSeriesRecursiveGenerator.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        FibonacciSeriesRecursiveGenerator instance = new FibonacciSeriesRecursiveGenerator();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSize method, of class FibonacciSeriesRecursiveGenerator.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int size = 0;
        FibonacciSeriesRecursiveGenerator instance = new FibonacciSeriesRecursiveGenerator();
        instance.setSize(size);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateSeries method, of class FibonacciSeriesRecursiveGenerator.
     */
    @Test
    public void testGenerateSeries() {
        System.out.println("generateSeries");
        FibonacciSeriesRecursiveGenerator instance = new FibonacciSeriesRecursiveGenerator();
        instance.generateSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFibonacci method, of class FibonacciSeriesRecursiveGenerator.
     */
    @Test
    public void testGetFibonacci() {
        System.out.println("getFibonacci");
        int number = 0;
        FibonacciSeriesRecursiveGenerator instance = new FibonacciSeriesRecursiveGenerator();
        int expResult = 0;
        int result = instance.getFibonacci(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printSerires method, of class FibonacciSeriesRecursiveGenerator.
     */
    @Test
    public void testPrintSerires() {
        System.out.println("printSerires");
        FibonacciSeriesRecursiveGenerator instance = new FibonacciSeriesRecursiveGenerator();
        instance.printSerires();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    
}
