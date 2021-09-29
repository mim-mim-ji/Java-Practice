package megabox;

import java.util.*;

public class sort {

	public static void main(String[] args) {
		
		//Arrays.sort() - 오름차순
		int[] arr1 = {3,6,1,4,2,7,5};
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		String[] arr_st = {"a","c","e","z"};
		//Arrays.sort(arr_st,Collections.reverseOrder());
		
		Arrays.sort(arr_st,(o1,o2)->o1.compareTo(o2));
		System.out.println(Arrays.toString(arr_st));
		
		//Arrays.sort() - 내림차순
		Integer[] arr2 = {3,6,1,4,2,7,5};
		//Arrays.sort(arr2,Collections.reverseOrder());
//		Arrays.sort(arr2,new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2-o1;
//			}
//		});
		Arrays.sort(arr2,(o1,o2)->o2-o1);
		System.out.println(Arrays.toString(arr2));
		

		//Collections.sort()
		ArrayList<String> list = new ArrayList<>();
		
		list.add("A"); list.add("1"); list.add("c");
		list.add("가"); list.add("3");
		
		Collections.sort(list);
		System.out.println(list); //[1, 3, A, c, 가]
		
		Collections.reverse(list);
		System.out.println(list); //[가, c, A, 3, 1]
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		}); 
				
		Collections.sort(list,(o1,o2)->o2.compareTo(o1));
		
		
		//set -> ArrayList -> Array
		HashSet<Integer> set = new HashSet<>(); //Set
		set.add(1); set.add(2);
		set.add(3); set.add(4);
		set.add(5);
		
		System.out.println(set);//순서X,중복X
		
		ArrayList<Integer> lst = new ArrayList<>(set); //Set -> ArrayList
		
		int[] answer = new int[lst.size()];

		for(int i = 0; i < lst.size(); i++) { //ArrayList -> Array
			answer[i] = lst.get(i);
		}
		
		int[] sol = set.stream().sorted().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(sol));
		
		int[] answer2 = lst.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(answer2));
		
	}

}
