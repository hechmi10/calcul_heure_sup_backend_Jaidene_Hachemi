package tn.esprit.calcul_heures_sup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.calcul_heures_sup.entities.Tarif;
import tn.esprit.calcul_heures_sup.repositories.TarifRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class TarifServiceImpl implements ITarifService {

    @Autowired
    private TarifRepository tarifRepository;

    @Override
    public Tarif addTarif(Tarif tarif) {
        return tarifRepository.save(tarif);
    }

    @Override
    public void deleteTarif(int id) {
        tarifRepository.deleteById(id);
    }

    @Override
    public Tarif getTarif(int id) {
        return tarifRepository.findById(id).isPresent() ? tarifRepository.findById(id).get() : null;
    }

    @Override
    public Set<Tarif> getTarifs() {
        return new HashSet<Tarif>(tarifRepository.findAll());
    }

    @Override
    public Tarif updateTarif(int id, Tarif tarif) {
        return tarifRepository.findById(id).isPresent() ? tarifRepository.save(tarif) : null;
    }
}
