/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Vehicle;

/**
 *
 * @author Jarias
 */
public class TruckController extends VehicleController {

    
    public TruckController(Vehicle vehicle) {
        super(vehicle);
    }
    
    public double calc(int tons) {
        return (this.baseCalc + 40) * tons;
    }
}
