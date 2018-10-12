package programmers.level2;

import java.util.Arrays;

/*
 * https://www.welcomekakao.com/learn/courses/30/lessons/42747
 * H-Index
 */
public class H_Index {
	public static void main(String[] args) {
		// length : 논문 갯수
		// 각 원소 : 인용 횟수
		int[] citations = {3, 0, 6, 1, 5};
		int answer = 0;
		
		Arrays.sort(citations);
		
		for(int i=0; i<citations.length; i++) {
			System.out.print(citations[i] + " ");
		}
		System.out.println();
		
        for(int i=0; i<citations.length; i++) {
            if(citations.length - i <= citations[i]) {
            	answer = citations.length - i;
            	break;
            }
        }
        
        System.out.println(answer);
	}
}
