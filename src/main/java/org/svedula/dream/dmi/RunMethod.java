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

import java.io.IOException;

/**
 * This class contains the main method
 */

public class RunMethod {

    public static void main(String args[]) throws IOException {
        DataDirectory dataDirectory = new DataDirectory("/Users/ishan/Dream/Data");
        String[] InputFiles = dataDirectory.GetDataFiles();
        String MCL_HOME = "/Users/ishan/local/bin";
        String outDir = "/Users/ishan/Dream/output/";
        MCL mcl = new MCL();
        for (int i = 0; i < InputFiles.length; ++i) {
            String[] out = InputFiles[i].split("/");
            //String[] temp = out[out.length-1].split("\\.");
            //String outfile = "out." + temp[0];
            String COMMAND = MCL_HOME + "/mcl" + " " + InputFiles[i] + " "
                                      + "--abc" + " " + "-o" +" " + outDir
                                      + out[out.length-1] + " " + "-I 7";
            try {
                mcl.RunMcl(COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PostProcessing postProcessing = new PostProcessing();
        postProcessing.PostProcess();
    }
}
