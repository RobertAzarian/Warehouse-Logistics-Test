package com.azrob.warehouse;

import java.util.Map;
import java.util.TreeMap;

public class Warehouse {
	private int id;
	private Map<Material, Integer> materialsInStock = new TreeMap<>();		// <TypeOfMaterial, Quantity>
	
	Warehouse(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isWarehouseEmpty() {
		return materialsInStock.isEmpty();
	}
	
	public boolean checkMaterial(Material material) {
		return materialsInStock.get(material) != null;
	}
	
	public int countOfMaterial(Material material) {
		Integer count = materialsInStock.get(material);
		return count == null ? 0 : count;
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
	
	public int addMaterial(Material material, int count) {		// add material and returns the added quantity 
		int freeSpace = getAmountOfFreeSpace(material, count);
		if (count <= freeSpace) {
			int newCount = materialsInStock.get(material) == null ? count : materialsInStock.get(material) + count;
			materialsInStock.put(material, Integer.valueOf(newCount));
			return count;
		} else {
			materialsInStock.put(material, material.getMaxQuantity());
			return freeSpace;
		}
		
	}
	
	public void deleteMaterial(Material material, int count) {
		int newCount = materialsInStock.get(material) - count;
		if (newCount == 0) {
			materialsInStock.remove(material);
		} else {
			materialsInStock.put(material, newCount);
		}
	}
	
	public void sendToAnotherWarehouse(Material material, int count, Warehouse otherWarehouse) {
		deleteMaterial(material, count);
		otherWarehouse.addMaterial(material, count);
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