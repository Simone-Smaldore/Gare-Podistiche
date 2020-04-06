package it.unibas.gestoreGare.vista;

import it.unibas.gestoreGare.modello.Statistica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaStatistiche extends AbstractTableModel {

    private List<Statistica> statistiche;

    public void setStatistiche(List<Statistica> statistiche) {
        this.statistiche = statistiche;
    }

    @Override
    public int getRowCount() {
        if (statistiche == null) {
            return 0;
        }
        return this.statistiche.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (statistiche == null) {
            return "";
        }
        Statistica statistica = statistiche.get(rowIndex);
        if (columnIndex == 0) {
            return statistica.getCitta();
        }
        if (columnIndex == 1) {
            return statistica.getOccorrenze();
        }
        if (columnIndex == 2) {
            return statistica.getPercentuale();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Citta";
        }
        if (column == 1) {
            return "Numero Atleti";
        }
        if (column == 2) {
            return "Percentuale";
        }
        return "";
    }

    public void aggiorna() {
        this.fireTableDataChanged();
    }

}
