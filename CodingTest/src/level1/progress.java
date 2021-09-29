package megabox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class progress {

	public static void main(String[] args) {
		int[]progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(progresses,speeds)));
		System.out.println(Arrays.toString(solution2(progresses,speeds)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
	       
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=progresses.length-1;i>-1;i--){
            int remain = 100 - progresses[i];
            double day = Math.ceil((double)remain / speeds[i]);
            stack.add((int)day);
        }
        System.out.println(stack);
        
        while(!stack.isEmpty()){
            int cnt = 1;
            int top = stack.pop();
            while(!stack.isEmpty() && stack.peek()<=top){
                cnt++;
                stack.pop();
            }
            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
	
	public static int[] solution2(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();

        int temp = 0;
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int current = (int)Math.ceil((double)remain / speeds[i]);
            System.out.println(current);
            if (temp < current) {
                temp = current;
                list.add(1);
            } else {
            	list.set(list.size() - 1, list.get(list.size() - 1) + 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
