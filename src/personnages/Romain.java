package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement;
	

	public Romain(String nom, int force) {
		assert (force > 0) : "Force du romain negative";
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

	public void recevoirCoup(int forceCoup) {
		assert (force > 0) : "Force du romain negative";
		int forceverif = force;
		
		force -= forceCoup;
		
		assert (force < forceverif);
		
		if (force > 0) {
			parler("A�e ");
		} else {
			parler("J'abandonne...");
		}
	}
	
	private void ajouterEquipement(Equipement equipementAEquiper) {
		equipement[nbEquipement] = equipementAEquiper;
		System.out.println("Le soldat " + getNom() + " s'�quipe avec un " + equipementAEquiper.getNom() + "." );
		nbEquipement += 1;
	}
	
	public void sEquiper(Equipement equipementAEquiper) {
		
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + getNom() + " est d�j� bien prot�g� !");
			break;
		
		case 1:
			if(equipementAEquiper.getNom() == equipement[0].getNom()) {
				System.out.println("Le soldat " + getNom() + " poss�de d�j� un " + equipementAEquiper.getNom() + ".");
			break;
			}else {
				ajouterEquipement(equipementAEquiper);
				break;
			}
			
		default:
			ajouterEquipement(equipementAEquiper);
			break;
		}
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
