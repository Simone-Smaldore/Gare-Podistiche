package it.unibas.gestoreGare.vista;

import it.unibas.gestoreGare.modello.Gara;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaGare extends AbstractTableModel {

    private List<Gara> gare;

    public void setGare(List<Gara> gare) {
        this.gare = gare;
    }

    @Override
    public int getRowCount() {
        if(gare == null) {
            return 0;
        } 
        return gare.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(gare == null) {
            return "";
        }
        Gara gara = gare.get(rowIndex);
        if(columnIndex == 0) {
            return gara.getCodice();
        }
        if(columnIndex == 1) {
            return gara.getDescrizione();
        }
        if(columnIndex == 2) {
            return gara.getKm();
        }
        if(columnIndex == 3) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.format(gara.getDataGara().getTime());
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0) {
            return "Codice";
        }
        if(column == 1) {
            return "Descrizione";
        }
        if(column == 2) {
            return "Chilometri";
        }
        if(column == 3) {
            return "Data";
        }
        return "";
    }
    
    public void aggiorna() {
        this.fireTableDataChanged();
    }

}
