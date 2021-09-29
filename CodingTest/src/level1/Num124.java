package megabox;

public class Num124 {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(solution(n));
	}

	//124나라의 숫자
	/* 1 = 1
	 * 2 = 2
	 * 3 = 4
	 * 4 = 11
	 * 5 = 12
	 * 6 = 14
	 * ...
	 * 1 % 3 = 1 -> 1
	 * 2 % 3 = 2 -> 2
	 * 3 % 3 = 0 -> 4
	 * 5 / 3 = 1
	 * 5 % 3 = 2
	 * 5 = 3*1 + 2 => 12
	 */
	
	 public static String solution(int n) {
		 String answer = "";
		 
		 String[] numbers = {"4","1","2"};
		 
		 int num = n;
	      
	      while(num > 0){
	          int remainder = num % 3;
	          num /= 3;
	          
	          if(remainder == 0) num--;
	          
	          answer = numbers[remainder] + answer;
	          System.out.println(answer);
	      }
	      
	      return answer;
	 }
}
