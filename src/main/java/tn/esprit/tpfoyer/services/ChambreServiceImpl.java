package tn.esprit.tpfoyer.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repositories.IChambreReposirtory;
import tn.esprit.tpfoyer.repositories.IUniversiteRepository;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreServices {

    IChambreReposirtory chambreReposirtory;
    private IChambreReposirtory chambreRepository;
    private IUniversiteRepository universiteRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreReposirtory.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreReposirtory.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        if (chambreReposirtory.existsById(c.getIdChambre())) {
            return chambreReposirtory.save(c);
        }
        return null;
    }
    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        if (universite == null || universite.getFoyer() == null) {
            return Collections.emptyList();
        }
        return chambreRepository.findChambresNonReservees(universite.getFoyer().getNomFoyer(), type);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreReposirtory.findById(idChambre).orElse(null);
    }
    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndTypeChambre(idBloc, typeC);
    }
}
