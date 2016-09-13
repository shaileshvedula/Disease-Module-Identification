/*
 * PostProcessing.java
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

import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.lang.*;

/**
 * Post processing the output files to contains only those modules which have between 3 and 100 nodes..
 */

public class PostProcessing {
    DataDirectory dataDirectory;
    String[] outputFiles;
    BufferedReader inputStream;
    BufferedReader outputStream;
    String outDir;
    String processedDir;

    public void PostProcess() throws IOException {
        outDir = "/Users/ishan/Dream/output";
        processedDir = "/Users/ishan/Dream/processed";
        dataDirectory = new DataDirectory(outDir);
        outputFiles = dataDirectory.GetDataFiles();
        String line;
        for (int i = 0; i < outputFiles.length; ++i) {
            int temp = 0;
            inputStream = null;
            inputStream = new BufferedReader(new FileReader(outputFiles[i]));

            File processOut = new File(processedDir + outputFiles[i]);
            FileOutputStream fos = new FileOutputStream(processOut);
            outputStream = null;
            BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(fos));

            try {
                while ((line = inputStream.readLine()) != null) {
                    String[] clusters = line.split("\n");
                    for (int j = 0; j < clusters.length; ++j) {
                        String[] nodes = clusters[j].split("\t");
                        if (nodes.length >= 3 && nodes.length <= 100) {
                            String joined = StringUtils.join(nodes, "\t");
                            outputStream.write(Integer.toString(j) + "\t" + "0.5" + "\t" + joined);
                            temp+=1;
                        }
                    }
                }
                System.out.println("The number of required clusters in the network:" + outputFiles[i] + "=" + temp);
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }
}
