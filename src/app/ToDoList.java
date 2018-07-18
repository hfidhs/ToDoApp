package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ToDoList {
	
	private List<Item> items = new ArrayList<>();
	private Integer sequence = 0;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public int getSize() {
		return items.size();
	}
	
	public void addItem(Item item) {
		item.setId(sequence++);
		items.add(item);
	}
	
	public void deleteItem(Integer id) {
		items.removeIf(o -> o.getId() == id);
	}
	
	public List<Item> listItems() {
		return items;
	}

	public void addDueDateToItem(int id, Date dueDate) {
		Optional<Item> item = items.stream().filter(o -> o.getId() == id).findFirst();
		if (item.isPresent()) {
			item.get().setDueDate(dueDate);
		} else {
			throw new RuntimeException("Item " + id + " cannot be found.");
		}
	}
	
	public void addPriorityToItem(int id, int priority) {
		Optional<Item> item = items.stream().filter(o -> o.getId() == id).findFirst();
		if (item.isPresent()) {
			item.get().setPriority(priority);
		} else {
			throw new RuntimeException("Item " + id + " cannot be found.");
		}
	}

	public List<Item> searchByDescription(String keywords) {
		List<Item> searchResult = items.stream().filter(o -> o.getDescription().contains(keywords)).collect(Collectors.toList());
		return searchResult;
	}

}
