package tn.esprit.calcul_heures_sup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.calcul_heures_sup.entities.Employe;
import tn.esprit.calcul_heures_sup.repositories.EmployeRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeServiceImpl implements IEmployeService{

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe updateEmploye(int id, Employe employe) {
        return employeRepository.findById(id).isPresent() ? employeRepository.save(employe) : null;
    }

    @Override
    public void deleteEmploye(int id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe getEmploye(int id) {
        return employeRepository.findById(id).isPresent() ? employeRepository.findById(id).get() : null;
    }

    @Override
    public Set<Employe> getEmployes() {
        return new HashSet<>(employeRepository.findAll());
    }
}
