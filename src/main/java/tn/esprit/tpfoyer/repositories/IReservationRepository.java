package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
