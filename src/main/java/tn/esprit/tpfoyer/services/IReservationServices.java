package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IReservationServices {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (Long idReservation);
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(int anneeUniversitaire, String nomUniversite);
    Reservation ajouterReservation(long idBloc, long cinEtudiant);

}
