package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement;

	public Romain(String nom, int force) {
		if (force < 0) {
			throw new IllegalArgumentException("Force du romain negative" + force);
		}
		this.nom = nom;
		this.force = force;
		nbEquipement = 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert (force > 0) : "Force du romain negative";
//		int forceverif = force;
//		
//		force -= forceCoup;
//		
//		assert (force < forceverif);
//		
//		if (force > 0) {
//			parler("A�e ");
//		} else {
//			parler("J'abandonne...");
//		}
//	}

	private void ajouterEquipement(Equipement equipementAEquiper) {
		equipements[nbEquipement] = equipementAEquiper;
		System.out.println("Le soldat " + getNom() + " s'�quipe avec un " + equipementAEquiper.getNom() + ".");
		nbEquipement += 1;
	}

	public void sEquiper(Equipement equipementAEquiper) {

		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + getNom() + " est d�j� bien prot�g� !");
			break;

		case 1:
			if (equipementAEquiper.getNom() == equipements[0].getNom()) {
				System.out.println("Le soldat " + getNom() + " poss�de d�j� un " + equipementAEquiper.getNom() + ".");
				break;
			} else {
				ajouterEquipement(equipementAEquiper);
				break;
			}

		default:
			ajouterEquipement(equipementAEquiper);
			break;
		}
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
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;

	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement  de  " + nom + " s'envole sous la force du coup.");
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

	public static void main(String[] args) {

		Romain minus = new Romain("Minus", 6);

		minus.parler("Bonjour");

		minus.recevoirCoup(3);

		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;

		casque.toString();
		bouclier.toString();

		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(bouclier);

	}
}
