package JupiterNotebook;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SequentialSearch {
    /**
     * 순차 탐색
     * 탐색이란?
     *  - 여러 데이터 중 원하는 데이터를 찾는 것.
     * 순차탐색
     *  - 여러 데이터 중 내가 원하는 데이터를 앞에서부터 하나씩 찾아가는 것.
     * */
    public int searchFunc(ArrayList<Integer>dataList, Integer searchItem){
        if(dataList.isEmpty()){
            return -1;
        }

        for(int i=0; i<dataList.size(); i++){
            if(searchItem == dataList.get(i)){
                return 0;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        SequentialSearch test = new SequentialSearch();

        ArrayList<Integer> dataList = new ArrayList<>();
        int searchYn;
        int searchItem = 73;

        for(int i=0; i<100; i++){
            dataList.add((int)(Math.random()*100));
        }
        System.out.println("생성된 배열 "+dataList);
        searchYn = test.searchFunc(dataList, searchItem);
        if(searchYn == -1){
            System.out.println("원하는 데이터가 존재하지 않습니다.");
        }else {
            System.out.println("원하는 데이터"+searchItem+"을 찾았습니다.");
        }
    }

}
