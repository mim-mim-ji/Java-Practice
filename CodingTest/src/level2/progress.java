package megabox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class progress {

	public static void main(String[] args) {
		int[]progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(progresses,speeds)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
	       
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=progresses.length-1;i>-1;i--){
            int remain = 100 - progresses[i];
            double day = Math.ceil((double)remain / speeds[i]);
            stack.add((int)day);
        }
        
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

}
