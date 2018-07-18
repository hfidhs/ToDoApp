import java.util.ArrayList;
import java.util.Scanner;

import app.Item;
import app.ToDoList;

public class MainClass {
	
	public static ToDoList toDoList = new ToDoList();
	
	public static void main(String[] args){
		boolean exit = false;
		do {
			showMenu();
			int input = readInput();
			if (input==9) exit=true;
		} while (!exit);
	}
	
	public static void showMenu(){
		System.out.println("Welcome to To Do List Application");
		showCurrentList();
		System.out.println("Menu: ");
		System.out.println("1. List all to do list");
		System.out.println("2. Add new item");
		System.out.println("3. Delete an item");
		System.out.println("4. Mark an item as complete");
		System.out.println("9. Quit");
		System.out.print("Enter your choice: ");
	}
	
	public static int readInput(){
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();	
		
		switch(input){
		case 1:
			System.out.println("1");
			break;
			
		case 2:
			System.out.println("2");
			Item item = new Item("item", null, null);
			toDoList.addItem(item);
			break;
			
		case 3:
			System.out.println("3");
			break;
			
		case 9:

			break;
		default:
			System.out.println("Invalid choice");
		}
		
		
		return input;
	}
	
	public static void showCurrentList(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Fix bug no 1");
		list.add("Fix bug no 2");
		list.add("Fix bug no 3");
		
		for (String s : list){
			System.out.println(s);
		}
		
	}
}
