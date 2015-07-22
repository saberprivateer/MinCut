package com.mincut.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    //public static long countcomparison = 0;
    //public static long counteach = 0;

    public static void log(Object args) {
        System.out.println(args.toString());
    }

    public static void mincut(int cuts, String datafile) {


    }

    public static void testcases(int test1, int test2, int test3) {
        mincut(test1, "testcase1");
        mincut(test2, "testcase2");
        mincut(test3, "testcase3");

    }

    public static void main(String[] args) throws URISyntaxException {
        // write your code here
        System.out.println("Begin Code");


        ArrayList<int[]> nodes = new ArrayList<>();
        parsedata(nodes, "kargerMinCut");
        int test1 = 0, test2 = 0, test3 = 0;
        testcases(test1, test2, test3);


        //System.out.println(Arrays.toString(grph[0]));
        //log("The Adjacency List");

        //mincut(arr);

        //System.out.println(System.getProperty("user.dir"));
        //Now With Coverage?
        log("End of Code");
    }

    public static void parsedata(ArrayList<int[]> nodes, String datafile) throws URISyntaxException {
        log("Read the text file as an array of strings");
        String[] arr = data(datafile);
        //System.out.println(arr[0]);

        //log(arr.length+" is the length of arr");

        log("Convert the strings into integer arrays in a list");
        //int[][] grph = new int[200][200];
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split("\t");
            int[] temparr = new int[temp.length];
            //ArrayList<Integer> singleList = new ArrayList<Integer>();
            for (int j = 0; j < temp.length; j++) {
                temparr[j] = Integer.valueOf(temp[j]);
                //grph[i][j] = Integer.parseInt(temp[j]);
            }
            nodes.add(temparr);
            //log(temp.length);
        }
        //System.out.println(Arrays.toString(nodes.get(0)) + " length of "+nodes.get(0).length);
        //System.out.println(Arrays.toString(nodes.get(199)) + " length of "+nodes.get(199).length);
        /*
        for (int i = 0; i<200; i++) {
            log(nodes.get(i).length);
        }
        */
    }

    public static String[] data(String datafile) throws URISyntaxException {
        System.out.println("Opening File");
        //Name of the file
        String filePath = new File("").getAbsolutePath();
        //System.out.println (filePath);
        //String fileName = "/src/Files/kargerMinCut.txt";
        ArrayList<String> integers = new ArrayList<String>();
        ArrayList<Integer> ints = new ArrayList<Integer>();
        String[] arr = new String[200];
        try {
            //Create object of FileReader
            FileReader inputFile = new FileReader(filePath + "/src/Files/" + datafile + ".txt");
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);
            //Variable to hold the one line data
            String line;
            int i;
            i = 0;
            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                arr[i] = line;
                i++;
                // System.out.println(line);
            }
            //Close the buffer reader
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        /*
        int[] arr = ints.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer i) {
                return i;
            }
        }).toArray(); */
        return arr;
    }

}
