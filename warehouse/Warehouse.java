package com.azrob.warehouse;

import java.util.Map;
import java.util.TreeMap;

public class Warehouse {
	int id;
	Map<Material, Integer> materialsInStock = new TreeMap<>();
	
	Warehouse(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAllMaterialsInStock() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (Map.Entry<Material, Integer> pair : materialsInStock.entrySet()) {
			count++;
			sb.append(count + ". " + pair.getKey().getName() + " - " + pair.getValue() + " (Max-" + pair.getKey().getMaxQuantity() + ")\n");
		}
		return sb.toString();
	}
	
	public void add(Material material, int count) {		// max - 1000		450		650		.550.
		int freeSpace = getAmountOfFreeSpace(material, count);
		if (count <= freeSpace) {
			int newCount = materialsInStock.get(material) == null ? count : materialsInStock.get(material) + count;
			materialsInStock.put(material, Integer.valueOf(newCount));
		} else {
			materialsInStock.put(material, freeSpace);
		}
	}
	
	public void delete(Material material) {
		
	}
	
	public void moveTo(Material material, int count, Warehouse otherWarehouse) {
		
	}
	
	private int getAmountOfFreeSpace(Material material, int count) {
		Integer inStock = materialsInStock.get(material);
		if (inStock == null) {
			return material.getMaxQuantity();
		} else {
			return material.getMaxQuantity() - inStock;
		}
	}
}