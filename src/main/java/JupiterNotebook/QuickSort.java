package JupiterNotebook;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    /**
     * QuickSort : 퀵정렬
     * 데이터를 분할/정렬을 동시에 함으로써 빠르게 정렬하는 방법.
     * 기준점(pivot)을 기준으로 작은 데이터는 왼쪽배열, 큰 데이터는 오른쪽배열에 각 재귀호출을 통하여 저장
     * 더 이상 나눌 수 없을 때 왼쪽 배열 + 기준점 + 오른쪽 배열 순으로 저장하는 식으로 정렬한다.
     * */

    //나누는 연습.
    public void split(){
        //첫번째 데이터를 기준으로 작은 데이터는 왼쪽리스트, 큰 데이터는 오른쪽리스트로 정렬하기.
        ArrayList<Integer> dataList = new ArrayList<>(Arrays.asList(8,1,3,5,7,9,11));

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        int standard = 0;
        for(int i=0; i<dataList.size(); i++){
            standard = dataList.get(0);
            if(i!=0){
                if(standard>dataList.get(i)){
                    leftList.add(dataList.get(i));
                }else{
                    rightList.add(dataList.get(i));
                }
            }
        }
        System.out.println("기준데이터 ["+standard+"]을 기준으로 왼쪽데이터 ["+leftList+"] 오른쪽데이터["+ rightList+"]");
    }

    //QuickSort Method 구현
    public ArrayList<Integer> quickSortFunc(ArrayList<Integer> dataList){
        if(dataList.size() <= 1){
            return dataList;
        }
        System.out.println("dataList  "+dataList+" ");
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        int pivot = dataList.get(0);

        System.out.println("기준점 [ "+pivot+" ]");

        for(int i=1; i<dataList.size(); i++){
            if(pivot > dataList.get(i)){
                leftList.add(dataList.get(i));
            }else{
                rightList.add(dataList.get(i));
            }
        }
        System.out.println("LeftList  "+leftList+" ");
        System.out.println("RightList  "+rightList+" ");
        leftList = this.quickSortFunc(new ArrayList<>(leftList));
        rightList = this.quickSortFunc(new ArrayList<>(rightList));

        return this.mergeFunc(leftList, pivot, rightList);
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, int pivot, ArrayList<Integer> rightList){
        ArrayList<Integer> mergedList = new ArrayList<>();

        mergedList.addAll(leftList);
        mergedList.addAll(Arrays.asList(pivot));
        mergedList.addAll(rightList);

        System.out.println("MERGED "+mergedList);
        return mergedList;
    }


    public static void main(String[] args){
        QuickSort test = new QuickSort();

        ArrayList<Integer> dataList = new ArrayList<>();

        for(int i=0; i<10; i++){
            dataList.add((int)(Math.random()*10));
        }

        System.out.println(test.quickSortFunc(dataList));
    }
}
