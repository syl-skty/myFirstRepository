package example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestLinkedHashMap {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		Set<Integer> set = new HashSet<>();
		set.add(1);
		List<Integer> list = new ArrayList<>(set);
		System.out.println(list);
		Set<Entry<Integer, String>> entry = map.entrySet();
		Map<Integer, String> map1 = new LinkedHashMap<>(map);
	}
}
