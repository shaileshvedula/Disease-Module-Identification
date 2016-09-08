/*
 * DataDirectory.java
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

/**
 * This class fetches the the required training data files for the directory
 */

public class DataDirectory {
    String dirname;
    String extension;
    File file;
    FilenameFilter requiredFileExtension;
    String files[];
    String filePath[];

    public String[] GetDataFiles() {
        dirname ="/Dream/Data";
        extension = "txt";
        file = new File (dirname);
        requiredFileExtension = new RequiredFileExtension (extension);
        files= file.list(requiredFileExtension);

        for (int i = 0; i < files.length; ++i) {
            String path = dirname + files[i];
            filePath[i] = path;
        }

        return filePath;
    }
}
