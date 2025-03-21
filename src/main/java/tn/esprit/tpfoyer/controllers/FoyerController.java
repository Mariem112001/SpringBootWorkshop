package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.services.FoyerServiceImpl;
import tn.esprit.tpfoyer.services.IFoyerServices;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {
    IFoyerServices foyerService;

    @PostMapping("/saveFoyer")
    public Foyer saveFoyer(@RequestBody Foyer foyer) {
        return foyerService.save(foyer);
    }

    @GetMapping("/getById/{id}")
    public Foyer getFoyer(@PathVariable("id") Long id) {
        return foyerService.findById(id);
    }
    @GetMapping("/getByNomCapacite/{nom}/{capacite}")
    public Foyer getFoyer(@PathVariable("nom") String nom, @PathVariable("capacite") Long capacite) {
   return foyerService.getNomCapacite(nom, capacite);
    }

    @PostMapping("/ajouterFoyer")
    public ResponseEntity<Foyer> ajouterFoyerEtAffecterAUniversite(
            @RequestBody Foyer foyer,
            @RequestParam long idUniversite) {

        Foyer newFoyer = foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
        return ResponseEntity.ok(newFoyer);
    }

}
