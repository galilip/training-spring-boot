package com.ecommerce.microcommerce.controller;
import static org.junit.Assert.assertEquals;

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
    private Product produit;
    private Product produit2;
    private Product produit3;

    @Before
    public void setUp() {
        listeProduits = new ArrayList<>();
        produit = new Product(1, "Ordinateur portable", 350, 120);
        produit2 = new Product(2, "Aspirateur Robot", 500,200);
        produit3 = new Product(3, "Table de Ping Pong", 750, 450);

        listeProduits.add(produit);
        listeProduits.add(produit2);
        listeProduits.add(produit3);


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

        assertEquals(expected.getValue(), produits.getValue());

    }
}
