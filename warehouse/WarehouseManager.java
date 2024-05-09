package com.azrob.warehouse;

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class WarehouseManager {
	Scanner scanner = new Scanner(System.in);
	private Map<Integer, Warehouse> warehouses = new TreeMap<>();
	private int id = 0;
	private int materialsInGame = Material.values().length;
	private Map<Integer, Material> listOfAllMaterials = new TreeMap<>();
	
	
	public WarehouseManager() {
		for (Material material : Material.values()) {
			listOfAllMaterials.put(material.getId(), material);
		}
	}
	
	public boolean isWarehouseExsists(int id) {
		return (null != warehouses.get(id));
	}
	
	public boolean areThereAnyWarehouses() {
		return !warehouses.isEmpty();
	}
	
	
	public void manageWarehouse(int id) {
		Warehouse choosenWarehouse = warehouses.get(id);
		boolean controlInProgress = true;
		while (controlInProgress) {
			System.out.println("\n    Warehouse №-" + id);
			System.out.println("\t1. Show All Materials");
			System.out.println("\t2. Add Material");
			System.out.println("\t3. Delete Material");
			System.out.println("\t4. Move materials to other warehouse");
			System.out.println("\t0. Back to Menu");
			System.out.print("    Enter: ");

			int choice = getPlayersChoice();
			System.out.println();
			
			switch (choice) {
				case 1:
					showAllMaterials(choosenWarehouse);
					break;
				
				case 2:
					addMaterial(choosenWarehouse);
					break;
					
				case 3:
					deleteMaterial(choosenWarehouse);
					break;

				case 4:
					moveToOtherWarehouse(choosenWarehouse);
					break;
					
				case 0:
					return;
				default:
					System.out.println("        [Input Error!]");
			}
			System.out.println("________________________________________________________________");
		}
	}
	
	
	public String createWarehouse() {
		id++;		
		warehouses.put(id, new Warehouse(id));
		return "Warehouse №-" + id + " was created.";
	}
	
	
	public String deleteWarehouse(int id) {
		if (warehouses.containsKey(id)) {
			warehouses.remove(id);
			return "Warehouse №-" + id + " was demolished.";
		} else {
			return "Warehouse №-" + id + " does not exist.";
		}
	}
	
	
	public String getListOfAllWarehouses() {
		StringBuilder list = new StringBuilder("");
		if (this.areThereAnyWarehouses()) {
			list.append("  All Warehouses:\n");
			for (int number : warehouses.keySet()) {
				list.append("Warehouse №-" + number + "\n");
			}
			return list.toString();
		} else {
			return "There are no warehouses.";
		}
	}
	
	
	private void showAllMaterials(Warehouse warehouse) {
		String allMaterialsList = warehouse.getAllMaterialsInStock();
		System.out.println("".equals(allMaterialsList) ? "The warehouse is empty." : allMaterialsList);
	}
	
	
	private void addMaterial(Warehouse warehouse) {
		System.out.println("    What material should be added?");
		for (Material material : Material.values()) {
			System.out.println("\t" + material.getId() + ". " + material.getName() + " - " + warehouse.countOfMaterials(material));
		}
		System.out.println("\t0. Cancel adding");
		
		int choice = getPlayersChoice();
		System.out.println();
		
		
		if (choice > 0 && choice <= materialsInGame) {
			System.out.println("\n    How much materials to add? (maximum amount - " + listOfAllMaterials.get(choice).getMaxQuantity() + ")");
			int count = getPlayersChoice();
			if (count <= 0) {
				System.out.println("        [Input Error!]");
				return;
			}
			int wereAdded = warehouse.addMaterial(listOfAllMaterials.get(choice), count);
			System.out.println(wereAdded + " " + listOfAllMaterials.get(choice).getName() + " were added to warehouse №" + warehouse.getId());
		} else if (choice == 0) {
			return;
		} else {
			System.out.println("        [Input Error!]");
		}
	}
	
	
	private void deleteMaterial(Warehouse warehouse) {
		System.out.println("    What material should be deleted?");
		for (Material material : Material.values()) {
			System.out.println("\t" + material.getId() + ". " + material.getName() + " - " + warehouse.countOfMaterials(material));
		}
		System.out.println("\t0. Cancel deleting");
		
		int choice = getPlayersChoice();
		if (choice <= 0) {
			System.out.println("        [Input Error!]");
			return;
		}
		System.out.println();
		
		if (choice > 0 && choice <= materialsInGame && warehouse.checkMaterial(listOfAllMaterials.get(choice))) {	// Странный момент
			Material material = listOfAllMaterials.get(choice);
			int maxToDelete = warehouse.countOfMaterials(material);
			
			System.out.println("\n    How much materials to delete? (maximum to delete - " + maxToDelete + ")");
			int count = getPlayersChoice();
			if (count <= 0) {
				System.out.println("        [Input Error!]");
				return;
			}
			if (count <= maxToDelete) {
				warehouse.deleteMaterial(material, count);
			} else {
				System.out.println("There are not so many materials.");
			}
		} else {
			System.out.println("        [Input Error!]");
		}
	}
	
	
	private void moveToOtherWarehouse(Warehouse warehouse) {
		
		System.out.println("Which warehouse to transport materials to?");
		int id = getPlayersChoice();
		
		if (isWarehouseExsists(id) && id != warehouse.getId()) {
			Warehouse otherWarehouse = warehouses.get(id);
			System.out.println("    What material should be sent?");
			for (Material material : Material.values()) {
				System.out.println("\t" + material.getId() + ". " + material.getName() + " - " + warehouse.countOfMaterials(material));
			}
			System.out.println("\t0. Cancel sending");
			
			int choice = getPlayersChoice();
			System.out.println();
			
			if (choice > 0 && choice <= materialsInGame && warehouse.checkMaterial(listOfAllMaterials.get(choice))) {
				Material material = listOfAllMaterials.get(choice);
				int maxToSend = warehouse.countOfMaterials(material);
				
				System.out.println("\n    How much material to send? (maximum to send - " + maxToSend + ")");
				int count = getPlayersChoice();
				if (count <= 0) {
					System.out.println("        [Input Error!]");
					return;
				}
				
				if (count <= maxToSend) {
					warehouse.sendToAnotherWarehouse(material, count, otherWarehouse);
					System.out.println(count + " materials were sent from warehouse " + warehouse.getId() + " to warehouse " + id); 
				} else {
					System.out.println("There are not so many materials.");
				}
			} else {
				System.out.println("        [Input Error!]");
			}
		} else if (id == warehouse.getId()) {
			System.out.println("This is the same warehouse.");
		} else {
			System.out.println("Warehouse number " + id + " does not exist.");
		}
	}
	
	private int getPlayersChoice() {
		int choice;
		try {
			choice = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			choice = -1;
		}
		return choice;
	}
}