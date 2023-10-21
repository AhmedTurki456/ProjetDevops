package tn.spring.esprit;







import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class FourniseurImplMock {
    @SpringBootTest
    @TestMethodOrder(OrderAnnotation.class)
    @ExtendWith(MockitoExtension.class)
    class UserServiceImplMock {
        @Mock
        FournisseurRepository fournisseurRepository;

        @InjectMocks
        FournisseurServiceImpl fournisseurService;
        Fournisseur fournisseur = new Fournisseur("f1","f2");
        List<Fournisseur> listUsers = new ArrayList<Fournisseur>() {
            {
                add(new Fournisseur("f5","f6"));
                add(new Fournisseur("f3","f4"));
            }
        };

        @Test
        public void TestFourniseurRetrevie() {
            Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
            List<Fournisseur> fournisseur1 = fournisseurService.retrieveAllFournisseurs();
            Assertions.assertNotNull( fournisseur1);
        }
    }
    }




































