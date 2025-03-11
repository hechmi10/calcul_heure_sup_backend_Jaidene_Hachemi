package tn.esprit.calcul_heures_sup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.calcul_heures_sup.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Integer> {
}
