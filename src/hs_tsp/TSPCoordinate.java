/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs_tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TSPCoordinate {

    private double x;
    private double y;
    private double fitnessValue;
    private ArrayList<TSPCoordinate> neighbors;
    private double longest;
    private int longestCursor = 0;
    private int maxNeighbor = 4;

    public TSPCoordinate(double x, double y, double fitness) {
        this.x = x;
        this.y = y;
        this.fitnessValue = fitness;
        this.neighbors = new ArrayList<TSPCoordinate>();
        this.longest = 0.0;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getFitness() {
        return this.fitnessValue;
    }

    public void updateFitness(double fitness) {
        this.fitnessValue = fitness;
    }
     public double calculateDistance(TSPCoordinate t1) {

        double x1MINUSx2 = Math.pow((t1.getX() - this.getX()), 2);
        double y1MINUSy2 = Math.pow((t1.getY() - this.getY()), 2);

        return Math.abs(Math.sqrt(x1MINUSx2 + y1MINUSy2));

    }

    public void setNeighbors(TSPCoordinate neighbor) {
        double distance = calculateDistance(neighbor);
      //  System.out.println("Neighboring structure: "+ calculateDistance(neighbor));
        if (neighbors.size() <= maxNeighbor) {
            neighbors.add(neighbor);
            if (distance > longest) {
                longest = distance;
            }

        } else {
              //  System.out.println("Longest: "+longest+" and Distance: "+ distance);
            if (distance < longest) {
               
                Collections.sort(neighbors, new Comparator<TSPCoordinate>() {

                    @Override
                    public int compare(TSPCoordinate o1, TSPCoordinate o2) {

                        if (calculateDistance(o1) < calculateDistance(o2)) {
                            return -1;
                        }
                        if (calculateDistance(o1) > calculateDistance(o2)) {
                            return 1;
                        }
                        return 0;

                    }

                    });
 //               System.out.println(calculateDistance(neighbors.get(0))+ ", "+calculateDistance(neighbors.get(1))+", "+calculateDistance(neighbors.get(2))+", "+calculateDistance(neighbors.get(3))+", "+calculateDistance(neighbors.get(4)));
                //  System.out.println("Swapping the worst neighbor: "+calculateDistance(neighbors.get(maxNeighbor))+" with: "+calculateDistance(neighbor));
                    neighbors.set(maxNeighbor, neighbor);
                    longest = calculateDistance(neighbors.get(maxNeighbor));
            
            
            }

        }
       // System.out.println("Longest of the neighbors: "+ longest);
    }

    
    public TSPCoordinate getFromNeighbors(int index){
    if(index>neighbors.size()){
    System.out.println("Given index is out of range of neighbors list.");
    return new TSPCoordinate(0, 0, 0);
    }
    else{
    return neighbors.get(index);
    
    }
    
    
    }
}
