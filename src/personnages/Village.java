package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageois = 0;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		} else {
			System.out.println("Le village est déjà plein !");
		}
	}

	private void afficherVillageois() {
		int count=0;
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		while (villageois[count] != null) {
			System.out.println("- " + villageois[count].getNom());
			count = count + 1;
		}
	}
		

	public static void main(String[] args) {
		Village village = new Village("Le village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		On obtient ceci car la liste des habitants du village ne contient pas 30 personnes
		Chef chef = new Chef("Abraracourcix", 6, village);
		village.setChef(chef);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		Gaulois gaulois = village.trouverHabitant(0);
//		System.out.println((gaulois.getNom()));
//		System.out.println(gaulois);
//		Ces lignes provoquent une erreur car il n'y a aucun villageois à l'indice 1
		Gaulois obelix = new Gaulois("Ob�lix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();

	}
}
