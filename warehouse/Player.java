package com.azrob.warehouse;

import java.util.Scanner;

public class Player {
	Scanner scanner = new Scanner(System.in);
	WarehouseManager warehouseManager = new WarehouseManager();
	boolean isPlaying;
	int choice = -1;
	
	public void play() {
		isPlaying = true;
		System.out.print("""
				================================================================
				#               Welcome to Warehouse Managment!                #
				================================================================
				""");
		
		while(isPlaying) {
			System.out.println("\n    Choose an action:");
			System.out.println("\t1. Choose Warehouse");
			System.out.println("\t2. Create Warehouse");
			System.out.println("\t3. Delete Warehouse");
			System.out.println("\t4. Show All Warehouses");
			System.out.println("\t0. Exit");
			System.out.print("    Enter: ");
			
			choice = scanner.nextInt(); //!
			
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
	
	
	
	public void chooseWarehouse() {
		if (warehouseManager.areThereAnyWarehouses()) {
			int id = scanner.nextInt(); 	//!

			if (warehouseManager.isWarehouseExsists(id)) {
				System.out.println("Warehouse №-" + id);
			}
		} else {
			System.out.println("There are no warehouses.");
		}
		System.out.println("Which is the warehouse number to choose?");
	}
	
	public void createWarehouse() {
		warehouseManager.createWarehouse();
	}
	
	public void deleteWarehouse() {
		System.out.println("Which is the warehouse number for demolition?");
		int id = scanner.nextInt(); 	//!
		warehouseManager.deleteWarehouse(id);
	}
	
	public void showWarehouses() {
		System.out.println(warehouseManager.getListOfAllWarehouses());
	}
}






































//
//System.out.print("""
//		================================================================
//		#               Welcome to Warehouse Managment!                #
//		================================================================
//		""");