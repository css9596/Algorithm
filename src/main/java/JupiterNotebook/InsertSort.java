package JupiterNotebook;

import java.util.ArrayList;
import java.util.Collections;

public class InsertSort {
    //삽입정렬
    //데이터 중 제일 작은데이터를 찾아서 맨 앞으로 위치 할 때 까지 위치를 변경함.
    /**
     * * 삽입 정렬은 두 번째 인덱스부터 시작
     * * 해당 인덱스(key 값) 앞에 있는 데이터(B)부터 비교해서 key 값이 더 작으면, B값을 뒤 인덱스로 복사
     * * 이를 key 값이 더 큰 데이터를 만날때까지 반복, 그리고 큰 데이터를 만난 위치 바로 뒤에 key 값을 이동
     * */
    public ArrayList<Integer> InsertSort(ArrayList<Integer> dataList){
        for(int index1 = 0; index1 < dataList.size()-1; index1++){
            for(int index2 = index1+1; index2>0; index2--){
                if(dataList.get(index2)<dataList.get(index2-1)){
                    Collections.swap(dataList, index2, index2-1);
                }else {
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args){
        InsertSort test = new InsertSort();

        ArrayList<Integer> dataList = new ArrayList<>();

        for(int i=0; i<100; i++){
            dataList.add((int)(Math.random()*100));
        }
        System.out.println(test.InsertSort(dataList));
    }
}
