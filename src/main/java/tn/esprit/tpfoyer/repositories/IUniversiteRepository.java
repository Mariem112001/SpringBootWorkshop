package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Universite;

@Repository
public interface IUniversiteRepository extends JpaRepository<Universite, Long> {
    @Query("SELECT u FROM Universite u WHERE u.nomUniversite = :nomUniversite")
    Universite findByNomUniversite(@Param("nomUniversite") String nomUniversite);

    @Modifying
    @Query("UPDATE Universite u SET u.foyer = NULL WHERE u.idUniversite = :idUniversite")
    void desaffecterFoyer(@Param("idUniversite") long idUniversite);
}
