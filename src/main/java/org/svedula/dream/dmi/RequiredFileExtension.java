/*
 * RequiredFileExtension.java
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
 * This class fetches only the file with the desired extension from a directory. It implements FilenameFilter interface.
 */
public class RequiredFileExtension implements FilenameFilter{
    String extension;

    public RequiredFileExtension( String extension){
        this.extension = "." + extension.toLowerCase();
    }

    public boolean accept(File directory, String name){
        return name.endsWith(extension);
    }
}
