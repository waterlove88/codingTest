package programmers.level2;

import java.util.Arrays;

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
					
		// h의 최대 값은 length
		for(int i=0; i<=citations.length; i++) {
			int target = 0;
			for(int j=0; j<citations.length; j++) {
				if(citations[j] >= i) {
					target++;
				}
			}
			
			if((target >= i) && (citations.length - target <= i)) {
				answer = i;
			} else {
				break;
			}
		}
		
		System.out.println(answer);
	}
}
