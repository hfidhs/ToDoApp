import java.util.ArrayList;
import java.util.Scanner;

import app.Item;
import app.ToDoList;

public class MainClass {

	public static ToDoList toDoList = new ToDoList();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean exit = false;
		System.out.println("Welcome to To Do List Application");
		do {
			showMenu();
			int input = readInput();
			if (input == 9)
				exit = true;
		} while (!exit);
	}

	public static void showMenu() {
		System.out.println("\nMenu: ");
		System.out.println("1. List all to do list");
		System.out.println("2. Add new item");
		System.out.println("3. Delete an item");
		System.out.println("4. Mark an item as complete");
		System.out.println("9. Quit");
		System.out.print("Enter your choice: ");
	}

	public static int readInput() {
		int input = -1;
		try {
			input = scanner.nextInt();
			scanner.nextLine();
		} catch(Exception e) {
			System.out.println("Invalid choice");
		} 

		switch (input) {
		case 1:
			showCurrentList();
			break;

		case 2:
			System.out.println("Please enter description for item: ");
			String description = scanner.nextLine();
			Item item = new Item(description, null, null);
			toDoList.addItem(item);
			showCurrentList();
			break;

		case 3:
			System.out.println("Please enter item id to delete: ");
			int itemId = scanner.nextInt();
			toDoList.deleteItem(itemId);
			showCurrentList();
			break;

		case 9:

			break;
		default:
			System.out.println("Invalid choice");
		}

		return input;
	}

	public static void showCurrentList() {
		for (Item item : toDoList.getItems()) {
			System.out.println(item.toString());
		}
	}
}
