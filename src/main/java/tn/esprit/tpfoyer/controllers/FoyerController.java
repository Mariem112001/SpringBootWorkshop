package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.services.FoyerServiceImpl;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {
    FoyerServiceImpl foyerService;

    @PostMapping("/saveFoyer")
    public Foyer saveFoyer(Foyer foyer) {
        return foyerService.save(foyer);
    }


}
