package tn.spring.esprit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

import java.util.List;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StockServiceImplTest {
    //@Autowired
    IStockService st;
    @Test
    @Order(1)
    public void testretrieveAllStocks()
    {
        List<Stock> listStocks = st.retrieveAllStocks();
        Assertions.assertEquals(0, listStocks.size());
    }


}
