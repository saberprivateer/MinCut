package com.mincut.app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
    public void testParser() throws URISyntaxException, IOException {
        ArrayList<int[]> nodes = new ArrayList<>();
        Main.parsedata(nodes, "kargerMinCut","tab");
        Assert.assertEquals("Can find a number in the text file", 154, nodes.get(9)[3]);
    }

    @Test
    public void testData() throws URISyntaxException, IOException {
        String[] arr = Main.data("kargerMinCut");
        Assert.assertEquals("Reading a graph of 200 lines", arr.length, 200);
        Assert.assertTrue(!arr[3].isEmpty());
    }

    @Test
    public void testMinCut() throws URISyntaxException, IOException {
        ArrayList<int[]> nodes = new ArrayList<>();
        Main.parsedata(nodes,"testcase1","space");
        Main.mincut(nodes);
        Assert.assertTrue(true);
    }

    @Test
    public void testTestcase() throws URISyntaxException, IOException {
        Main.testcases("testcase1","space");
        Assert.assertEquals("First test case is 2 ", Main.minlen, 2);
        //Assert.assertEquals("Second test case is 1 ",test2,1);
        //Assert.assertEquals("Third test case is 3 ",test1,3);
    }

    @Test
    public void testLog() {
        Main.log(9);
        Assert.assertEquals("Ints work", Integer.toString(9), outContent.toString().trim());
    }

    @Test
    public void testLogtext() {
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