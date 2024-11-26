package com.example.mutuelle.models;

import com.example.mutuelle.models.Dossier;
import jakarta.persistence.*;

@Entity
@Table(name = "traitements")
public class Traitement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomMedicament;
    private String typeMedicament;
    private boolean existe;
    private String codeBarre;
    private double prixMedicament;
    private double montantRemboursement;
    @ManyToOne
    @JoinColumn(name = "dossier_id")
    private Dossier dossier;

    public double getMontantRemboursement() {
        return montantRemboursement;
    }

    public void setMontantRemboursement(double montantRemboursement) {
        this.montantRemboursement = montantRemboursement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public double getPrixMedicament() {
        return prixMedicament;
    }

    public void setPrixMedicament(double prixMedicament) {
        this.prixMedicament = prixMedicament;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }
}