package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.*;
import tn.esprit.tpfoyer.repositories.IBlocRepository;
import tn.esprit.tpfoyer.repositories.IChambreReposirtory;
import tn.esprit.tpfoyer.repositories.IEtudiantRepository;
import tn.esprit.tpfoyer.repositories.IReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationServices {

    IReservationRepository reservationRepository;
    IBlocRepository blocRepository;
    IEtudiantRepository etudiantRepository;
    IChambreReposirtory chambreRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        if (reservationRepository.existsById(res.getIdReservation())) {
            return reservationRepository.save(res);
        }
        return null;
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(int anneeUniversitaire, String nomUniversite) {
        return reservationRepository.findReservationsByAnneeAndUniversite(anneeUniversitaire, nomUniversite);
    }

    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé"));

        Etudiant etudiant = (Etudiant) etudiantRepository.findByCin(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        Chambre chambreDisponible = chambreRepository.findFirstByBlocAndDisponible(bloc, true);

        if (chambreDisponible == null) {
            throw new RuntimeException("Aucune chambre disponible !");
        }

        Reservation reservation = new Reservation();
        reservation.setNumReservation(chambreDisponible.getIdChambre() + "-" + bloc.getNomBloc() + "-2024");
        reservation.setEstValide(true);
        reservation.setChambre(chambreDisponible);
        reservation.setEtudiant(etudiant);

        return reservationRepository.save(reservation);

    }
}
