package territoires;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	
	public Village(String nom, int nbVillageosMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageosMaximum];
		nbVillageois = 0;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant (Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			++nbVillageois;
		}else {
			System.out.println("Le village est plein !");
		}
	}
	
	public Gaulois trouverHabitant (int numeroVillageois) {
			assert (numeroVillageois >= 0 && numeroVillageois <= nbVillageois);
			return villageois[numeroVillageois];
	}
	
	public void afficherVillageois () {
		System.out.println("Dans le village du chef" + chef.getNom() + " vivent les légendaires gaulois : ");
		for(int i = 0; i < nbVillageois; ++i) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Les Irréductibles", 30);
	
		//Gaulois gaulois = village.trouverHabitant(30);
		//On obtient ArrayIndexOutOfBoundsExcption car 30 n'est pas une case du tableau villageois
		
		Chef chefduvillage = new Chef("Abraracourcix", 6, 0, village);
		
		village.setChef(chefduvillage);
		
		Gaulois asterix = new Gaulois("Asterix", 8);
		
		village.ajouterHabitant(asterix);
		
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//On obtient null car la case 1 du village pointe vers rien
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();
		
	}
}
