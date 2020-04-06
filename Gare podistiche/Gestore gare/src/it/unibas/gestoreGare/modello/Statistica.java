package it.unibas.gestoreGare.modello;

public class Statistica {

    private String citta;
    private int occorrenze;
    private int occorrenzeTotali;

    public Statistica(String citta, int occorrenze, int occorrenzeTotali) {
        this.citta = citta;
        this.occorrenze = occorrenze;
        this.occorrenzeTotali = occorrenzeTotali;
    }

    public String getCitta() {
        return citta;
    }

    public int getOccorrenze() {
        return occorrenze;
    }

    public int getOccorrenzeTotali() {
        return occorrenzeTotali;
    }
    
    public void aggiungiOccorrenza() {
        this.occorrenze++;
    }
    
    public double getPercentuale() {
        return (double) this.occorrenze/this.occorrenzeTotali * 100;
    }

}
