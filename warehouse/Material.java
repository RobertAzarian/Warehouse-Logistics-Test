package com.azrob.warehouse;

public enum Material {
	IRON_ORE(0, "Iron Ore", "Made from substance using a synthesizer.", "Iron_Ore.jpg", 1000),
	IRON_PLATE(1, "Iron Plate", "Made from iron ore using a press.", "Iron_Plate.jpg", 1000),
	IRON_ROD(2, "Iron Rod", "Made from an iron plate using a cutter.", "Iron_Rod.jpg", 1000);
	
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
	
	
	public void increaseMaxQuantity(int quantity) {
		maxQuantity += quantity;
	}
}
