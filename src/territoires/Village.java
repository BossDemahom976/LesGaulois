package territoires;

import personnages.Chef;

public class Village {
	private String nom;
	private Chef chef;
	private int test;
	
	public Village(String nom) {
		this.nom = nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
}
