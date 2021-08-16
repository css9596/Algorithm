package JupiterNotebook;

import java.util.ArrayList;

public class MergeSort {
    /**
     * 병합 정렬
     * 나눌 수 없을 때까지 나누고 데이터를 다시 조합하면서 정렬.
     * 재귀용법을 이용하여 처리한다.
     * */

    public static void main(String[] args){
        MergeSort sort = new MergeSort();

        //sort.split(new ArrayList<>(Arrays.asList(1,3,5,7,9,12)));   //asList : ArrayList의 데이터를 배열형태로 만들어준다.
        ArrayList<Integer> testArr = new ArrayList<>();
        for(int i=0; i<100; i++){
            testArr.add((int)(Math.random()*100));
        }
        System.out.println(sort.mergeSplit(testArr));
    }

    //배열을 분할하는 Method 연습.
    public void split(ArrayList<Integer> dataList){
        if(dataList.size() <= 1){
            return;
        }
        int mediumIndex = dataList.size() / 2;

        ArrayList<Integer> firstArray = new ArrayList<>(dataList.subList(0, mediumIndex));  //0번 index부터 mediumIndex -1의 배열 아이템을 sublist에 적재.
        ArrayList<Integer> secondArray = new ArrayList<>(dataList.subList(mediumIndex, dataList.size()));

        System.out.println(firstArray);
        System.out.println(secondArray);
    }

    //재귀용법을 통한 분할 Method
    private ArrayList<Integer> mergeSplit(ArrayList<Integer> dataList){
        if(dataList.size() <= 1){
            return dataList;
        }

        int medium = dataList.size()/2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = this.mergeSplit(new ArrayList<>(dataList.subList(0, medium)));
        rightArr = this.mergeSplit(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return this.mergeFunc(leftArr, rightArr);
    }

    //분할된 데이터를 정렬하는 로직 추가.
    private ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr){
            /**
             * 목표: leftList 와 rightList 의 배열 데이터를 정렬하며 합쳐서, mergedList 라는 이름으로 return 하기
             * leftList 와 rightList 는 이미 정렬된 상태 또는 데이터가 하나임
             * ArrayList 만들기
             * leftPoint, rightPoint = 0
             * CASE1: leftList, RightList 둘 다 있을 때
             * while (leftList.size() > leftPoint && rightList.size() > rightPoint)
             * 만약 leftPoint 나 rightPoint 가 이미 leftList 또는 rightList 배열을 다 순회했다면, 그 반대쪽 데이터를 그대로 넣고, 해당 인덱스 1 증가
             * if (leftList.get(leftPoint) > rightList.get(rightPoint))
             * mergedList.add(rightList.get(rightPoint));
             * rightPoint += 1;
             * else:
             * mergedList.add(leftList.get(leftPoint));
             * leftPoint += 1;
             * CASE2: RightList 만 없을 때: 나머지 LeftList 에 있는 데이터를 그대로 mergedList 뒤에 넣음
             * CASE3: LeftList 만 없을 때: 나머지 RightList 에 있는 데이터를 그대로 mergedList 뒤에 넣음
             *
             * */
            ArrayList<Integer> mergedList = new ArrayList<>();

            int leftPoint = 0;  //좌측 배열의 index
            int rightPoint = 0; //우측 배열의 index

            //CASE1 : leftArr, rightArr이 둘다 있을 때
            while (leftArr.size()>leftPoint && rightArr.size()>rightPoint){
                if(leftArr.get(leftPoint)>rightArr.get(rightPoint))/*오른쪽 배열의 데이터가 작다면*/{
                    mergedList.add(rightArr.get(rightPoint));//정렬할 리스트에 오른쪽 배열의 데이터를 적재 후
                    rightPoint++;//pointer 증가.
                }else /*반대의 경우*/{
                    mergedList.add(leftArr.get(leftPoint));//정렬할 리스트에 왼쪽 배열의 데이터를 적재 후
                    leftPoint++;//pointer 증가.
                }
            }
            //CASE2 : RightArr만 없을 때
            while (leftArr.size()>leftPoint){
                mergedList.add(leftArr.get(leftPoint));
                leftPoint++;
            }
            //CASE3 : LeftArr만 없을 때
            while (rightArr.size()>rightPoint){
                mergedList.add(rightArr.get(rightPoint));
                rightPoint++;
            }

            return mergedList;
    }

}
