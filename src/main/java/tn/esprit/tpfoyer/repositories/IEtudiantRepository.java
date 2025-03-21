package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.Optional;

@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Object> findByCin(long cinEtudiant);
}
