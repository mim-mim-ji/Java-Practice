package level2;

import java.util.HashMap;
import java.util.Iterator;

public class Clothes {

	public static void main(String[] args) {

		String [][] clothes = 
			{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		int answer = 1;

		HashMap<String, Integer> map = new HashMap<String, Integer>();


		for(int i=0;i<clothes.length;i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		}			

		System.out.println(map);

		//경우의 수
		for(String items : map.keySet()) {
			answer *= map.get(items)+1;
		}

		return answer-1;
	}

	public static int solution2(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0;i<clothes.length;i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		}	
		
		Iterator<Integer> it = map.values().iterator(); //값의 집합은 Collection이므로 iterator()로 만듦
		
		while(it.hasNext()) {
			answer *= it.next().intValue()+1;
			System.out.println(answer);
		}
		return answer-1;
	}

}
