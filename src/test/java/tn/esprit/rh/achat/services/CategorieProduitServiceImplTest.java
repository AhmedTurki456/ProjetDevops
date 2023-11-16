package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

@ExtendWith(MockitoExtension.class)
public class CategorieProduitServiceImplTest {

    @Mock
    private CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    private CategorieProduitServiceImpl categorieProduitService;
    CategorieProduit categorieProduit = new CategorieProduit(1L,"coategory 1","labelle",new HashSet<>());
    CategorieProduit categorieProduit1 = new CategorieProduit(2L,"coategory 2","labelle",new HashSet<>());
    @Test
    public void testRetrieveAllCategorieProduits() {
        // Arrange
        List<CategorieProduit> expectedCategorieProduits = new ArrayList<>();
        expectedCategorieProduits.add(categorieProduit);
        expectedCategorieProduits.add(categorieProduit1);
        when(categorieProduitRepository.findAll()).thenReturn(expectedCategorieProduits);

        // Act
        List<CategorieProduit> actualCategorieProduits = categorieProduitService.retrieveAllCategorieProduits();

        // Assert
        assertEquals(expectedCategorieProduits, actualCategorieProduits);
    }

    @Test
    public void testAddCategorieProduit() {
        when(categorieProduitRepository.save(categorieProduit)).thenReturn(categorieProduit);

        // Act
        CategorieProduit addedCategorieProduit = categorieProduitService.addCategorieProduit(categorieProduit);

        // Assert
        assertEquals(categorieProduit, addedCategorieProduit);
    }

    @Test
    public void testDeleteCategorieProduit() {
        // Arrange
        Long categoryIdToDelete = 1L;

        // Act
        categorieProduitService.deleteCategorieProduit(categoryIdToDelete);

        // Assert
        verify(categorieProduitRepository, times(1)).deleteById(categoryIdToDelete);
    }

    @Test
    public void testUpdateCategorieProduit() {
        // Arrange
        when(categorieProduitRepository.save(categorieProduit1)).thenReturn(categorieProduit1);

        // Act
        CategorieProduit updatedCategorieProduit = categorieProduitService.updateCategorieProduit(categorieProduit1);

        // Assert
        assertEquals(categorieProduit1, updatedCategorieProduit);
    }

    @Test
    public void testRetrieveCategorieProduit() {
        when(categorieProduitRepository.findById(1L)).thenReturn(Optional.of(categorieProduit));

        // Act
        CategorieProduit actualCategorieProduit = categorieProduitService.retrieveCategorieProduit(1L);

        // Assert
        assertEquals(categorieProduit, actualCategorieProduit);
    }
}
