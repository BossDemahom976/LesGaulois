package personnages;

public class Gaulois {
	private String nom;
//	private int force;
	private int effetPotion = 1;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];

	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + "  envoie  un  grand  coup  dans  la m�choire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		force = force * forcePotion;
		if (forcePotion == 6) {
			parler("Merci Druide, je sens que ma force est 6 fois d�cupl�e.");
		}
	}

	public static void main(String[] args) {

		Gaulois asterix = new Gaulois("Ast�rix", 8);

		System.out.println(asterix.getNom());

		System.out.println(asterix);

		System.out.println(asterix.prendreParole());

		asterix.parler("Coucou");

		Romain jules = new Romain("Jules", 5);

		asterix.frapper(jules);

		asterix.boirePotion(3);
	}
}
