package tn.esprit.tpfoyer.services;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repositories.IFoyerRepository;
import tn.esprit.tpfoyer.repositories.IUniversiteRepository;


import java.util.List;
import java.util.Optional;

@Service

public class UniversiteServiceImpl implements IUniversiteServices {
    @Autowired
    IUniversiteRepository universiteRepository;
    @Autowired
    IFoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        if (universiteRepository.existsById(u.getIdUniversite())) {
            return universiteRepository.save(u);
        }
        return null;
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {

        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Foyer affecterFoyerAUniversite(long idFoyer, String nomUniversite) {


        Foyer foyer= foyerRepository.findById(idFoyer).get();
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        foyer.setUniversite(universite);
        return foyerRepository.save(foyer);



    }



    @Override
    public Foyer desaffecterFoyerAUniversite(long idUniversite) {
Universite u= universiteRepository.findById(idUniversite).get();

Foyer f  =u.getFoyer();

f.setUniversite(null);
foyerRepository.save(f);
        return null;
    }
}