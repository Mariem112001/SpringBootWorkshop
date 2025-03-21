package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocServices {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc bloc);
    Bloc addBloc (Bloc bloc);
    Bloc retrieveBloc (long idBloc);
    void removeBloc (long idBloc);

    Bloc affecterChambresABloc(List<Long> numChambres, long idBloc);
}
