package personnages;

public class Romain {
    private String nom;
    private int force;

    public Romain(String nom, int force) {
        assert force > 0 : "La force d'un Romain doit être positive.";
        this.nom = nom;
        this.force = force;
    }

    public void recevoirCoup(int forceCoup) {
    	assert force > 0 : "La force d'une Romain doit être positive.";
    	int invariant = force;
        force -= forceCoup;
        if (force > 0) {
            parler("Aïe !");
        } else {
            parler("J'abandonne...");
        }
        assert invariant > force : "Un coup doit diminuer la force du romain.";
    }

    public void parler(String texte) {
        System.out.println(nom + ": " + texte);
    }
    
    public String getNom() {
		return nom;
	}

    public static void main(String[] args) {
        Romain minus = new Romain("Minus", 6); 
    }

	
}

