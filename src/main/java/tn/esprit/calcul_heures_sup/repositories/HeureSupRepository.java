package tn.esprit.calcul_heures_sup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.calcul_heures_sup.entities.HeureSup;

@Repository
public interface HeureSupRepository extends JpaRepository<HeureSup, Integer> {
}
