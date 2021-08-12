package practice.codingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class Solution {
    public int solution() {
        int answer = 0;

        String[][] clothes = {{"yellowhat", "headgear"}, //0,1
                              {"bluesunglasses", "eyewear"}, //1,1
                              {"green_turban", "headgear"}}; //2,1

        Map<String, Integer> kinds = new HashMap<>();
        Map<String, Integer> clothesName = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            kinds.put(clothes[i][1], i);
            clothesName.put(clothes[i][0], i);
        }
        System.out.println(kinds.toString());
        System.out.println(clothesName.toString());

        System.out.println(clothesName.size());



        answer += clothesName.size();

        return answer;
    }

    public static void main(String[] args){
        Solution test = new Solution();

        System.out.println("정답 "+test.solution());
    }
}

