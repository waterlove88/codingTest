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
		
//		Arrays.sort(strs, new Comparator<String>() {
//			public int compare(String s1, String s2) {
//				// 비교할 두 수 중 작은 길이를 구한다.				
//				int minLength = 0;
//				if(s1.length() > s2.length()) {
//					minLength = s2.length();
//				} else {
//					minLength = s1.length();
//				}
//				
//				// 각 자리를 비교(두 수 중 작은 길이까지)
//				for(int i=0; i<minLength; i++) {
//					if(s1.charAt(i) < s2.charAt(i)) {
//						return 1;
//					} else if(s1.charAt(i) > s2.charAt(i)){
//						return -1;
//					}
//				}
//				
//				// 각 자리를 비교해 길이가 같으면 
//				if(s1.charAt(s1.length()-1) < s2.charAt(s2.length()-1)) {
//					return 1;
//				} else if(s1.charAt(s1.length()-1) > s2.charAt(s2.length()-1)){
//					return -1;
//				} else {
//					if(s1.length() < s2.length()) {
//						return -1;
//					} else {
//						return 1;
//					}
//				}
//			}
//		});
		
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
