package com.ecommerce.microcommerce.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ProduitGratuitException extends RuntimeException {
    public ProduitGratuitException(String unProduit) {
        super("le prix de vente du produit " + unProduit + " est INVALIDE. Il doit être > 0 ");
    }
}
