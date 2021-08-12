package JupiterNotebook;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int i=0; i<dataList.size()-1; i++)/*한번 반복할 때마다 정렬이 될꺼여서 n-1번 반복 */{
            boolean swap = false;   //더 이상 정렬할게 없을 때를 표시하기 위한 불리언데이터 선언

            for(int j=0; j<dataList.size()-1-i; j++)/*한번 돌때 안에 데이터 갯수만큼 반복.*/ {
                if (dataList.get(j) > dataList.get(j + 1))/*리스트의 j번째 자리수가 j+1보다 크다면*/ {
                    Collections.swap(dataList, j, j + 1);//스왑처리.
                    swap = true;//스왑
                }
            }

            if(swap==false){
                break;//더 이상 스왑할게 없다면 반복문을 돌릴필요가 없어 빠져나온다.
            }
        }
        return  dataList;
    }

    public static void main(String[] args){
        BubbleSort sort = new BubbleSort();
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i=0; i<100; i++) {
            dataList.add((int)(Math.random()*100));
        }

        System.out.println(sort.sort(dataList));

    }



}
