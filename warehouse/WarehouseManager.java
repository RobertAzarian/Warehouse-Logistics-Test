package com.azrob.warehouse;

import java.util.Map;
import java.util.TreeMap;

public class WarehouseManager {
	private Map<Integer, Warehouse> warehouses = new TreeMap<>();
	private static int id = 0;
	
	public void createWarehouse() {
		id++;		
		warehouses.put(id, new Warehouse(id));
	}
	
	public void deleteWarehouse(int id) {
		warehouses.remove(id);
	}
	
	public boolean areThereAnyWarehouses() {
		return warehouses.isEmpty();
	}
	
	public boolean isWarehouseExsists(int id) {
		return (null != warehouses.get(id));
	}
	
	public String getListOfAllWarehouses() {
		StringBuilder list = new StringBuilder("");
		if (!warehouses.isEmpty()) {
			for (int number : warehouses.keySet()) {
				list.append("Warehouse №-" + number + "\n");
			}
		} else {
			return "No warehouses";
		}
		
		return list.toString();
	}	
}



//public Warehouse getWarehouseByID(int id) {
//	return warehouses.get(id);
//}


//public class WarehouseManagement {
//	private Warehouse[] warehouses = new Warehouse[8]; // стоит заменить на менее объемозатратное
//	private static int id = -1;
//	
//	public void createWarehouse() {
//		id++;
//		if (id >= warehouses.length) {		// увеличение массива на 50%, для создания новых складов 
//			Warehouse[] tmpWarehouses = new Warehouse[warehouses.length + (warehouses.length / 2)];
//			for (int i = 0; i < warehouses.length; i++) {
//				tmpWarehouses[i] = warehouses[i];
//			}
//			warehouses = tmpWarehouses;
//		}
//		
//		warehouses[id] = new Warehouse(id);
//	}
//	
//	public void deleteWarehouse(int id) {
//		warehouses[id] = null;
//	}
//	
//	public Warehouse getWarehouseByID(int id) {
//		return warehouses[id];
//	}
//}