/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abstracts.TableAbstract;
import javax.swing.table.DefaultTableModel;
import model.Vehicle;

/**
 *
 * @author Jarias
 */
public class TableController extends TableAbstract {

    private final Vehicle vehicle;
    private final DefaultTableModel table;
    private final String ID;

    public TableController(Vehicle vehicle, DefaultTableModel table, String ID) {
        this.vehicle = vehicle;
        this.table = table;
        this.ID = ID;
    }

    @Override
    public boolean existsInTable() {

        int rowCount = this.table.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String value = this.table.getValueAt(i, 0).toString();
            if (value.equals(this.ID)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Vehicle searchInTable() {
        int rowCount = this.table.getRowCount();
        Vehicle obj = new Vehicle();
        for (int i = 0; i < rowCount; i++) {
            String value = this.table.getValueAt(i, 0).toString();
            if (value.equals(this.ID)) {
                obj.setID(this.table.getValueAt(i, 0).toString());
                obj.setBrand(this.table.getValueAt(i, 1).toString());
                obj.setType(this.table.getValueAt(i, 2).toString());
                obj.setTons(this.table.getValueAt(i, 3).toString());
            }
        }
        return obj;
    }

    @Override
    public double eject(String type, String action, int days, int tons) {
        double result = 0;
        switch (type) {
            case "Coche":
                CarController carController = new CarController(this.vehicle);
                if (action.equals("save")) {
                    carController.save(this.table);
                } else if (action.equals("calc")) {
                    result = carController.calc(days);
                }
                break;
            case "Microbus":
                BusController busController = new BusController(this.vehicle);
                if (action.equals("save")) {
                    busController.save(this.table);
                } else if (action.equals("calc")) {
                    result = busController.calc(days);
                }
                break;
            case "Furgoneta":
                VanController vanController = new VanController(this.vehicle);
                if (action.equals("save")) {
                    vanController.save(this.table);
                } else if (action.equals("calc")) {
                    result = vanController.calc(tons);
                }
                break;
            case "Camion":
                TruckController truckController = new TruckController(this.vehicle);
                if (action.equals("save")) {
                    truckController.save(this.table);
                } else if (action.equals("calc")) {
                    result = truckController.calc(tons);
                }
                break;
        }
        return result;
    }
}
