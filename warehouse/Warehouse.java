package com.azrob.warehouse;

import java.util.Map;
import java.util.TreeMap;

public class Warehouse {
	int id;
	int[] cellsWithID = new int[64];		// расположение ID всех материалов (с нулевым кол-ом).
	int countOfAllMaterialsInGame = Material.values().length;
	Map<Integer, Integer> materialsInStock = new TreeMap<>(); // materials and their quantities <id, countOfMaterial> *countOfMat > 0
	// В скобочках treeMap можно настроить сортировку comparator!!!
	Warehouse(int id) {
		this.id = id;
		for (int i = 0; i < countOfAllMaterialsInGame; i++) {
			cellsWithID[i] = i;
		}
	}
	
	
	public void add(Material material) {
		
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
