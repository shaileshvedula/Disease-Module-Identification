/*
 * ReadInputData.java
 *
 * Version 1.0
 *
 * Copyright (C) 2016- Shailesh Vedula
 * Department of Industrial and Operations Engineering
 * University of Michigan Ann Arbor, MI
 *
 * Date: September 8 2016
 */

package org.svedula.dream.dmi;

import com.google.common.collect.Table;
import org.jblas.DoubleMatrix;
import java.io.IOException;
import java.lang.*;
import java.util.*;

/**
 * Forming the transition matrix.
 */

@Deprecated public class TransitionMatrix {

    /* This class uses JBLAS library for the underlying matrix computations
     * Deprecated because of problems with off the shelf linear algebra libraries.
     */

    String dataFile;
    Table<Integer, Integer, Double> networkGraph = null;
    ReadInputData readInputData;
    ArrayList<Integer> nodeList = new ArrayList<Integer>();
    DoubleMatrix transitionMatrix = new DoubleMatrix();
    int lowestNode;
    int highestNode;

    public TransitionMatrix(String dataFile) {
        this.dataFile = dataFile;
    }

    public void MakeTransitionMatrix() throws IOException {
        readInputData = new ReadInputData(dataFile);
        networkGraph = readInputData.ConvertInputData();
        nodeList.add(Collections.max(networkGraph.rowKeySet()));
        nodeList.add(Collections.max(networkGraph.columnKeySet()));
        nodeList.add(Collections.min(networkGraph.rowKeySet()));
        nodeList.add(Collections.min(networkGraph.columnKeySet()));
        lowestNode = Collections.min (nodeList);
        highestNode = Collections.max (nodeList);
        System.out.println("The lowest numbered node in the graph is:" + lowestNode);
        System.out.println("The highest numbered node in the graph is:" + highestNode);

        int testSize = 2000;
        transitionMatrix = transitionMatrix.zeros(testSize, testSize);
        for (int i = lowestNode; i< testSize; ++i) {
            for (int j = lowestNode; j< testSize; ++j) {
                double value;
                if (networkGraph.contains((Object) i, (Object) j)) {
                     value = networkGraph.get((Object) i, (Object) j);
                } else if (networkGraph.contains((Object) j, (Object) i)) {
                     value = networkGraph.get((Object) j, (Object) i);
                } else {
                     value =0.0;
                }
                transitionMatrix.put(i, j, value);
            }
        }
        System.out.println("Adjacency matrix constructed");



    }
}
