package com.mincut.app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testApp() {
        Assert.assertTrue(true);
    }

    @Test
    public void testData() {
        Main tester = new Main();
        String[] arr = Main.data();
        Assert.assertEquals("Reading a graph of 200 lines",arr.length,200);
    }

    @Test
    public void testMinCut() {
        Main tester = new Main();
        Main.mincut();
        Assert.assertTrue(true);
    }

    @Test
    public void testLog() {
        Main tester = new Main();
        Main.log(9);
        Assert.assertEquals("Ints work", Integer.toString(9), outContent.toString().trim());
    }

    @Test
    public void testLogtext() {
        Main tester = new Main();
        Main.log("hello");
        Assert.assertEquals("Text with quotes works", "hello", outContent.toString().trim());
    }

    /*
    @Test
    public void endtheprogram() {
        Main tester = new Main();
        //Main.main("arg");
        Assert.assertTrue(outContent.toString().contains("End of Code"));
    }
    */

}