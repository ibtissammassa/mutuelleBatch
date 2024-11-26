package com.example.mutuelle.Repositories;

import com.example.mutuelle.models.MedicamentReferentiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicamentReferentielRepository extends JpaRepository<MedicamentReferentiel, Long> {
    Optional<MedicamentReferentiel> findByCodeBarre(String codeBarre);
}

