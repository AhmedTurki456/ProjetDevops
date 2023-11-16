package tn.spring.esprit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProduitServiceImplTest {
    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    private ProduitServiceImpl produitService;

    private Produit sampleProduit;
    private Stock sampleStock;

    @Before
    public void setUp() {
        sampleProduit = new Produit();
        sampleProduit.setIdProduit(1L);
        sampleProduit.setLibelleProduit("Sample Produit");

        sampleStock = new Stock();
        sampleStock.setIdStock(1L);
        sampleStock.setLibelleStock("Sample Stock");
    }

    @Test
    public void testRetrieveAllProduits() {
        List<Produit> produits = new ArrayList<>();
        produits.add(sampleProduit);

        when(produitRepository.findAll()).thenReturn(produits);

        List<Produit> result = produitService.retrieveAllProduits();

        assertEquals(1, result.size());
        assertEquals("Sample Produit", result.get(0).getLibelleProduit());

        verify(produitRepository, times(1)).findAll();
    }

    @Test
    public void testAddProduit() {
        when(produitRepository.save(any(Produit.class))).thenReturn(sampleProduit);

        Produit result = produitService.addProduit(sampleProduit);

        assertEquals(1L, result.getIdProduit().longValue());
        assertEquals("Sample Produit", result.getLibelleProduit());

        verify(produitRepository, times(1)).save(any(Produit.class));
    }

}










