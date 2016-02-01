/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs_tsp;

public class TSPCoordinate {
  
  private double x;
  private double y;

  public TSPCoordinate(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() { return this.x; }
  public double getY() { return this.y; }
}