package com.ecommerce.microcommerce.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.controller.ProductController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductController {

    @Autowired
    ProductController controller;

    private ArrayList<Product> listeProduits;
    private ArrayList<Product> sortProduits;
    private Product produit;
    private Product produit2;
    private Product produit3;

    @Before
    public void setUp() {
        listeProduits = new ArrayList<>();
        sortProduits = new ArrayList<>();

        produit = new Product(1, "Ordinateur portable", 350, 120);
        produit2 = new Product(2, "Aspirateur Robot", 500,200);
        produit3 = new Product(3, "Table de Ping Pong", 750, 450);

        listeProduits.add(produit);
        listeProduits.add(produit2);
        listeProduits.add(produit3);

        sortProduits.add(produit2);
        sortProduits.add(produit);
        sortProduits.add(produit3);

    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCalculerMargeProduit() {
        MappingJacksonValue produits = controller.calculerMargeProduits();
        ArrayList<String> marges = new ArrayList<>();

        marges.add(listeProduits.get(0).toString() + ":"+230);
        marges.add(listeProduits.get(1).toString() + ":"+300);
        marges.add(listeProduits.get(2).toString() + ":"+350);

        MappingJacksonValue expected = new MappingJacksonValue(marges);

        //test case
        assertEquals(expected.getValue(), produits.getValue());
    }

    @Test
    public void testTriParOrdreAlphabetique() {
        // les valeurs attendues
        MappingJacksonValue expected = controller.trierProduitsParOrdreAlphabetique();
        // la liste triée au préalable
        MappingJacksonValue sorted = new MappingJacksonValue(sortProduits);
        // la liste non triée au préalable
        MappingJacksonValue unsorted = new MappingJacksonValue(listeProduits);

        // test tri ok
        assertEquals(expected.getValue().toString(), sorted.getValue().toString());
        // test nont trié
        assertNotEquals(expected.getValue().toString(), unsorted.getValue().toString());
    }
}
