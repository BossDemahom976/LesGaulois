package territoires;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	
	public Village(String nom) {
		this.nom = nom;
	}
	
	public void setChef(Chef chef, int nbVillageosMaximum) {
		this.chef = chef;
		villageois = new Gaulois[nbVillageosMaximum];
		nbVillageois = 0;
		
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
			return villageois[numeroVillageois];
	}
	
	public static void main(String[] args) {
		Village village = new Village("Les Irréductibles");
	}
}
