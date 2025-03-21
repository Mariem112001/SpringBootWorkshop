package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.services.IUniversiteServices;

import java.util.List;

@RestController
@RequestMapping("/universite")

public class UniversiteController {
    @Autowired

    IUniversiteServices universiteService;


    @GetMapping("/getAllUniversities")
    public List<Universite> retrieveAllUniversities() {
        return universiteService.retrieveAllUniversities();
    }


    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }


    @PutMapping("/updateUniversite/{id}")
    public Universite updateUniversite(@PathVariable("id") long idUniversite, @RequestBody Universite universite) {

        return universiteService.updateUniversite(universite);
    }


    @GetMapping("/getById/{id}")
    public Universite retrieveUniversite(@PathVariable("id") long idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }

    @PutMapping("/affecter/{idFoyer}/{nomUniversite}")
    public Foyer affecterFoyerAUniversite(
            @PathVariable("idFoyer") long idFoyer,
            @PathVariable("nomUniversite") String nomUniversite) {

       return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);

    }

    @PutMapping("/desaffecterFoyer/{idUniversite}")
    public ResponseEntity<Foyer> desaffecterFoyer(@PathVariable("idUniversite") long idUniversite) {
        Foyer foyer = universiteService.desaffecterFoyerAUniversite(idUniversite);
        return ResponseEntity.ok(foyer);
    }
}
