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
 * @author Jobinesh
 */
public class FibonacciSeriesMemorizedGeneratorTest {
    
    public FibonacciSeriesMemorizedGeneratorTest() {
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
     * Test of getSize method, of class FibonacciSeriesMemorizedGenerator.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        FibonacciSeriesMemorizedGenerator instance = new FibonacciSeriesMemorizedGenerator();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSize method, of class FibonacciSeriesMemorizedGenerator.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int size = 0;
        FibonacciSeriesMemorizedGenerator instance = new FibonacciSeriesMemorizedGenerator();
        instance.setSize(size);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateSeries method, of class FibonacciSeriesMemorizedGenerator.
     */
    @Test
    public void testGenerateSeries() {
        System.out.println("generateSeries");
        FibonacciSeriesMemorizedGenerator instance = new FibonacciSeriesMemorizedGenerator();
        instance.generateSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printSerires method, of class FibonacciSeriesMemorizedGenerator.
     */
    @Test
    public void testPrintSerires() {
        System.out.println("printSerires");
        FibonacciSeriesMemorizedGenerator instance = new FibonacciSeriesMemorizedGenerator();
        instance.printSerires();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    
}
