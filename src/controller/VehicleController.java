/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.VehicleInterface;
import javax.swing.table.DefaultTableModel;
import model.Vehicle;

/**
 *
 * @author Jarias
 */
public class VehicleController implements VehicleInterface {

    private final Vehicle vehicle;
    public final int baseCalc;

    public VehicleController(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.baseCalc = 50;
    }

    @Override
    public void save(DefaultTableModel dtm) {
        if (!vehicle.getID().equals("") && !vehicle.getBrand().equals("") && !vehicle.getType().equals("")) {
            TableController tableController = new TableController(vehicle, dtm, vehicle.getID());
            String datos[] = new String[4];

            datos[0] = vehicle.getID();
            datos[1] = vehicle.getBrand();
            datos[2] = vehicle.getType();
            datos[3] = vehicle.getTons();

            if (!tableController.existsInTable()) {
                dtm.addRow(datos);
            }
        }
    }
}
