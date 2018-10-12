package programmers.level2;

import java.math.BigInteger;
import java.util.HashMap;

/*
 * https://www.welcomekakao.com/learn/courses/30/lessons/42578
 * 위장
 */
public class Camouflage {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		BigInteger answer = BigInteger.ONE;
		
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		
		for(String[] c : clothes) {
			hashmap.put(c[1], hashmap.getOrDefault(c[1], 0) + 1);
		}
		
		if(hashmap.keySet().size() > 1) {
			for(int value : hashmap.values()) {
				answer = answer.multiply(combination(value+1, 1));
			}
			System.out.println(answer.subtract(BigInteger.ONE).intValue());
		}
		for(int value : hashmap.values()) {
			answer = combination(value, 1);
		}
		
		System.out.println(answer.intValue());
	}
	
	private static BigInteger combination(int n, int r) {
		return factorial(n).divide(factorial(n-r).multiply(factorial(r)));
	}
	
	private static BigInteger factorial(int n) {
		if(n == 0 || n == 1) {
			return BigInteger.ONE;
		}		
		
		BigInteger result = BigInteger.valueOf(n);
		for(int i=n; i>=2; i--) {
			result = result.multiply(BigInteger.valueOf(i-1));
		}
		
		return result;
	}
}