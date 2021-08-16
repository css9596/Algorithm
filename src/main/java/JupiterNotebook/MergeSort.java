package JupiterNotebook;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    /**
     * 병합 정렬
     * 나눌 수 없을 때까지 나누고 데이터를 다시 조합하면서 정렬.
     *
     * */

    public static void main(String[] args){
        MergeSort sort = new MergeSort();


        sort.split(new ArrayList<>(Arrays.asList(1,3,5,7,9,12)));   //asList : ArrayList의 데이터를 배열형태로 만들어준다.
    }


    public void split(ArrayList<Integer> dataList){
        if(dataList.size() <= 1){
            return;
        }
        int mediumIndex = dataList.size() / 2;

        ArrayList<Integer> firstArray = new ArrayList<>(dataList.subList(0, mediumIndex));
        ArrayList<Integer> secondArray = new ArrayList<>(dataList.subList(mediumIndex, dataList.size()));

        System.out.println(firstArray);
        System.out.println(secondArray);
    }

}
