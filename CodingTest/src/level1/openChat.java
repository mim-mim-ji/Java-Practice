package megabox;

import java.util.*;

public class openChat {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
				"Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution3(record)));

	}

	public static String[] solution(String[] record) {
		Map<String, String> map = new HashMap<String, String>();

		int size = 0; //Enter와 Leave의 개수를 셀 변수

		for(String rec : record) {			
			String conditon = rec.split(" ")[0];
			String key = rec.split(" ")[1];

			if(! conditon.equals("Leave")) {		
				map.put(key, rec.split(" ")[2]);				
			}		
			if(! conditon.equals("Change")) {
				size++;
			}
		}

		String[] answer = new String[size]; //answer의 크기는 위에서 선언한 size

		int i=0;
		for(String rec : record) {			
			String conditon = rec.split(" ")[0];
			String key = rec.split(" ")[1];
			if(conditon.equals("Enter")) {
				answer[i++] = map.get(key)+"님이 들어왔습니다.";
			}else if(conditon.equals("Leave")){
				answer[i++] = map.get(key)+"님이 나갔습니다.";
			}
		}

		return answer;
	}


	public static String[] solution2(String[] record) {
		Map<String, String> idMap = new HashMap<>();
		List<String[]> result = new LinkedList<>();

		for (String records : record) {
			String[] keyWord = records.split(" ");

			if (keyWord[0].equals("Enter")) { // 들어오면 id 맵에 저장후, result에 추가
				idMap.put(keyWord[1], keyWord[2]);
				result.add(keyWord);

			} else if (keyWord[0].equals("Change")) { // 닉네임 업데이트만
				idMap.put(keyWord[1], keyWord[2]);
			} else { // 나가면 result에만 추가 
				result.add(keyWord);
			}
		}

		String[] answer = new String[result.size()];
		int idx = 0;
		for (String[] keyWords : result){
			String nickName = idMap.get(keyWords[1]);

			if (keyWords[0].equals("Enter")) { 
				answer[idx++] = nickName + "님이 들어왔습니다.";
			} else {
				answer[idx++] = nickName + "님이 나갔습니다.";
			}
		}
		return answer;
	}

	
	public static String[] solution3(String[] record) {
		String coms, uid, nick="";
		StringTokenizer st;
		
		int cnt=record.length; //answer배열 크기
		HashMap<String, String> map= new HashMap<>();;

		for(int i=0; i<record.length; i++) {
			st= new StringTokenizer(record[i]);
			coms= st.nextToken();
			uid= st.nextToken();
			
			if(!coms.equals("Leave")) {
				nick= st.nextToken();
				map.put(uid, nick);
			}

			if(coms.equals("Change")) cnt--; 
		}

		String[] answer= new String[cnt];
		int idx=0;
		for(String rec:record) {
			st= new StringTokenizer(rec);
			coms= st.nextToken();
			uid= st.nextToken();
			if(coms.equals("Enter")) answer[idx++]= map.get(uid)+"님이 들어왔습니다.";
			else if(coms.equals("Leave")) answer[idx++]= map.get(uid)+"님이 나갔습니다.";
		}

		return answer;
	}

}
