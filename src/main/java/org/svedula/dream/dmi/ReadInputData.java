/*
 * ReadInputData.java
 *
 * Version 1.0
 *
 * Copyright (C) 2016- Shailesh Vedula
 * Department of Industrial and Operations Engineering
 * University of Michigan Ann Arbor, MI
 *
 * Date: September 7 2016
 */

package org.svedula.dream.dmi;

import java.io.*;
import java.lang.*;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Reading the input data from the data files and storing it in a data structure.
 */

public class ReadInputData {

    /* This class uses the Table data structure available in Guava to store the graph as a multi key map*/

    String singleFile;
    BufferedReader inputStream;

    public ReadInputData(String singleFile) {
        this.singleFile = singleFile;
    }

    public Table<Integer, Integer, Double> ConvertInputData() throws IOException {
        inputStream = null;
        inputStream = new BufferedReader(new FileReader(singleFile));
        String line;
        Table<Integer, Integer, Double> graph = null;

        try {
            while ((line = inputStream.readLine()) != null) {
                String graphParts[] = line.split("\t");
                int node1 = Integer.parseInt(graphParts[0]);
                int node2 = Integer.parseInt(graphParts[1]);
                double weight = Double.parseDouble(graphParts[2]);

                graph = HashBasedTable.create();
                graph.put(node1, node2, weight);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return graph;
    }
}

