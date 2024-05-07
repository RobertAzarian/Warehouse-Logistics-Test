package com.azrob.warehouse;

public class WarehouseManagement {
	private Warehouse[] warehouses = new Warehouse[8]; // стоит заменить на менее объемозатратное
	private static int id = -1;
	
	public void createWarehouse() {
		id++;
		if (id >= warehouses.length) {		// увеличение массива на 50%, для создания новых складов 
			Warehouse[] tmpWarehouses = new Warehouse[warehouses.length + (warehouses.length / 2)];
			for (int i = 0; i < warehouses.length; i++) {
				tmpWarehouses[i] = warehouses[i];
			}
			warehouses = tmpWarehouses;
		}
		
		warehouses[id] = new Warehouse(id);
	}
	
	public void deleteWarehouse(int id) {
		warehouses[id] = null;
	}
	
	public Warehouse getWarehouseByID(int id) {
		return warehouses[id];
	}
}
