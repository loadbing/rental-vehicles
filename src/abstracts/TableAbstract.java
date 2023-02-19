/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracts;

import model.Vehicle;

/**
 *
 * @author Jarias
 */
public abstract class TableAbstract {

    public abstract boolean existsInTable();

    public abstract Vehicle searchInTable();

    public abstract double eject(String type, String action, int days, int tons);
}
