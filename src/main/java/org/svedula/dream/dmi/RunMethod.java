/*
 * ReadInputData.java
 *
 * Version 1.0
 *
 * Copyright (C) 2016- Shailesh Vedula
 * Department of Industrial and Operations Engineering
 * University of Michigan Ann Arbor, MI
 *
 * Date: September 9 2016
 */

package org.svedula.dream.dmi;

import com.google.common.collect.Table;
import java.io.IOException;
import java.lang.*;

/**
 * This class contains the main method
 */

public class RunMethod {

    public static void main(String args[]) throws IOException {
        DataDirectory dataDirectory = new DataDirectory();
        String[] InputFiles = dataDirectory.GetDataFiles();
        TransitionMatrix transitionMatrix = new TransitionMatrix(InputFiles[0]);
        transitionMatrix.MakeTransitionMatrix();

    }
}
