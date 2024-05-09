package com.azrob.warehouse;

import java.util.Scanner;

public class Player {
	private Scanner scanner = new Scanner(System.in);
	private WarehouseManager warehouseManager = new WarehouseManager();
	private boolean isPlaying;
	
	public void play() {
		isPlaying = true;
		System.out.print("""
				================================================================
				#               Welcome to Warehouse Managment!                #
				================================================================
				""");
		
		while(isPlaying) {
			System.out.println("\n    Main Menu:");
			System.out.println("\t1. Manage Warehouse");
			System.out.println("\t2. Create Warehouse");
			System.out.println("\t3. Delete Warehouse");
			System.out.println("\t4. Show All Warehouses");
			System.out.println("\t0. Exit");
			System.out.print("    Enter: ");
			
			int choice = getPlayersChoice();
			System.out.println();
			
			switch (choice) {
				case 1:
					this.chooseWarehouse();
					break;
				
				case 2:
					this.createWarehouse();
					break;
					
				case 3:
					this.deleteWarehouse();
					break;

				case 4:
					this.showWarehouses();
					break;
					
				case 0:
					isPlaying = false;
					break;
				default:
					System.out.println("        [Input Error!]");
			}
			System.out.println("________________________________________________________________");
		}
	}
	
	
	private void chooseWarehouse() {
		if (warehouseManager.areThereAnyWarehouses()) {
			System.out.println("Which is the warehouse number to choose?");
			int id = getPlayersChoice();
			if (warehouseManager.isWarehouseExsists(id)) {
				System.out.println("Warehouse №-" + id + " was selected.");
				warehouseManager.manageWarehouse(id); // !!!
			} else {
				System.out.println("Warehouse number " + id + " does not exist.");
			}
		} else {
			System.out.println("There are no warehouses.");
		}
	}
	
	
	private void createWarehouse() {
		System.out.println(warehouseManager.createWarehouse());
	}
	
	
	private void deleteWarehouse() {
		if (warehouseManager.areThereAnyWarehouses()) {
			System.out.println("Which is the warehouse number for demolition?");
			int id = getPlayersChoice();
			System.out.println(warehouseManager.deleteWarehouse(id));
		} else {
			System.out.println("There are no warehouses.");
		}
	}
	
	
	private void showWarehouses() {
		if (warehouseManager.areThereAnyWarehouses()) {
			System.out.println(warehouseManager.getListOfAllWarehouses());
		} else {
			System.out.println("There are no warehouses.");
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







