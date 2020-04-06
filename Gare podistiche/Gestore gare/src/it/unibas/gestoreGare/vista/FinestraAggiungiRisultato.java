package it.unibas.gestoreGare.vista;

import it.unibas.gestoreGare.Applicazione;
import it.unibas.gestoreGare.Costanti;
import it.unibas.gestoreGare.modello.Arrivo;
import it.unibas.gestoreGare.modello.Atleta;
import it.unibas.gestoreGare.modello.Gara;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinestraAggiungiRisultato extends javax.swing.JDialog {
    
    private static Logger logger = LoggerFactory.getLogger(FinestraAggiungiRisultato.class);

    public FinestraAggiungiRisultato(Frame parent) {
        super(parent, false);
    }

    public void inizializza() {
        initComponents();
        initComboBoxOrario();
        initActions();
    }

    public void visualizza() {
        initComboBoxAtleti();
        this.jComboBoxMinuti.setSelectedItem("00");
        this.jComboBoxOre.setSelectedItem("00");
        initLabel();
        initTabella();
        this.pack();
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }

    public void initTabella() {
        ModelloTabellaRisultato modello = new ModelloTabellaRisultato();
        this.jTableRisposte.setModel(modello);
        aggiornaTabella();
    }

    public void aggiornaTabella() {
        ModelloTabellaRisultato modello = (ModelloTabellaRisultato) this.jTableRisposte.getModel();
        Gara gara = (Gara) Applicazione.getInstance().getModello().getBean(Costanti.GARA_SELEZIONATA);
        List<Arrivo> arrivi = gara.getArrivi();
        Collections.sort(arrivi);
        modello.setRisultati(arrivi);        
        modello.aggiorna();
    }

    public Atleta getAtletaSelezionato() {
        return (Atleta) this.jComboBoxAtleti.getSelectedItem();
    }

    public Calendar getOraSelezionata() {
        int ore = Integer.parseInt((String) this.jComboBoxOre.getSelectedItem());
        int minuti = Integer.parseInt((String) this.jComboBoxMinuti.getSelectedItem());
        
        Gara garaSelezionata = (Gara) Applicazione.getInstance().getModello().getBean(Costanti.GARA_SELEZIONATA);
        Calendar orarioGara = garaSelezionata.getDataGara();
        
        Calendar orario = new GregorianCalendar(orarioGara.get(Calendar.YEAR),orarioGara.get(Calendar.MONTH),orarioGara.get(Calendar.DAY_OF_MONTH), ore, minuti);
//        orario.set(Calendar.HOUR_OF_DAY, ore);
//        orario.set(Calendar.MINUTE, minuti);
        //TO DO aggiusta l orario con i giusti giorno mese e anno preso da gara.getdata()
        return orario;
    }

    public void initActions() {
        this.jButtonAggiungiRisultato.setAction(Applicazione.getInstance().getControlloFinsetraAggiungiRisultato().getAzioneAggiungi());
    }

    public void initComboBoxOrario() {
        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                this.jComboBoxOre.addItem("0" + i);
            } else {
                this.jComboBoxOre.addItem("" + i);
            }
        }
        for (int j = 0; j < 60; j++) {
            if (j < 10) {
                this.jComboBoxMinuti.addItem("0" + j);
            } else {
                this.jComboBoxMinuti.addItem("" + j);
            }
        }
    }

    public void initComboBoxAtleti() {
        List<Atleta> atleti = (List<Atleta>) Applicazione.getInstance().getModello().getBean(Costanti.ATLETI);
        this.jComboBoxAtleti.removeAllItems();
        for (Atleta atleta : atleti) {
            this.jComboBoxAtleti.addItem(atleta);
        }
    }

    public void initLabel() {
        Gara gara = (Gara) Applicazione.getInstance().getModello().getBean(Costanti.GARA_SELEZIONATA);
        this.jLabelDescrizione.setText(gara.getDescrizione());
        this.jLabelChilometri.setText(gara.getKm() + "");
        this.jLabelData.setText(new SimpleDateFormat("dd/MM/yyyy").format(gara.getDataGara().getTime()));
        this.jLabelOra.setText(new SimpleDateFormat("HH:mm").format(gara.getDataGara().getTime()));
    }

    public void mostraErrori(String errori) {
        JOptionPane.showMessageDialog(this, errori, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        jLabelDescrizione = new javax.swing.JLabel();
        jLabelChilometri = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelOra = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTableRisposte = new javax.swing.JTable();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        jComboBoxAtleti = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jComboBoxOre = new javax.swing.JComboBox<>();
        jComboBoxMinuti = new javax.swing.JComboBox<>();
        jButtonAggiungiRisultato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informazioni Gara selezionata", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Descrizione");

        jLabel2.setText("Chilometri");

        jLabel3.setText("Data");

        jLabel4.setText("Ora");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelDescrizione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelChilometri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelOra, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelDescrizione))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelChilometri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelOra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableRisposte.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableRisposte);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inserimento nuovo risultato", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel5.setText("Atleta");

        jLabel6.setText("Ora di arrivo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxAtleti, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBoxOre, 0, 67, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMinuti, 0, 59, Short.MAX_VALUE))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAtleti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonAggiungiRisultato.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jButtonAggiungiRisultato, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButtonAggiungiRisultato)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAggiungiRisultato;
    private javax.swing.JComboBox<Atleta> jComboBoxAtleti;
    private javax.swing.JComboBox<String> jComboBoxMinuti;
    private javax.swing.JComboBox<String> jComboBoxOre;
    private javax.swing.JLabel jLabelChilometri;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDescrizione;
    private javax.swing.JLabel jLabelOra;
    private javax.swing.JTable jTableRisposte;
    // End of variables declaration//GEN-END:variables
}
