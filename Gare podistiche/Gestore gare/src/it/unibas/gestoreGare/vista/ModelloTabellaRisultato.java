package it.unibas.gestoreGare.vista;

import it.unibas.gestoreGare.modello.Arrivo;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaRisultato extends AbstractTableModel {

    private List<Arrivo> risultati;

    public void setRisultati(List<Arrivo> risultati) {
        this.risultati = risultati;
    }

    @Override
    public int getRowCount() {
        if (risultati == null) {
            return 0;
        }
        return risultati.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (risultati == null) {
            return "";
        }
        Arrivo risultato = risultati.get(rowIndex);
        if (columnIndex == 0) {
            return risultato.getAtleta().toString();
        }
        if (columnIndex == 1) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            return formatter.format(risultato.getOrarioArrivo().getTime());
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Atleta";
        }
        if (column == 1) {
            return "Orario arrivo";
        }
        return "";
    }

    public void aggiorna() {
        this.fireTableDataChanged();
    }

}
