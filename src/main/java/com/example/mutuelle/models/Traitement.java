package com.example.mutuelle.models;

import com.example.mutuelle.models.Dossier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
    private int pourcentageRemboursement;
    @ManyToOne
    @JoinColumn(name = "dossier_id")
    private Dossier dossier;

}