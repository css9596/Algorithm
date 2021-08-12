package practice.codingTest;

import java.util.*;

class Solution {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int data1 = 0; data1<dataList.size()-1; data1++){
            boolean sort = false;   //정렬종료를 위한 데이터 변수 추가.
            for(int data2 = 0; data2<dataList.size()-1-data1; data2++){
                if(dataList.get(data2)>dataList.get(data2+1)){
                    Collections.swap(dataList, data2, data2+1);
                    sort = true;
                }
            }

            if(sort == false){
                break;
            }
        }

        return dataList;
    }


    public static void main(String[] args){
        Solution test = new Solution();
        ArrayList<Integer> dataList = new ArrayList<>();

        for(int i = 0; i<100; i++){
            dataList.add((int)(Math.random()*100));
        }

        System.out.println("정답 "+test.sort(dataList));
    }
}

