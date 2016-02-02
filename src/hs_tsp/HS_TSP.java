/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs_tsp;

import java.util.Arrays;
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
    private double[] fitnessValues;
    private double bestFitness = 0;
    private double worstFitness = 0;
    private int numberOfIterations;
    private int HMS;                      //Harmony memory size
    private int individualsTested;        // Number of indivuduals tested in the current population
    private double averageFitness;        // Average fitness for current population
    private double maxFitness;            // Maximum fitness for current population
    private double totalFitness;          // Sum of all fitnesses for current population
    public TSPCoordinate[][] HarmonyMemory;
//  private TSPIndividual bestIndividual; // Best OVERALL individual
    private Vector coords;
    private double[][] networkOfDistances;
    // private int graph[][];

    TSPFileParser parser;

    public static void main(String[] args) {

    }

    public boolean isCycle(TSPCoordinate tc) {

        return false;
    }

    public void generateHM(Vector v) {

        HarmonyMemory = new TSPCoordinate[HMS][numberOfCities + 1]; // +1 for the last column that is for results.
        int j = 0;

        for (int i = 0; i < HMS; i++) { //outer, one complete

            Vector tempVector = (Vector) v.clone();   // clone vector to use it temporarily. Will temper with it.
            int tempCitySize = numberOfCities;
            TSPCoordinate routeFitness = new TSPCoordinate(0, 0, 0);
            double currentFitness = 0.0;

            for (int k = 0; k < numberOfCities; k++) { // inner, route
                int chosenOne = (int) (Math.random() * ((tempCitySize)));

                TSPCoordinate tempCoo = (TSPCoordinate) tempVector.get(chosenOne);
                HarmonyMemory[i][k] = tempCoo;
                System.out.println("Generated city coo at k:" + k + " " + tempCoo.getX() + ", " + tempCoo.getY());

                //calculate the route fitness
                if (k != 0) {
                    //TEST IT. 
                    currentFitness += calculateDistance(HarmonyMemory[i][k], HarmonyMemory[i][k - 1]);

                }

                //remove used city
                tempVector.remove(chosenOne);
                tempCitySize--;

            }
            routeFitness.updateFitness(currentFitness); //fitness value of one single route. (in TSPCoordinate object)

            updateGeneralFitness(currentFitness);

            HarmonyMemory[i][numberOfCities] = routeFitness;  // save the current fitness

        }

    }

    public double calculateDistance(TSPCoordinate t1, TSPCoordinate t2) {

        double x1MINUSx2 = Math.pow((t1.getX() - t2.getX()), 2);
        double y1MINUSy2 = Math.pow((t1.getY() - t2.getY()), 2);

        return Math.abs(Math.sqrt(x1MINUSx2 + y1MINUSy2));

    }

    public Vector getCoordVector() {
        return coords;
    }

    public void createCityNetwork(Vector v) {

        for (int i = 0; i < v.size(); i++) { // from ith city
            System.out.println("start");
            TSPCoordinate tsc1 = (TSPCoordinate) v.get(i);
            for (int j = 0; j < v.size(); j++) { //to jth city
                double localworst = 0.0;
                TSPCoordinate tsc2 = (TSPCoordinate) v.get(j);

                if (i == j) {
                    // do nothing
                } 
                else {

                    //networkOfDistances[i][j] = calculateDistance(tsc1, tsc2);
                    tsc1.setNeighbors(tsc2);
                    
                    }
                  
                    
                }

            }
         

        }

    

    public HS_TSP(String fileName) throws TSPException { //CONSTRUCTOR, REWRITE HERE

        parser = new TSPFileParser(52, 10, 10, fileName);
        coords = parser.parseFile();
        this.HMS = 10;
        this.numberOfIterations = 5;
        this.numberOfCities = 52;
        this.fitnessValues = new double[numberOfCities];
        this.networkOfDistances = new double[numberOfCities][numberOfCities];

        /*this.graph = new int[GRAPH_SIZE][GRAPH_SIZE];
         this.initGraph();
        
         individualsTested = 0;
         averageFitness = 0.0;
         maxFitness = 0.0;
         totalFitness = 0.0;
         bestIndividual = new TSPIndividual();
         */
    }

    private void updateGeneralFitness(double currentFitness) {

        if (bestFitness == 0) {
            bestFitness = currentFitness;
        }
        if (worstFitness == 0) {
            worstFitness = currentFitness;
        }

        if (currentFitness < bestFitness) {
            bestFitness = currentFitness;
        }

        if (currentFitness > worstFitness) {
            worstFitness = currentFitness;
        }

        System.out.println("BEST: " + bestFitness + " WORST: " + worstFitness);

    }

}
