package com.azrob.warehouse;

import java.util.Map;
import java.util.TreeMap;

public class Warehouse { // управляет своими процессами и материалами
	int id;
	int[] cellsWithID = new int[64];		// расположение ID всех материалов (с нулевым кол-ом).
	int countOfAllMaterialsInGame = Material.values().length;
	Map<Material, Integer> materialsInStock = new TreeMap<>(); // materials and their quantities <id, countOfMaterial> *countOfMat > 0
	// В скобочках treeMap можно настроить сортировку comparator!!!
	Warehouse(int id) {
		this.id = id;
		for (int i = 0; i < countOfAllMaterialsInGame; i++) {
			cellsWithID[i] = i;
		}
	}
	
	public String getAllMaterialsInfo() {
		return "";
	}
	
	public int getId() {
		return id;
	}
	
	public void add(Material material, int count) {
		System.out.println(materialsInStock.get(material));
		
//		if (materialsInStock.containsKey(material)) {
//			int newCount = materialsInStock.get(material) + count >= material.getMaxQuantity() ? 
//			materialsInStock.put(material, materialsInStock.get(material))
//			materialsInStock.
//			
//		} else {
//			if (count > material.getMaxQuantity() ?)
//				materialsInStock.put(material, count);
//		}
		
	}
	
	public void delete(Material material) {
		
	}
	
	public void moveTo(Material material, Warehouse otherWarehouse) {
		
	}
}


// создать фабричный класс:
// 		присваивает ID новому складу
// 		сохранение порядка склада при удалении, без перемещения объектов в массиве, а с изменением их ID

// 










//
//private Map<Material, Integer> materials = new TreeMap<>();		// list of materials and their quantities
//
//
//public Warehouse() {
//	id++;
//	
//}
//
//public getMaterial
