package com.ecommerce.microcommerce;
import static org.junit.Assert.assertEquals;

import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.controller.ProductController;
import org.junit.Test;


public class TestProductController {
    @Test
    public void testCalculerMargeProduit() {
        ProductController pc = new ProductController();
        Product p = new Product(42, "Joyland", 25, 10);
        assertEquals(15, pc.calculerMargeProduit(p));
    }
}
