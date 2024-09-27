package personnages;

public class Village {

	public Village(String nom, Chef chef, Gaulois[] villageois, int nbVillageois,int nbVillageoisMaximum) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = villageois;
		this.nbVillageois = nbVillageois;
	}

	private String nom;
	private Chef chef;
	private Gaulois villageois[];
	private int nbVillageois = 0;

	public Village(String nom) {
		this.nom = nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	private void ajouterHabitant(Gaulois gaulois) {
		villageois.length();
		
	}
	
	
	
	
}
