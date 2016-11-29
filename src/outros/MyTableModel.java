/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outros;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public class MyTableModel extends DefaultTableModel {

    public MyTableModel() {
    }

    public MyTableModel(Object[] cols, int rows) {
        super(cols, rows);
    }

    public MyTableModel(int rows, String... cols) {
        super(cols, rows);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        //return col != 0;
        return false;
    }

}
