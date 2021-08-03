package level2;

import java.util.*;

public class targetNumber {
	
	/*
	 *  -1+1+1+1+1 = 3
		+1-1+1+1+1 = 3
		+1+1-1+1+1 = 3
		+1+1+1-1+1 = 3
		+1+1+1+1-1 = 3
		
		DFS:깊이 우선 탐색법
	 */

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers,target)); //5

	}
	
	public static int solution(int[] numbers, int target) {
        int answer = Dfs(numbers,target, 0, 0);      
        return answer;
    }
	//시작을 numbers[0]부터 하는게 아니고 0부터 시작하기 때문에 0 + numbers[0] / 0 - numbers[0] 두 경우 모두 포함
	
	public static int Dfs(int[] numbers, int target, int index, int num) {
		if(index == numbers.length) {
			if(num == target) {
				System.out.println("탐색완료");
				return 1;
			}else return 0;
		}else {
			System.out.println(index); 
			System.out.println(num);
			System.out.println("---");
			return Dfs(numbers, target, index+1, num+numbers[index])
					+Dfs(numbers, target, index+1, num-numbers[index]);
			
		}		
	}
}
