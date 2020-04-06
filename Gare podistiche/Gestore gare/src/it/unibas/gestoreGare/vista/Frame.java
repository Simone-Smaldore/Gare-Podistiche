package it.unibas.gestoreGare.vista;

import it.unibas.gestoreGare.Applicazione;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Frame extends javax.swing.JFrame {

    public Frame() {
    }

    public void inizializza() {
        initComponents();
        initActions();
        this.setContentPane(new JScrollPane(Applicazione.getInstance().getPannelloPrincipale()));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void initActions() {
        this.jMenuItemEsci.setAction(Applicazione.getInstance().getControlloFrame().getAzioneEsci());
        this.jMenuItemCalcolaStatistica.setAction(Applicazione.getInstance().getControlloFrame().getAzioneCalcolaStatistiche());
    }
    
    public void mostraErrori(String errori) {
        JOptionPane.showMessageDialog(this, errori, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        jMenuItemCalcolaStatistica = new javax.swing.JMenuItem();
        jMenuItemEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        jMenuItemCalcolaStatistica.setText("jMenuItem1");
        jMenu1.add(jMenuItemCalcolaStatistica);

        jMenuItemEsci.setText("jMenuItem2");
        jMenu1.add(jMenuItemEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItemCalcolaStatistica;
    private javax.swing.JMenuItem jMenuItemEsci;
    // End of variables declaration//GEN-END:variables
}
