package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert (force > 0) : "Force du romain negative";
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
		assert (force > 0) : "Force du romain negative";
		int forceverif = force;
		
		force -= forceCoup;
		
		assert (force < forceverif);
		
		if (force > 0) {
			parler("Aïe ");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		
		Romain jules = new Romain("Jules", 6);
		
		jules.parler("Bonjour");
		
		jules.recevoirCoup(3);
	}
}
