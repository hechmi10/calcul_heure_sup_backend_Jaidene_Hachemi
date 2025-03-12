package tn.esprit.calcul_heures_sup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.calcul_heures_sup.entities.HeureSup;
import tn.esprit.calcul_heures_sup.repositories.HeureSupRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class HeureSupServiceImpl implements IHeureSupService {

    @Autowired
    private HeureSupRepository heureSupRepository;

    @Override
    public HeureSup addHeureSup(HeureSup hs) {
        return heureSupRepository.save(hs);
    }

    @Override
    public HeureSup updateHeureSup(int id, HeureSup hs) {
        return heureSupRepository.findById(id).isPresent() ? heureSupRepository.save(hs) : null;
    }

    @Override
    public void deleteHeureSup(int id) {
        heureSupRepository.deleteById(id);
    }

    @Override
    public HeureSup getHeureSup(int id) {
        return heureSupRepository.findById(id).isPresent() ? heureSupRepository.findById(id).get() : null;
    }

    @Override
    public Set<HeureSup> getHeureSups() {
        return new HashSet<>(heureSupRepository.findAll());
    }
}
