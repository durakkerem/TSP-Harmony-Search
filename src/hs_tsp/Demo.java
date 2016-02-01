/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs_tsp;

import java.util.Vector;

/**
 *
 * @author Kerem Durak
 */
public class Demo  {
    public static void main (String [] args) throws TSPException{
     HS_TSP hs = new HS_TSP("berlin52.tsp");
     //hs.setPAR(0.2);
     //hs.setHMCR(0.4);
    hs.generateHM(hs.getCoordVector());
   
    }
    
}
