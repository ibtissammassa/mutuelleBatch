package com.example.mutuelle.models;

public class Traitement {
    private String codeBarre;
    private boolean existe;
    private String nomMedicament;
    private String typeMedicament;
    private double prixMedicament;

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public String getTypeMedicament() {
        return typeMedicament;
    }

    public void setTypeMedicament(String typeMedicament) {
        this.typeMedicament = typeMedicament;
    }

    public double getPrixMedicament() {
        return prixMedicament;
    }

    public void setPrixMedicament(double prixMedicament) {
        this.prixMedicament = prixMedicament;
    }
}
