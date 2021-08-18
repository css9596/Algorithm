package JupiterNotebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    /**
     * 이진 탐색
     *  - 찾으려는 데이터와 정렬된 배열의 가운데 데이터를 대소비교하여 찾으려는 데이터가 있는지 찾는다.
     * 이진 탐색은 데이터가 정렬되있는 상태에서 진행
     * 데이터가 {2, 3, 8, 12, 20} 일 때,
     * searchFunc(data_list, find_data) 함수를 만들고
     * searchItem 찾는 숫자
     * dataList는 데이터 배열
     * dataList의 중간에 위치한 값을 searchItem 비교해서
     * searchItem < dataList 중간값 이라면
     * 맨 앞부터 data_list의 중간까지 에서 다시 searchItem 찾기
     * dataList의 중간값 < searchItem 이라면
     * dataList의 중간부터 맨 끝까지에서 다시 searchItem 찾기
     * 그렇지 않다면, data_list의 중간값은 searchItem 인 경우로, return dataList 중간위치
     * */
    public Boolean binaryFunc(ArrayList<Integer> dataList, Integer searchItem){
        if(dataList.size() == 1 && searchItem == dataList.get(0)){
            return true;
        }else if(dataList.size() == 1 && searchItem != dataList.get(0)){
            return false;
        }else if(dataList.size() == 0){
            return false;
        }
        /*
        * 1. 데이터 정렬
        * 2. 정렬된 리스트의 가운데 인덱스의 데이터를 찾으려는 데이터와 비교 후 작으면 왼쪽, 크면 오른쪽으로 이동.
        * 3. 재귀호출을 통한 반복
        * 4. END
        * */
        ArrayList<Integer> sortedArr = new ArrayList<>();

        //1. 데이터 정렬
        sortedArr = quickFunc(dataList);
        //Collections.sort(dataList); //Collections.에서 제공

        //2. 가운데 데이터 산출.
        int mediumIndex = sortedArr.size() / 2;
        if(searchItem == dataList.get(mediumIndex)){
            return true;
        }else {
            //4. 데이터 비교 후 데이터 배열 이동.
            if (searchItem < sortedArr.get(mediumIndex))/*기준 데이터와 정렬된 데이터 중 가운데 데이터랑 비교 후 가운데 데이터가 작다면*/ {
                return this.binaryFunc(new ArrayList<>(sortedArr.subList(0, mediumIndex)), searchItem);
            } else {
                return this.binaryFunc(new ArrayList<>(sortedArr.subList(mediumIndex+1, sortedArr.size())), searchItem);
            }
        }
    }

    private ArrayList<Integer> quickFunc(ArrayList<Integer> dataList){
        if(dataList.size() <= 1){
            return dataList;
        }
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        int pivot = dataList.get(0);    //기준점을 잡고.

        for(int i=1; i<dataList.size(); i++){
            if(pivot > dataList.get(i)){
                leftArr.add(dataList.get(i));
            }else{
                rightArr.add(dataList.get(i));
            }
        }

        leftArr = new ArrayList<>(quickFunc(leftArr));
        rightArr = new ArrayList<>(quickFunc(rightArr));

        return mergeFunc(leftArr, pivot, rightArr);
    }


    private ArrayList<Integer> mergeFunc(ArrayList<Integer>leftArr, Integer pivot, ArrayList<Integer>rightArr){
        ArrayList<Integer> mergeArr = new ArrayList<>();

        mergeArr.addAll(leftArr);
        mergeArr.addAll(Arrays.asList(pivot));
        mergeArr.addAll(rightArr);

        return mergeArr;
    }

    public static void main(String[] args){
        BinarySearch test = new BinarySearch();
        ArrayList<Integer> dataList = new ArrayList<>();
        int serchData;
        boolean returnedData;

        for(int i=0; i<10; i++){
            dataList.add((int)(Math.random()*10));
        }

        System.out.println("배열 데이터 생성 "+dataList);

        serchData = 1;
        returnedData = test.binaryFunc(dataList, serchData);
        if(!returnedData){
            System.out.println("찾으시려는 데이터가 존재하지 않습니다.");
        }else{
            System.out.println("찾으시려는 데이터 ["+serchData+"](이)가 존재합니다.");
        }
    }

}
