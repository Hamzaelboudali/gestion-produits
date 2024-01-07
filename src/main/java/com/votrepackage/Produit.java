package com.votrepackage;

public class Produit {
    // Attributs de la classe Produit
    private Long id;
    private String nom;
    private double prix;
    private int quantite;
    
    // Constructeur par défaut
    public Produit() {
    }
    
    // Constructeur avec tous les attributs
    public Produit(Long id, String nom, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }
    
    // Getters et Setters pour chaque attribut

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Méthode pour afficher les détails du produit
    @Override
    public String toString() {
        return "Produit{" +
               "id=" + id +
               ", nom='" + nom + '\'' +
               ", prix=" + prix +
               ", quantite=" + quantite +
               '}';
    }

    // Vous pouvez ajouter d'autres méthodes si nécessaire
}
