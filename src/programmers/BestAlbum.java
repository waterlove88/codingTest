package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BestAlbum {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop", "a"};
		int[] plays = {500, 600, 500, 500, 2500, 3000};
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		HashMap<String, TreeMap<String, Integer>> hashmap = new HashMap<String, TreeMap<String, Integer>>();
		HashMap<String, Integer> total = new HashMap<String, Integer>();
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
				
		for(int i=0; i<genres.length; i++) {
			if(hashmap.get(genres[i]) == null) {
				hashmap.put(genres[i], new TreeMap<String, Integer>());
				hashmap.get(genres[i]).put(String.valueOf(i), plays[i]);
				total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
			} else {
				hashmap.get(genres[i]).put(String.valueOf(i), plays[i]);
				total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
			}
		}
		
		for (String genre : total.keySet()) {
			tmap.put(total.get(genre), genre);
			ValueComparator bvc = new ValueComparator(hashmap.get(genre));		
			TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);
			sorted_map.putAll(hashmap.get(genre));
			hashmap.put(genre, sorted_map);
		}
		
		for (int play : tmap.descendingKeySet()) {			
			int count = 0;
			for(String num : hashmap.get(tmap.get(play)).keySet()) {
				if(count < 2) {
					a.add(Integer.parseInt(num));
					count++;
				}
			}
		}
		
		for(int i=0; i<a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
	}
}

class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;
     
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }
 
    public int compare(String a, String b) {
        if (base.get(a) > base.get(b)) {
            return -1;
        } else {
        	return 1;
        }
    }
}
