package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.Universite;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {


}
