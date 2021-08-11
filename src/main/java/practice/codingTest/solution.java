package practice.codingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

class Solution {
    public String solution() {
        String answer = "";

        String[] participant =  {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion  = {"josipa", "filipa", "marina", "nikola"};

        Hashtable<Integer,String > participantMap = new Hashtable<>();
        Hashtable<Integer,String > completionMap = new Hashtable<>();


        for(int i=0; i < participant.length; i++) {
            participantMap.put(i, participant[i]);
        }

        for(int i=0; i < completion.length; i++) {
            completionMap.put(i, completion[i]);
        }

        while(participantMap.keySet().iterator().hasNext()){
            System.out.println("ㅋㅋ?");
            String parKey = participantMap.keySet().iterator().next().toString();
            System.out.println(parKey);
            while (completionMap.keySet().iterator().hasNext()){
                System.out.println("gg?");
                String comKey = participantMap.keySet().iterator().next().toString();
                System.out.println(comKey);
                if(parKey.equals(comKey)){
                    participantMap.remove(parKey);
                    completionMap.remove(comKey);
                }
            }
            break;
        }


        if(!participantMap.isEmpty()) {
                if(participantMap.keys().hasMoreElements()){
                    answer = participantMap.values().toString();
                }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution test = new Solution();

        System.out.println("정답 "+test.solution());
    }
}

