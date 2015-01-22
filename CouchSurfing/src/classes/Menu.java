package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
	private String nom;
	private Map<String,String> liensMenu;
	
	public Menu(String nom){
		this.setNom(nom);
		this.liensMenu = new HashMap<String,String>();
	}
	
	public Map<String,String> getLiensMenu(){
		return this.liensMenu;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void addLien(String nom,boolean val){
		String lien = "#";
		if(val) {
			lien += nom.toLowerCase();
		}else lien = nom.toLowerCase();
		this.liensMenu.put(nom, lien);
	}
	
	public String cherch(){
		return "trouve";
	}
}

