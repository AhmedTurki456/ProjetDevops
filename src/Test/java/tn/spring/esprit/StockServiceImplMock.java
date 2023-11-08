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

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class StockServiceImplMock {

    @SpringBootTest
    @TestMethodOrder(OrderAnnotation.class)
    @ExtendWith(MockitoExtension.class)
    class UserServiceImplMock {
        @Mock
        StockRepository stockRepository;
        @InjectMocks
        StockServiceImpl stockService;
        Stock stock = new Stock("lb", 1, 1);
        List<Stock> listUsers = new ArrayList<Stock>() {
            {
                add(new Stock("lb1",1,1));
                add(new Stock("lb2",1,1));
            }
        };
        @Test
        public void testRetrieveStock() {
            Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
            List<Stock> stock1 = stockService.retrieveAllStocks();
            Assertions.assertNotNull(stock1);
        }
    }
}
