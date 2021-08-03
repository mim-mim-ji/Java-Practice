package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrSum {

	/*
	 * int[]arr = {2,5,3,8,1}
	 * int k=3 , int t=11
	 * k개 이상의 원소들을 arr배열에서 뽑아
	 * 그 숫자들의 합이 t이하가 되는 경우의 수를 구하라
	 * 단, 순서대로 뽑아야함
	 * (답은 6)
	 * 
	 * k <= arr.length
	 * 
	 * k=3인 경우
	 * [2,5,3] = 10 *
	 * [2,5,8] = 15 
	 * [2,5,1] = 8 *
	 * [2,3,8] = 13 
	 * [2,3,1] = 6 *
	 * [2,8,1] = 11 *
	 * [5,3,8] = 16 
	 * [5,3,1] = 9 *
	 * [5,8,1] = 14
	 * [3,8,1] = 12
	 * 
	 * k=4인 경우
	 * [2,5,3,8] = 18 
	 * [2,5,3,1] = 11 *
	 * [2,5,8,1] = 16
	 * [2,3,8,1] = 14
	 * [5,3,8,1] = 17
	 * 
	 * k는 1~15이하
	 */

	public static void main(String[] args) {
		int[]arr = {2,5,3,8,1};
		int k=3;
		int t=11;
		System.out.println(solution(arr, k, t));
	}

	static int answer = 0;
	public static int solution(int[]arr,int k, int t) {
		
        boolean[] visited = new boolean[arr.length];
 
        //1. 백트래킹을 이용해 구현
        System.out.println("-------- 1. 백트래킹 ---------");
    
        for(int r = k; r <= arr.length; r++) {
        	System.out.println("\n" + arr.length + "개 중에 " + r  + "개 뽑음");
            comb1(arr, visited, 0, r,t);
        }
        
        return answer;
       
	}
	
	//1. 백트래킹을 이용해 구현
    static void comb1(int[] arr, boolean[] visited, int start, int r,int t) {
        if(r == 0) { //r개의 숫자를 다 뽑은 경우
            print(arr, visited,t);
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true; //이미 한개 뽑음
                comb1(arr, visited, i + 1, r - 1,t); //nCr = n-1Cr-1 + n-1Cr
                visited[i] = false; //n-1Cr
            }
        }
    }
   
 
    //요소 합 구해서 비교
    static void print(int[] arr, boolean[] visited,int t) {
    	int sum = 0;
    	
        for(int i = 0; i < arr.length; i++) {       	
            if(visited[i] == true) {
            	System.out.print(arr[i] + " ");
            	sum += arr[i];
            }          
        }
        System.out.println("합은:"+sum);
        if(sum<=t) {
        	answer++;
        }
        System.out.println();
    }
    
    public static int solution2(int[]arr,int k, int t) {
    	
    	boolean[] visited = new boolean[arr.length];
    	 //2. 재귀를 이용해 구현
        System.out.println("\n---------- 2. 재귀 ----------");
        
        for(int r = 1; r <= arr.length ; r++) {
        	System.out.println("\n" + arr.length + "개 중에 " + r  + "개 뽑음");
            comb2(arr, visited, 0, r, t);
        }
		
		return answer;
    }

    //2. 재귀를 이용해 구현
    static void comb2(int[] arr, boolean[] visited, int depth, int r,int t) {
        if(r == 0) {
            print(arr, visited ,t);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            comb2(arr, visited, depth + 1, r - 1,t);
 
            visited[depth] = false;
            comb2(arr, visited, depth + 1, r,t);
        }
    }

}
