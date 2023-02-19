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
public class BusController extends VehicleController {

    
    public BusController(Vehicle vehicle) {
        super(vehicle);
    }
    
    public double calc(int days) {
        return ((this.baseCalc + 1.5) * days) + 2;
    }
}
