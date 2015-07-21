package com.mincut.app;
/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.ToIntFunction;
*/

public class Main
{

    //public static long countcomparison = 0;
    //public static long counteach = 0;

    public static void log(Object args) {
        System.out.println(args.toString());
    }

    public static void mincut() {

    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Begin Code");


        int[] testcase = new int[]{3, 8, 2, 5, 1, 4, 7, 6};
        int[] testcase2 = new int[]{2, 1};
        int[] testcase3 = new int[]{1};
        int[] testcaseforum = new int[]{7, 5, 1, 4, 8, 3, 10, 2, 6, 9};
        int[] testcaseforum2 = new int[]{8, 10, 1, 9, 7, 2, 6, 3, 5, 4};

        /*
        Main.countcomparison = 0;
        Main.counteach = 0;
        int[] arr = data();
        log("Before sort:");
        System.out.println(Arrays.toString(arr));
        partition(arr, "first", 0, arr.length);
        System.out.println(Arrays.toString(arr));
        log("Comparisons, pivot on the ? element: " + Main.countcomparison);
        log("Comparisons, brute force: " + Main.counteach);
        log("");
        */


                //Now With Coverage?
                log("End of Code");
    }
/*
    public static int[] data() {
        System.out.println("Reading File from Java code");
        //Name of the file
        String fileName = "/Users/Kristin/Desktop/QuickSort.txt";
        ArrayList<String> integers = new ArrayList<String>();
        ArrayList<Integer> ints = new ArrayList<Integer>();
        try {
            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);
            //Variable to hold the one line data
            String line;
            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                ints.add(Integer.parseInt(line));
            }
            //Close the buffer reader
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        int[] arr = ints.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer i) {
                return i;
            }
        }).toArray();
        return arr;
    }
*/
}
