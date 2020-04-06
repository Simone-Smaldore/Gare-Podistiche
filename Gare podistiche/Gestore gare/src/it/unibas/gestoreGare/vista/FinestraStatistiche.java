package it.unibas.gestoreGare.vista;

import it.unibas.gestoreGare.Applicazione;
import it.unibas.gestoreGare.Costanti;
import it.unibas.gestoreGare.modello.Statistica;
import java.util.List;

public class FinestraStatistiche extends javax.swing.JDialog {

    public FinestraStatistiche(Frame parent) {
        super(parent, true);
    }

        
    public void inizializza() {
        initComponents();
        initTable();
    }
    
    public void visualizza() {
        aggiornatabella();
        this.pack();
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }
    
    public void initTable() {
        this.jTableStatistiche.setModel(new ModelloTabellaStatistiche());
    }
    
    public void aggiornatabella() {
        ModelloTabellaStatistiche modello = (ModelloTabellaStatistiche) this.jTableStatistiche.getModel();
        List<Statistica> statistiche = (List<Statistica>) Applicazione.getInstance().getModello().getBean(Costanti.STATISTICHE);
        modello.setStatistiche(statistiche);
        modello.aggiorna();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTableStatistiche = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabella Statistiche", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTableStatistiche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableStatistiche);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jTableStatistiche;
    // End of variables declaration//GEN-END:variables
}
