package megabox;

import java.util.*;

public class printer {

	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 2;
		System.out.println(solution(priorities, location));
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();//int형 priorityQueue 선언
		priorityQueue.offer(2);     // priorityQueue에 값 2 추가
		priorityQueue.offer(1);     // priorityQueue에 값 1 추가
		priorityQueue.offer(3);     // priorityQueue에 값 3 추가
		System.out.println(priorityQueue.peek());    
	}
	
	public static int solution(int[] priorities, int location) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 1;
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        
        System.out.println(pq);
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) { 
                	System.out.println(i+"일때"+pq.peek());

                    if (i == location) { 
                        return answer;
                    }
                    pq.poll(); 
                    answer++;
                }
            }
        }
        return answer;
    }
	
	
	public static int solution2(int[] priorities, int location) {	
		int answer = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                location--;
                if(location <0)
                    break;
            }else{
                que.add(i);
                location--;
                if(location<0)
                    location=que.size()-1;
            }
        }

        return answer;
	}
}
