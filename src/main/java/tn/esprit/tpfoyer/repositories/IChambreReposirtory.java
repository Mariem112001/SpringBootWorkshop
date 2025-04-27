package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

@Repository
public interface IChambreReposirtory extends CrudRepository<Chambre, Long> {

//    @Modifying
//    @Query("UPDATE Chambre c SET c.bloc.idBloc = :idBloc WHERE c.numeroChambre=:numChambres")
//    void affecterChambres(@Param("numChambres") List<Long> numChambres, @Param("idBloc") long idBloc);
//

//            "WHERE c.typeChambre = :type " +
//            "AND c.bloc.foyer.nomFoyer = :nomFoyer " +
//            "AND c.numeroChambre NOT IN (SELECT r.chambre.numeroChambre FROM Reservation r)")
//    List<Chambre> findChambresNonReservees(@Param("nomFoyer") String nomFoyer, @Param("type") TypeChambre type);
//
//
//    List<Chambre> findByBlocIdBlocAndTypeChambre(long idBloc, TypeChambre typeC);
//
//    Chambre findFirstByBlocAndDisponible(Bloc bloc, boolean b);
}
