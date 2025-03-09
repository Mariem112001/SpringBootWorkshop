package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

@Repository
public interface IChambreReposirtory extends CrudRepository<Chambre, Long> {

    @Modifying
    @Query("UPDATE Chambre c SET c.bloc.idBloc = :idBloc WHERE c.numeroChambre=:numChambres")
    void affecterChambres(@Param("numChambres") List<Long> numChambres, @Param("idBloc") long idBloc);
}
