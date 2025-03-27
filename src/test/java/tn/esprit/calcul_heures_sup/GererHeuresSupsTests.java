package tn.esprit.calcul_heures_sup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.calcul_heures_sup.entities.HeureSup;
import tn.esprit.calcul_heures_sup.repositories.HeureSupRepository;
import tn.esprit.calcul_heures_sup.services.HeureSupServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GererHeuresSupsTests {

    @Mock
    private HeureSupRepository heureSupRepository;

    @InjectMocks
    private HeureSupServiceImpl heureSupService;

    private HeureSup testHeureSup;

    @BeforeEach
    void setUp() {
        testHeureSup = new HeureSup();
        testHeureSup.setId(1);
        // Add other necessary initializations
    }

    @Test
    void getAllHeuresSup_shouldReturnEmptySetWhenNoData() {
        when(heureSupRepository.findAll()).thenReturn(List.of());
        Set<HeureSup> result = heureSupService.getHeureSups();
        assertTrue(result.isEmpty());
        verify(heureSupRepository).findAll();
    }

    @Test
    void addHeuresSup_shouldReturnSavedHeureSup() {
        when(heureSupRepository.save(any(HeureSup.class))).thenReturn(testHeureSup);
        HeureSup result = heureSupService.addHeureSup(new HeureSup());
        assertNotNull(result);
        verify(heureSupRepository).save(any(HeureSup.class));
    }

    @Test
    void updateHeuresSup_shouldReturnUpdatedHeureSup() {
        when(heureSupRepository.findById(anyInt())).thenReturn(Optional.of(testHeureSup));
        when(heureSupRepository.save(any(HeureSup.class))).thenReturn(testHeureSup);

        HeureSup result = heureSupService.updateHeureSup(1, new HeureSup());
        assertNotNull(result);
        verify(heureSupRepository).findById(1);
        verify(heureSupRepository).save(any(HeureSup.class));
    }

    @Test
    void deleteHeuresSup_shouldCallRepository() {
        doNothing().when(heureSupRepository).deleteById(anyInt());
        heureSupService.deleteHeureSup(1);
        verify(heureSupRepository).deleteById(1);
    }

    @Test
    void getHeuresSup_shouldReturnHeureSupWhenExists() {
        when(heureSupRepository.findById(anyInt())).thenReturn(Optional.of(testHeureSup));
        HeureSup result = heureSupService.getHeureSup(1);
        assertNotNull(result);
        verify(heureSupRepository).findById(1);
    }

    @Test
    void getHeuresSup_shouldReturnNullWhenNotExists() {
        when(heureSupRepository.findById(anyInt())).thenReturn(Optional.empty());
        HeureSup result = heureSupService.getHeureSup(1);
        assertNull(result);
        verify(heureSupRepository).findById(1);
    }
}