package minimum.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PeopleIndexs {
	public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		HashMap<Integer, HashSet<String>> mapList = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for (Integer i = 0; i < favoriteCompanies.size(); i++) {
			HashSet<String> current = new HashSet<>();
			for (int j = 0; j < favoriteCompanies.get(i).size(); j++) {
				String key = favoriteCompanies.get(i).get(j);
				current.add(key);
			}
			boolean add = true;
			for (Integer key : mapList.keySet()) {
				HashSet<String> map = mapList.get(key);
				if (map.containsAll(current)) {
					add = false;
					break;
				}
				if (current.containsAll(map)) {
					mapList.remove(map);
					result.remove(key);
				}
			}
			if (add) {
				mapList.put(i, current);
				result.add(i);
			}
		}
		return result;
	}
}
