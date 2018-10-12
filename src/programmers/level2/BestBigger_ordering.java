package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://www.welcomekakao.com/learn/courses/30/lessons/42746
 * 가장 큰 수
 */
public class BestBigger_ordering {
	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};	
		String answer = "";
		String[] strs = new String[numbers.length];
		
		for(int i=0; i<numbers.length; i++) {
			strs[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(strs, new Comparator<String>(){
	        public int compare(String s1, String s2){
	            return (s2+s1).compareTo(s1+s2);
	        }
	    });
		
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<strs.length; i++) {
			sb.append(strs[i]);
		}
		
		if(sb.toString().replace("0", "").equals("")) {
			answer = "0";
		} else {
			answer = sb.toString();
		}
		
		System.out.println(answer);	
	}
}
