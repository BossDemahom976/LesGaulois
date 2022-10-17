package personnages;

import java.util.Random;;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void preparerPotion() {
		Random random = new Random();

		forcePotion = forcePotion + random.nextInt(effetPotionMax);

		while (forcePotion != 6) {
			forcePotion = forcePotion + random.nextInt(effetPotionMax);
		}

		parler("J'ai n'ai pas trouvé tous les ingredients, ma potion est seulement de force " + forcePotion);
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() != "Obélix") {
			gaulois.boirePotion(forcePotion);
		} else {
			parler("Non, Obélix !... Tu n'auras pas de potion magique ! ");
		}
	}

	public static void main(String[] args) {

		Druide panoramix = new Druide("Panoramix", 0, 9);

		panoramix.preparerPotion();

	}
}
