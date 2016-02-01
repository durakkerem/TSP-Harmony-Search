/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs_tsp;

public class TSPCoordinate {
  
  private double x;
  private double y;
  private double fitnessValue;
  private TSPCoordinate[] neighbors;
  public TSPCoordinate(double x, double y, double fitness) {
    this.x = x;
    this.y = y;
    this.fitnessValue = fitness;
  }

  public double getX() { return this.x; }
  public double getY() { return this.y; }
    public double getFitness() { return this.fitnessValue; }
    public void updateFitness(double fitness){
    this.fitnessValue = fitness;
    }

}