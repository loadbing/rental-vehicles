/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.table.DefaultTableModel;
import model.Vehicle;

/**
 *
 * @author Jarias
 */
public class VehicleController {

    private final Vehicle vehicle;

    public VehicleController(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void save(DefaultTableModel dtm) {
        if (!vehicle.getID().equals("") && !vehicle.getBrand().equals("") && !vehicle.getType().equals("")) {
            String datos[] = new String[4];

            datos[0] = vehicle.getID();
            datos[1] = vehicle.getBrand();
            datos[2] = vehicle.getType();
            datos[3] = vehicle.getTons();

            if (!existsInTable(dtm, vehicle.getID())) {
                dtm.addRow(datos);
            }
        }
    }

    private boolean existsInTable(DefaultTableModel table, String ID) {

        int rowCount = table.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String value = table.getValueAt(i, 0).toString();
            if (value.equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public Vehicle searchInTable(DefaultTableModel table, String ID) {
        int rowCount = table.getRowCount();
        Vehicle obj = new Vehicle();
        for (int i = 0; i < rowCount; i++) {
            String value = table.getValueAt(i, 0).toString();
            if (value.equals(ID)) {
                obj.setID(table.getValueAt(i, 0).toString());
                obj.setBrand(table.getValueAt(i, 1).toString());
                obj.setType(table.getValueAt(i, 2).toString());
                obj.setTons(table.getValueAt(i, 3).toString());
            }
        }
        return obj;
    }

    public Double calc(String type, int days, int tons) {
        double total = 0;
        int base = 50;
        switch (type) {
            case "Coche":
                total = (base + 1.5) * days;
                break;
            case "Microbus":
                total = ((base + 1.5) * days) + 2;
                break;
            case "Furgoneta":
                total = (base + 20) * tons;
                break;
            case "Camiones":
                total = 40;
                break;
        }
        return total;
    }
}
