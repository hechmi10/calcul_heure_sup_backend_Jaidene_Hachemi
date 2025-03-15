package tn.esprit.calcul_heures_sup.services;

import tn.esprit.calcul_heures_sup.entities.Employe;
import tn.esprit.calcul_heures_sup.entities.HeureSup;

import java.util.Set;

public interface IHeureSupService {
    HeureSup addHeureSup(HeureSup hs);
    HeureSup updateHeureSup(int id,HeureSup hs);
    void deleteHeureSup(int id);
    HeureSup getHeureSup(int id);
    Set<HeureSup> getHeureSups();
    HeureSup affectEmployeById(int id, HeureSup hs);
}
