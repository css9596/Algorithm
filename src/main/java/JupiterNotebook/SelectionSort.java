package JupiterNotebook;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {

    /**
     * 선택정렬(SelectionSort)란?
     * 데이터 중 가장작은 데이터를 찾아 맨 앞의 위치로 옮기면서 정렬하는 방식.
     * */

    public ArrayList<Integer> selectionSort(ArrayList<Integer> dataList){
        int lower;
        for(int stand = 0; stand <dataList.size()-1; stand++){
            lower = stand;
            for(int index = stand+1; index<dataList.size(); index++){
                if(dataList.get(lower)>dataList.get(index)){
                    lower = index;
                }
            }
            Collections.swap(dataList, lower, stand);
        }

        return dataList;
    }


    public static void main(String[] args){
        SelectionSort test = new SelectionSort();
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i=0; i<100; i++){
            dataList.add((int) (Math.random()*100));
        }
        System.out.println(test.selectionSort(dataList));
    }
}
