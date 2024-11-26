package com.example.mutuelle.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dossiers")
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomAssure;
    private String numeroAffiliation;
    private String immatriculation;
    private String lienParente;
    private double montantTotalFrais;
    private double prixConsultation;
    private int nombrePiecesJointes;
    private String nomBeneficiaire;
    private Date dateDepotDossier;
    private double remboursementConsultation;
    private double totalRemboursement;
    @OneToMany(mappedBy = "dossier", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRemboursementConsultation() {
        return remboursementConsultation;
    }

    public void setRemboursementConsultation(double remboursementConsultation) {
        this.remboursementConsultation = remboursementConsultation;
    }

    public double getTotalRemboursement() {
        return totalRemboursement;
    }

    public void setTotalRemboursement(double totalRemboursement) {
        this.totalRemboursement = totalRemboursement;
    }
}
