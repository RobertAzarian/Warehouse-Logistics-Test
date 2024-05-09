package com.azrob.warehouse;

public enum Material {
	IRON_ORE(1, "Iron Ore", "Made from substance using a synthesizer.", "Iron_Ore.jpg", 1200),
	IRON_PLATE(2, "Iron Plate", "Made from iron ore using a press.", "Iron_Plate.jpg", 1400),
	IRON_ROD(3, "Iron Rod", "Made from an iron plate using a cutter.", "Iron_Rod.jpg", 800);
	// ...
	
	private final int id;
	private final String name;
	private final String description;
	private final String icon;
	private int maxQuantity;	
	
	Material(int id, String name, String description, String icon, int maxQuantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.maxQuantity = maxQuantity;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getIconLocation() {
		return icon;
	}
	
	public int getMaxQuantity() {
		return maxQuantity;
	}
	
	// feature not implemented
	public void increaseMaxQuantity(int quantity) {
		maxQuantity += quantity;
	}
}