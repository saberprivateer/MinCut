package com.mincut.app;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.logging.log4j.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
//import org.junit.Test;

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

    @org.junit.Test
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