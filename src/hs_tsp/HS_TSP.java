/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs_tsp;

import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kerem Durak
 */
public class HS_TSP {

    // public static int GRAPH_SIZE = 12;
    private int numberOfCities;
    private int numberOfIterations;
    private int HMS;                      //Harmony memory size
    private int individualsTested;        // Number of indivuduals tested in the current population
    private double averageFitness;        // Average fitness for current population
    private double maxFitness;            // Maximum fitness for current population
    private double totalFitness;          // Sum of all fitnesses for current population
    public TSPCoordinate[][] HarmonyMemory;
//  private TSPIndividual bestIndividual; // Best OVERALL individual
    private Vector coords;
   // private int graph[][];

    TSPFileParser parser;
    
    public static void main(String[] args) {
        
    }
    
    public boolean isCycle(TSPCoordinate tc) {
        
        return false;
    }
    
    public void generateHM(Vector v) {
        
        HarmonyMemory = new TSPCoordinate[HMS][numberOfCities+1]; // +1 for the last column that is for results.
        int j = 0;
      //  System.out.println("HMS:"+HMS);
      //  System.out.println("numberofcities:"+numberOfCities);
                
        for (int i = 0; i < HMS; i++) { //outer, one complete
            
            Vector tempVector =(Vector) v.clone();   // clone vector to use it temporarily. 
            int tempCitySize = numberOfCities;
        //     System.out.println("i: "+i);

            for (int k = 0; k < numberOfCities; k++){ // inner, route
           

            
            int chosenOne = (int) (Math.random() * ((tempCitySize)));
          //  System.out.println("Chosen one:"+chosenOne);
          //  System.out.println("Capacity:"+tempVector.size());
                
            TSPCoordinate tempCoo=  (TSPCoordinate) tempVector.get(chosenOne);

            HarmonyMemory[i][k] = tempCoo;
             System.out.println("Generated city coo:"+tempCoo.getX()+", "+tempCoo.getY());

            tempVector.remove(chosenOne);
            tempCitySize--;

            
            
            
        }
//calculate the fitness values            
        }
        
 

          
    }
    
    public void getSingleCoordinate (Vector v, int index){
    
    
    
    }
    public Vector getCoordVector(){
   return coords; 
   }
    
    public HS_TSP(String fileName) throws TSPException { //CONSTRUCTOR, REWRITE HERE
        
        parser = new TSPFileParser(52, 10, 10, "berlin52.tsp");
        coords = parser.parseFile("berlin52.tsp");
        this.HMS = 10;
        this.numberOfIterations = 5;
        this.numberOfCities = 52;
        
        
   /*this.graph = new int[GRAPH_SIZE][GRAPH_SIZE];
       this.initGraph();
        
        individualsTested = 0;
        averageFitness = 0.0;
        maxFitness = 0.0;
        totalFitness = 0.0;
    bestIndividual = new TSPIndividual();
           */
        
    }
    
  
    
}
 
"   "