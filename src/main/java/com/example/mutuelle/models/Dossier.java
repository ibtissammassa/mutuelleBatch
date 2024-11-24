package com.example.mutuelle.models;

import java.util.Date;
import java.util.List;

public class Dossier {
    private String nomAssure;
    private String numeroAffiliation;
    private String immatriculation;
    private String lienParente;
    private double montantTotalFrais;
    private double prixConsultation;
    private int nombrePiecesJointes;
    private String nomBeneficiaire;
    private Date dateDepotDossier;
    private List<Traitement> traitements;

    public String getNomAssure() {
        return nomAssure;
    }

    public void setNomAssure(String nomAssure) {
        this.nomAssure = nomAssure;
    }

    public String getNumeroAffiliation() {
        return numeroAffiliation;
    }

    public void setNumeroAffiliation(String numeroAffiliation) {
        this.numeroAffiliation = numeroAffiliation;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public List<Traitement> getTraitements() {
        return traitements;
    }

    public void setTraitements(List<Traitement> traitements) {
        this.traitements = traitements;
    }

    public String getLienParente() {
        return lienParente;
    }

    public void setLienParente(String lienParente) {
        this.lienParente = lienParente;
    }

    public double getMontantTotalFrais() {
        return montantTotalFrais;
    }

    public void setMontantTotalFrais(double montantTotalFrais) {
        this.montantTotalFrais = montantTotalFrais;
    }

    public double getPrixConsultation() {
        return prixConsultation;
    }

    public void setPrixConsultation(double prixConsultation) {
        this.prixConsultation = prixConsultation;
    }

    public int getNombrePiecesJointes() {
        return nombrePiecesJointes;
    }

    public void setNombrePiecesJointes(int nombrePiecesJointes) {
        this.nombrePiecesJointes = nombrePiecesJointes;
    }

    public String getNomBeneficiaire() {
        return nomBeneficiaire;
    }

    public void setNomBeneficiaire(String nomBeneficiaire) {
        this.nomBeneficiaire = nomBeneficiaire;
    }

    public Date getDateDepotDossier() {
        return dateDepotDossier;
    }

    public void setDateDepotDossier(Date dateDepotDossier) {
        this.dateDepotDossier = dateDepotDossier;
    }
}
