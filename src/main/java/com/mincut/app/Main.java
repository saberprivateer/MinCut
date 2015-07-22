package com.mincut.app;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;


public class Main {

    public static long minlen = 10000;
    //public static long counteach = 0;

    public static void log(Object args) {
        System.out.println(args.toString());
    }

    public static void mincut(ArrayList<int[]> nodes) {
        //While there are more than 2 vertices
        //log("The list as program starts");
        //plist(nodes);
        if (nodes.size() == 2) {
            int cuts;
            cuts = nodes.get(0).length - 1;
            Main.minlen = Math.min(Main.minlen,cuts);
            log("the number of cuts is " + cuts + ".");
        } else {
            //Pick a remaining edge (u,v) uniformly at random
            Random randu = new Random();
            Random randv = new Random();
            //log("the node size "+nodes.size()+" at start.");
            int u = randu.nextInt(nodes.size());
            //log(u);
            int v = randv.nextInt(nodes.get(u).length - 1) + 1;
            //log(v);
            //log("the chosen edge is " + nodes.get(u)[0] + " and " + nodes.get(u)[v] + ".");


            //merge u and v into a single vertex
            int[] contract = nodes.get(u);
            int pairindex;
            nodes.remove(u);
            //log("the list after nixing the chosen node");
            //plist(nodes);
            boolean dupes = true;
            //log("The removed node looks like this: "+Arrays.toString(contract));
            for (int i = 1; i < contract.length; i++) {
                //Iterate to replace the vertex for each node associated with cut
                int swap = contract[i];
                for (int j = 0; j < nodes.size(); j++) {
                    if (swap == nodes.get(j)[0]) {
                        for (int k = 1; k < nodes.get(j).length; k++) {
                            if (nodes.get(j)[k] == contract[0]) {
                                nodes.get(j)[k] = contract[v];
                            }
                        }
                        if ((nodes.get(j)[0] == contract[v])&&dupes) {
                            //Combine the two nodes
                            int[] newvertex = new int[contract.length + nodes.get(j).length - 1];
                            System.arraycopy(nodes.get(j), 0, newvertex, 0, nodes.get(j).length);
                            System.arraycopy(contract, 1, newvertex, nodes.get(j).length, contract.length - 1);
                            nodes.set(j, newvertex);

                            //remove self-loops

                            int[] total = nodes.get(j);
                            //log("the new total array "+Arrays.toString(total));
                            ArrayList<Integer> al = new ArrayList<>();
                            for (int p : total) {
                                al.add(p);
                            }
                            //log("the size "+al.size()+" and "+total.length+" should be the same.");

                            for (int o = 1; o < al.size(); o++) {
                                if (al.get(o) == total[0]) {
                                    al.remove(o);
                                    o--;
                                }
                            }
                            int[] selfloopsremoved = new int[al.size()];
                            for (int m = 0; m < al.size(); m++) {
                                selfloopsremoved[m] = al.get(m);
                            }
                            //log(Arrays.toString(selfloopsremoved) + " self-loops removed");
                            nodes.set(j, selfloopsremoved);
                            dupes = false;
                        }
                    }
                }
            }

            //log("new node size is " + nodes.size());
            /*
            for (int[] p : nodes) {
                log(Arrays.toString(p));
            }
            */

            mincut(nodes);
        }
    }

    public static void plist(ArrayList<int[]> arl) {
        for (int[] p : arl) {
            log(Arrays.toString(p));
        }
    }

    public static void testcases(String al, String dl) throws URISyntaxException, IOException {
        ArrayList<int[]> nodes1 = new ArrayList<>();

        for (int i = 0; i<100;i++) {
            nodes1.clear();
            parsedata(nodes1, al, dl);
            mincut(nodes1);
        }
        log(Main.minlen+" is the min length");
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        // write your code here
        System.out.println("Begin Code");

        ArrayList<int[]> nodes = new ArrayList<>();
        parsedata(nodes, "kargerMinCut", "tab");
        int test1 = 0, test2 = 0, test3 = 0;
        testcases("kargerMinCut","tab");
        //log(Arrays.toString(nodes.get(0)));


        //System.out.println(Arrays.toString(grph[0]));
        //log("The Adjacency List");

        //mincut(arr);

        //System.out.println(System.getProperty("user.dir"));
        //Now With Coverage?
        log("End of Code");
    }

    public static void parsedata(ArrayList<int[]> nodes, String datafile, String delim) throws URISyntaxException, IOException {
        //log("Read " + datafile + " as an array of strings");
        String[] arr = data(datafile);
        //System.out.println(arr[0]);

        //log(arr.length+" is the length of arr");

        //log("Convert the strings of " + datafile + " into integer arrays in a list");
        //int[][] grph = new int[200][200];
        //log("the length of arr is " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            String[] temp;
            if (Objects.equals(delim, "tab")) {
                temp = arr[i].split("\t");
            } else {
                //log(arr[i]);
                temp = arr[i].split("\\s+");
            }
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

    public static String[] data(String datafile) throws URISyntaxException, IOException {
        //System.out.println("Opening " + datafile + ".");
        //Name of the file
        String filePath = new File("").getAbsolutePath();
        String fullPath = filePath + "/src/Files/" + datafile + ".txt";
        //System.out.println (filePath);
        //String fileName = "/src/Files/kargerMinCut.txt";
        ArrayList<String> integers = new ArrayList<String>();
        ArrayList<Integer> ints = new ArrayList<Integer>();

        LineNumberReader lnr = new LineNumberReader(new FileReader(new File(fullPath)));
        lnr.skip(Long.MAX_VALUE);
        //System.out.println(lnr.getLineNumber());
        //Add 1 because line index starts at 0
        // Finally, the LineNumberReader object should be closed to prevent resource leak
        String[] arr = new String[lnr.getLineNumber() + 1];
        lnr.close();
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
