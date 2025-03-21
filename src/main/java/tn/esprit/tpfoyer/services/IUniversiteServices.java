package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);
    public Foyer affecterFoyerAUniversite (long idFoyer, String
            nomUniversite);

Foyer desaffecterFoyerAUniversite(long idUniversite);

}
