package personnages;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements; 
    private int nbEquipement;

    public Romain(String nom, int force) {
        assert force > 0 : "La force d'un Romain doit être positive.";
        this.nom = nom;
        this.force = force;
        this.equipements = new Equipement[2];
        this.nbEquipement = 0;
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
    
    private void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
                } else {
                    equiperSoldat(equipement); // Appel à la méthode pour éviter la duplication
                }
                break;
            case 0:
                equiperSoldat(equipement); // Appel à la méthode pour éviter la duplication
                break;
        }
    }
    
    private void equiperSoldat(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement += 1;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
    }

    public static void main(String[] args) {
        Romain minus = new Romain("Minus", 6); 
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.BOUCLIER);
    }

	
}

