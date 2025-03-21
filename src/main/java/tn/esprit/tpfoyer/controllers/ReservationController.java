package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.services.IReservationServices;
import tn.esprit.tpfoyer.services.IUniversiteServices;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
    IReservationServices reservationService;
    IUniversiteServices universiteService;



    @GetMapping("/getAllReservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservation();
    }


    @GetMapping("/getById/{id}")
    public Reservation retrieveReservation(@PathVariable("id") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }


    @PutMapping("/updateReservation/{id}")
    public Reservation updateReservation(@PathVariable("id") Long idReservation, @RequestBody Reservation reservation) {

        return reservationService.updateReservation(reservation);
    }


    @GetMapping("/parAnneeUniversitaire")
    public ResponseEntity<List<Reservation>> getReservationsByAnnee(
            @RequestParam int anneeUniversitaire,
            @RequestParam String nomUniversite) {
        List<Reservation> reservations = reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
        return ResponseEntity.ok(reservations);


    }
    @PostMapping("/ajouter")
    public ResponseEntity<Reservation> ajouterReservation(
            @RequestParam long idBloc,
            @RequestParam long cinEtudiant) {

        Reservation newReservation = reservationService.ajouterReservation(idBloc, cinEtudiant);
        return ResponseEntity.ok(newReservation);
    }
}
