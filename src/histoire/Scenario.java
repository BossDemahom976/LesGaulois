package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain minus = new Romain("Minus", 6);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois obelix = new Gaulois("Ob�lix", 1000);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);

		
		panoramix.parler("Je vais aller pr�parer une petite potion... ");

		panoramix.preparerPotion();

		panoramix.booster(obelix);

		panoramix.booster(asterix);
		


		asterix.parler("Bonjour");

		minus.parler("UN GAU... UN GAUGAU...");

		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}
