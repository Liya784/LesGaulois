package personnages;

public enum Equipement {
    CASQUE("casque"),
    BOUCLIER("bouclier");

    private String nom;

    // Constructeur avec un paramètre d'entrée pour initialiser l'attribut nom
    Equipement(String nom) {
        this.nom = nom;
    }

    // Méthode toString qui affiche le nom de l'énumération
    @Override
    public String toString() {
        return nom;
    }
}