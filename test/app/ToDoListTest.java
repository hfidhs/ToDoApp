package app;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import app.Item;
import app.ToDoList;

public class ToDoListTest {

	@Test
	public void testListItems() {
		// setup
		ToDoList toDoList = new ToDoList();
		Item item1 = new Item("item 1", 1, new Date());
		Item item2 = new Item("item 2", 2, null);
		Item item3 = new Item("item 3", null, null);
		toDoList.addItem(item1);
		toDoList.addItem(item2);
		toDoList.addItem(item3);

		// exercise
		List<Item> allItems = toDoList.listItems();

		// verify
		assertEquals(3, allItems.size());
	}

	@Test
	public void testAddItem() {
		// setup
		ToDoList toDoList = new ToDoList();
		Item item1 = new Item("item 1", 1, new Date());
		Item item2 = new Item("item 2", 2, null);
		Item item3 = new Item("item 3", null, null);

		// exercise
		toDoList.addItem(item1);
		toDoList.addItem(item2);
		toDoList.addItem(item3);

		// verify
		assertEquals(3, toDoList.getSize());
	}

	@Test
	public void testDeleteItem() {
		// setup
		ToDoList toDoList = new ToDoList();
		Item item1 = new Item("item 1", 1, new Date());
		Item item2 = new Item("item 2", 2, null);
		Item item3 = new Item("item 3", null, null);
		toDoList.addItem(item1);
		toDoList.addItem(item2);
		toDoList.addItem(item3);

		// exercise
		toDoList.deleteItem(0);

		// verify
		assertEquals(2, toDoList.getSize());
	}

	@Test
	public void testAddDueDateToItem() throws ParseException {
		// setup
		ToDoList toDoList = new ToDoList();
		Item item1 = new Item("item 1", 1, new Date());
		Item item2 = new Item("item 2", 2, null);
		Item item3 = new Item("item 3", null, null);
		toDoList.addItem(item1);
		toDoList.addItem(item2);
		toDoList.addItem(item3);

		// exercise
		SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		toDoList.addDueDateToItem(1, df.parse("01-01-2018"));

		// verify
		assertEquals("01-01-2018", df.format(item2.getDueDate()));
	}

	@Test
	public void testAddPriorityToItem() {
		// setup
		ToDoList toDoList = new ToDoList();
		Item item1 = new Item("item 1", 1, new Date());
		Item item2 = new Item("item 2", 2, null);
		Item item3 = new Item("item 3", null, null);
		toDoList.addItem(item1);
		toDoList.addItem(item2);
		toDoList.addItem(item3);

		// exercise
		toDoList.addPriorityToItem(2, 100);

		// verify
		assertEquals(100, item3.getPriority().intValue());
	}

	@Test
	public void testSearchItems() {
		// setup
		ToDoList toDoList = new ToDoList();
		Item item1 = new Item("item 1", 1, new Date());
		Item item2 = new Item("item 2", 2, null);
		Item item3 = new Item("item 3", null, null);
		toDoList.addItem(item1);
		toDoList.addItem(item2);
		toDoList.addItem(item3);

		// exercise
		List<Item> searchResult = toDoList.searchByDescription("3");

		// verify
		assertEquals("item 3", searchResult.get(0).getDescription());
	}

}
