package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	private String texte;

	public Romain(String nom, int force) {
		assert force > 0 : "La force d'un Romain doit être positive.";
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
	}

//    public void recevoirCoup(int forceCoup) {
//    	assert force > 0 : "La force d'une Romain doit Ãªtre positive.";
//    	int invariant = force;
//        force -= forceCoup;
//        if (force > 0) {
//            parler("AÃ¯e !");
//        } else {
//            parler("J'abandonne...");
//        }
//        assert invariant > force : "Un coup doit diminuer la force du romain.";
//    }

	public void parler(String texte) {
		System.out.println(nom + ": " + texte);
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if (equipements[i] != null) {
					if (equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
					}
					if (equipements[i].equals(Equipement.CASQUE)) {
						resistanceEquipement += 5;
					}
				}
				i++;
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public String getNom() {
		return nom;
	}

	public void sEquiper(Equipement equipement) {
		String soldat = "Le soldat ";
		switch (nbEquipement) {
		case 2:
			System.out.println(soldat + nom + " est déjà  bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println(soldat + nom + " posséde déjà un " + equipement + " !");
			} else {
				equiperSoldat(equipement);
			}
			break;
		case 0:
			equiperSoldat(equipement);
			break;
		default:
			System.out.println(soldat + "a un nombre d'équipement impossible");
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

	public int getForce() {
		// TODO Auto-generated method stub
		return force;
	}

}
