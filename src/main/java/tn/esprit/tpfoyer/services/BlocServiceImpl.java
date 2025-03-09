package tn.esprit.tpfoyer.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repositories.IBlocRepository;
import tn.esprit.tpfoyer.repositories.IChambreReposirtory;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocServices {

    IBlocRepository iBlocRepository;
    private IBlocRepository blocRepository;
    private IChambreReposirtory chambreRepository;


    @Override
    public List<Bloc> retrieveBlocs() {
        return iBlocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        if (iBlocRepository.existsById(bloc.getIdBloc())) {
            return iBlocRepository.save(bloc);
        }
        return null;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return iBlocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return iBlocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        iBlocRepository.deleteById(idBloc);

    }
    @Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        chambreRepository.affecterChambres(numChambre, idBloc);
        return blocRepository.findById(idBloc).orElse(null);
    }
}
