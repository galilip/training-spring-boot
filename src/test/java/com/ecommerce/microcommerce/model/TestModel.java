package com.ecommerce.microcommerce.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestModel {
    private Product produit;

    @Before
    public void setUp() {
        produit = new Product(1, "La La Land - Damien Chazelle", 9,5);
    }

    /**
     * Product's ID
     * @result l'id du produit
     */
    @Test
    public void getId() {
        assertEquals(1, produit.getId());
        assertNotEquals(42, produit.getId());
    }

    /**
     * Product's ID
     * @result change l'id du produit
     */
    @Test
    public void setId() {
        produit.setId(42);
        assertEquals(42, produit.getId());
        assertNotEquals(1, produit.getId());
    }

    /**
     * Product's Name
     * @result le nom du produit
     */
    @Test
    public void getNom() {
        assertEquals("La La Land - Damien Chazelle", produit.getNom());
        assertNotEquals("Les parapluies de Cherbourg - Jacques Demy", produit.getNom());
    }

    /**
     * Product's Name
     * @result change le nom du produit
     */
    @Test
    public void setNom() {
        produit.setNom("Les parapluies de Cherbourg - Jacques Demy");
        assertEquals("Les parapluies de Cherbourg - Jacques Demy", produit.getNom());
        assertNotEquals("La La Land - Damien Chazelle", produit.getNom());
    }

    /**
     * Product's Price
     * @result le prix du produit
     */
    @Test
    public void getPrix() {
        assertEquals(9, produit.getPrix());
        assertNotEquals(42, produit.getPrix());
    }

    /**
     * Product's Price
     * @result change le prix du produit
     */
    @Test
    public void setPrix() {
        produit.setPrix(42);
        assertEquals(42, produit.getPrix());
        assertNotEquals(9, produit.getPrix());
    }

    /**
     * Product's BuyingPrice
     * @result le prix du produit
     */
    @Test
    public void getPrixAchat() {
        assertEquals(5, produit.getPrixAchat());
        assertNotEquals(42, produit.getPrixAchat());
    }

    /**
     * Product's BuyingPrice
     * @result change le prix du produit
     */
    @Test
    public void setPrixAchat() {
        produit.setPrixAchat(42);
        assertEquals(42, produit.getPrixAchat());
        assertNotEquals(5, produit.getPrixAchat());
    }

    /**
     * Product's toString
     * @result retourne une chaine de caractère avec tous les attributs de l'objet
     */
    @Test
    public void ProduitToString() {
        assertEquals("Product{id=1, nom='La La Land - Damien Chazelle', prix=9}", produit.toString());
    }




}


