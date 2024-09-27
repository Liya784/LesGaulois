package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("AÃ¯e");
		} else {
			parler("J'abandonne...");
		}
	
	}
	public static void main(String[] args) {
		Romain caiminus = new Romain("Caiminus",9);
		System.out.println(caiminus.prendreParole());
		caiminus.parler("Je suis romain !");
		caiminus.recevoirCoup(7);
		caiminus.recevoirCoup(3);
	}
}
