package tn.esprit.calcul_heures_sup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.calcul_heures_sup.entities.HeureSup;
import tn.esprit.calcul_heures_sup.services.HeureSupServiceImpl;
import tn.esprit.calcul_heures_sup.services.IHeureSupService;

import java.util.List;
import java.util.Set;

@SpringBootTest
class GererHeuresSupsTests {
    @Test
    public void getAllHeuresSup_badRequest_returnFalse(){
        IHeureSupService heureSupService = new HeureSupServiceImpl();
        Set<HeureSup> hs=heureSupService.getHeureSups();
        Assertions.assertFalse(hs.isEmpty());
    }

    @Test
    public void addHeuresSup_badRequest_returnFalse(){
        IHeureSupService heureSupService = new HeureSupServiceImpl();
        HeureSup hs=heureSupService.addHeureSup(new HeureSup());
        Assertions.assertFalse(heureSupService.getHeureSups().contains(hs));
    }

    @Test
    public void updateHeuresSup_badRequest_returnFalse(){
        IHeureSupService heureSupService = new HeureSupServiceImpl();
        HeureSup hs=heureSupService.updateHeureSup(1,new HeureSup());
        Assertions.assertFalse(heureSupService.getHeureSups().contains(hs));
    }

    @Test
    public void deleteHeuresSup_badRequest_returnFalse(){
        IHeureSupService heureSupService = new HeureSupServiceImpl();
        heureSupService.deleteHeureSup(1);
        Assertions.assertFalse(heureSupService.getHeureSups().contains(new HeureSup()));
    }

    @Test
    public void getHeuresSup_badRequest_returnFalse(){
        IHeureSupService heureSupService = new HeureSupServiceImpl();
        HeureSup hs=heureSupService.getHeureSup(1);
        Assertions.assertFalse(heureSupService.getHeureSups().contains(hs));
    }
}
