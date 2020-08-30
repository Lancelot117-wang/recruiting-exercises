package main;

import java.util.HashMap;

public class InventoryDistribution {
	private String name;
	private HashMap<String, Integer> inventory;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Integer> getInventory() {
		return inventory;
	}
	public void setInventory(HashMap<String, Integer> inventory) {
		this.inventory = inventory;
	}
	public String toString() {
		return "{name=" + this.name + "," + "inventory=" + this.inventory.toString() + "}";
	}
}
