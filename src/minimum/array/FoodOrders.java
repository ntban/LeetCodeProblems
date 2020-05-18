package minimum.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FoodOrders {
	public List<List<String>> displayTable(List<List<String>> orders) {
		List<List<String>> result = new ArrayList<>();

		HashMap<String, Integer> mapOrders[] = new HashMap[501];
		HashSet<String> foods = new HashSet<>();
		for (int i = 0; i < orders.size(); i++) {
			List<String> order = orders.get(i);
			int tableNum = Integer.parseInt(order.get(1));
			if (mapOrders[tableNum] == null) {
				mapOrders[tableNum] = new HashMap<String, Integer>();
			}
			foods.add(order.get(2));
			String key = order.get(2);
			if (mapOrders[tableNum].containsKey(key)) {
				mapOrders[tableNum].put(key, mapOrders[tableNum].get(key) + 1);
			} else {
				mapOrders[tableNum].put(key, 1);
			}
		}

		ArrayList<String> foodNames = new ArrayList<>(foods);
		Collections.sort(foodNames);

		ArrayList<String> titles = new ArrayList<>();
		titles.add("Table");
		for (int i = 0; i < foodNames.size(); i++) {
			titles.add(foodNames.get(i));
		}
		result.add(titles);
		for (int i = 1; i <= 500; i++) {
			if (mapOrders[i] != null) {
				ArrayList<String> order = new ArrayList<>();
				order.add(i + "");
				for (String key : foodNames) {
					int t = 0;
					if (mapOrders[i].containsKey(key)) {
						t = mapOrders[i].get(key);
					}
					order.add(t + "");
				}
				result.add(order);
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		String s[][] = { { "David", "3", "Ceviche" }, { "Corina", "10", "Beef Burrito" },
				{ "David", "3", "Fried Chicken" }, { "Carla", "5", "Water" }, { "Carla", "5", "Ceviche" },
				{ "Rous", "3", "Ceviche" } };
		List<List<String>> orders = new ArrayList<>();
		for (String e[] : s) {
			List<String> order = new ArrayList<>();
			for (String ee : e)
				order.add(ee);
			orders.add(order);
		}
		List<List<String>> result = new FoodOrders().displayTable(orders);
		for(List<String> e:result) {
			for(String ee:e) {
				System.out.print(ee+", ");
			}
			System.out.println();
		}
	}
}
