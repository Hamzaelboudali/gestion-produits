package com.votrepackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProduitService {

    // Liste pour stocker les produits
    private final List<Produit> produits = new ArrayList<>();

    // Créer un nouveau produit
    public Produit createProduit(Produit produit) {
        // Vérifier si un produit avec le même ID ou nom existe déjà
        if (produits.stream().anyMatch(p -> p.getId().equals(produit.getId()) || p.getNom().equalsIgnoreCase(produit.getNom()))) {
            throw new IllegalArgumentException("Un produit avec le même ID ou nom existe déjà.");
        }
        
        // Vérifier que le prix et la quantité sont positifs
        if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité doivent être positifs.");
        }
        
        produits.add(produit);
        return produit;
    }

    // Lire un produit par son ID
    public Produit getProduitById(Long id) {
        Optional<Produit> produit = produits.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (produit.isPresent()) {
            return produit.get();
        }
        throw new IllegalArgumentException("Produit non trouvé pour l'ID : " + id);
    }

    // Mettre à jour un produit
    public Produit updateProduit(Produit produit) {
        Produit existingProduit = getProduitById(produit.getId());
        
        // Vérifier que le prix et la quantité sont positifs
        if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité doivent être positifs.");
        }
        
        // Mettre à jour les détails du produit
        existingProduit.setNom(produit.getNom());
        existingProduit.setPrix(produit.getPrix());
        existingProduit.setQuantite(produit.getQuantite());
        
        return existingProduit;
    }

    // Supprimer un produit par son ID
    public void deleteProduit(Long id) {
        Produit produit = getProduitById(id);
        produits.remove(produit);
    }

    // Lister tous les produits
    public List<Produit> getAllProduits() {
        return produits;
    }
}
