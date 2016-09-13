/*
 * MCL.java
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

import java.lang.*;
import java.io.*;

/**
 * Implementation of Markov Cluster Algorithm.
 */
public class MCL {

    /*The MCL algorithm is short for the Markov Cluster Algorithm, a fast and scalable unsupervised cluster algorithm
     *for graphs (also known as networks) based on simulation of (stochastic) flow in graphs.
     * The algorithm was invented/discovered by Stijn van Dongen at the
     * Centre for Mathematics and Computer Science (also known as CWI) in the Netherlands.
     *
     * In this class I have used the MCL software provided by Stijn Van Dojen at http://micans.org/mcl/
     *
     * References:
     * Stijn van Dongen, Graph Clustering by Flow Simulation, PhD thesis, University of Utrecht, May 2000.
     * ( http://www.library.uu.nl/digiarchief/dip/diss/1895620/inhoud.htm )
     *
     * Enright A.J., Van Dongen S., Ouzounis C.A., An efficient algorithm for large-scale detection of protein families,
     * Nucleic Acids Research 30(7):1575-1584 (2002).
     */

    public void RunMcl(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        System.out.println(command + " exitValue() " + process.exitValue());
    }
}
